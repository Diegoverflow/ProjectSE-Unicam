package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.*;
import it.unicam.cs.diciottoPolitico.casotto.repository.OrdinazioneBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service delle ordinazioni bar.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleOrdinazioneBar} interagendo con il relativo
 * {@link OrdinazioneBarRepository}.
 *
 * @see SimpleOrdinazioneBar
 * @see OrdinazioneBarRepository
 */
@Service
public class OrdinazioneBarService extends AbstractService<SimpleOrdinazioneBar, OrdinazioneBarRepository> {

    private final RigaCatalogoBarService barService;
    private final NotificaService notificaService;
    private final UtenteService utenteService;
    private final RigaCatalogoOmbrelloneService ombrelloniService;

    /**
     * Crea un service per le ordinazioni iniettando il repository degli articoli bar, i service delle notifiche e degli ombrelloni e il repository delle ordinazioni bar specificati.
     *  @param repository        il repository delle ordinazioni bar da iniettare
     * @param notificaService   il service delle notifiche da iniettare
     * @param barService        il service degli articoli bar da iniettare
     * @param ombrelloniService il service degli ombrelloni da iniettare
     */
    @Autowired
    public OrdinazioneBarService(OrdinazioneBarRepository repository, NotificaService notificaService, RigaCatalogoBarService barService, UtenteService utenteService, RigaCatalogoOmbrelloneService ombrelloniService) {
        super(repository);
        this.notificaService = notificaService;
        this.barService = barService;
        this.utenteService = utenteService;
        this.ombrelloniService = ombrelloniService;
    }

    public List<SimpleRigaCatalogoBar> getArticoliBarDisponibili() {
        return this.barService.getRigheDisponibili();
    }

    /**
     * Restituisce la lista di tutte le ordinazioni effettuate dai clienti che si trovano nello {@link StatusOrdinazioneBar} specificato.
     *
     * @param status lo status in cui si devono trovare le ordinazioni
     * @return la lista di tutte le ordinazioni che si trovano nello {@code StatusOrdinazioneBar} specificato
     */
    public List<SimpleOrdinazioneBar> filtraBy(StatusOrdinazioneBar status) {
        return super.getBy(o -> o.getStatusOrdinazioneBar().equals(status));
    }

    /**
     * Restituisce la lista di tutte le ordinazioni effettuate dai clienti per il {@link SimpleArticoloBar} specificato.
     *
     * @param articoloBar l' articolo bar che devono avere le ordinazioni
     * @return la lista di tutte le ordinazioni che riguardano il {@code SimpleArticoloBar}
     */
    public List<SimpleOrdinazioneBar> filtraBy(SimpleArticoloBar articoloBar) {
        return super.getBy(o -> o.getArticoloBar().equals(articoloBar));
    }

    /**
     * Restituisce la lista delle ordinazioni effettuate dai clienti per il nome specificato del {@link SimpleArticoloBar}.
     *
     * @param nomeArticoloBar il nome dell' articolo bar del {@code SimpleArticoloBar} della {@link SimpleOrdinazioneBar}
     * @return la lista di tutte le ordinazioni che riguardano il nome del {@code SimpleArticoloBar}
     */
    public List<SimpleOrdinazioneBar> filtraBy(String nomeArticoloBar) {
        return super.getBy(o -> o.getArticoloBar().getNome().equals(nomeArticoloBar));
    }

    /**
     * Esegue un controllo sulla presenza del {@link SimpleArticoloBar} nella {@link SimpleOrdinazioneBar} specificata.
     * Restituisce un empty {@link Optional} se non viene trovato nessun {@code SimpleArticoloBar} specificato nel database, altrimenti memorizza l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} memorizzata.
     *
     * @param ordinazione l' ordinazione di cui eseguire il controllo e memorizzarla nel database
     * @return un empty {@link Optional} se non viene trovato nessun articolo della {@code SimpleOrdinazioneBar} specificata nel database
     * oppure se non viene trovato nessun {@code QRCode} con il nome specificato nel database, altrimenti memorizza l' ordinazione
     * specificata nel database e restituisce un {@code Optional} che descrive la {@code SimpleOrdinazioneBar} memorizzata.
     */
    public Optional<SimpleOrdinazioneBar> checkAndSave(SimpleOrdinazioneBar ordinazione) {
        ordinazione.getVendita().setUtente(this.utenteService.getLoggedUser());
        SimpleNotifica notifica = new SimpleNotifica();
        var riga = this.barService.getRigaBy(ordinazione.getArticoloBar().getId());
        if (riga.isPresent() && riga.get().getQuantita() > 0
                && riga.get().getPrezzo() == ordinazione.getVendita().getCosto() && this.ombrelloniService.filterBy(ordinazione.getCodiceSpiaggia()).isPresent()) {
            riga.get().setQuantita(riga.get().getQuantita() - 1);
            notifica.setMessaggio("DA PRENDERE IN CARICO: " + riga.get().getValore().getNome() + " ALL'OMBRELLONE : " + ordinazione.getCodiceSpiaggia());
            Set<SimpleUtente> set = new HashSet<>(this.utenteService.filtraBy(RuoloUtente.ADDETTO_BAR));
            set.addAll(this.utenteService.filtraBy(RuoloUtente.GESTORE));
            this.notificaService.inviaNotifica(notifica, set);
            return Optional.of(super.save(ordinazione));
        }
        return Optional.empty();
    }

    public SimpleOrdinazioneBar prendiInCaricoOrdinazione(UUID idOrdinazione){
        var u = this.utenteService.getLoggedUser();
        var o =super.getBy(idOrdinazione);
        if (o.isPresent() && o.get().getStatusOrdinazioneBar() == StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO) {
            o.get().setStatusOrdinazioneBar(StatusOrdinazioneBar.PRESO_IN_CARICO);
            SimpleNotifica notifica = new SimpleNotifica();
            notifica.setMessaggio("PRESA IN CARICO: " + o.get().getArticoloBar().getNome() + " ALL' OMBRELLONE: "+ o.get().getCodiceSpiaggia() +" DA: "+ u.getNome()+ " "+ u.getCognome());
            Set<SimpleUtente> set = new HashSet<>(this.utenteService.filtraBy(RuoloUtente.GESTORE));
            set.add(this.utenteService.getLoggedUser());
            this.notificaService.inviaNotifica(notifica, set);
            return super.save(o.get());
        }
        return null;
    }

    public SimpleOrdinazioneBar consegnaOrdinazione(UUID idOrdinazione){
        var u = this.utenteService.getLoggedUser();
        var o =super.getBy(idOrdinazione);
        if (o.isPresent() && o.get().getStatusOrdinazioneBar() == StatusOrdinazioneBar.PRESO_IN_CARICO) {
            o.get().setStatusOrdinazioneBar(StatusOrdinazioneBar.CONSEGNATO);
            SimpleNotifica notifica = new SimpleNotifica();
            notifica.setMessaggio("CONSEGNATA: " + o.get().getArticoloBar().getNome() + " ALL' OMBRELLONE: "+ o.get().getCodiceSpiaggia() + " DA: "+u.getNome()+ " "+ u.getCognome());
            Set<SimpleUtente> set = new HashSet<>(this.utenteService.filtraBy(RuoloUtente.GESTORE));
            set.add(u);
            this.notificaService.inviaNotifica(notifica, set);
            return super.save(o.get());
        }
        return null;
    }

    public List<SimpleOrdinazioneBar> getAllByLoggedUser(){
        var l =  this.getAllDaPagareByLoggedUser();
        l.addAll(this.getAllPagateByLoggedUser());
        return l;
    }

    public List<SimpleOrdinazioneBar> getAllPagateByLoggedUser() {
        Comparator<SimpleOrdinazioneBar> reversDateOrder = (o1, o2) ->
                o2.getVendita().getDataAcquisto().compareTo(o1.getVendita().getDataAcquisto());
        return this.getAll().stream().filter(o -> o.getVendita().isPagata())
                .sorted((Comparator.comparing(o -> o.getArticoloBar().getNome()))).
                parallel()
                .sorted(reversDateOrder)
                .collect(Collectors.toList());
    }

    public List<SimpleOrdinazioneBar> getAllDaPagareByLoggedUser(){
        Comparator<SimpleOrdinazioneBar> reversDateOrder = (o1, o2) ->
                o2.getVendita().getDataAcquisto().compareTo(o1.getVendita().getDataAcquisto());
        return this.getAll().stream().filter(o -> !o.getVendita().isPagata())
                .sorted((Comparator.comparing(o -> o.getArticoloBar().getNome()))).
                parallel()
                .sorted(reversDateOrder)
                .collect(Collectors.toList());
    }
}

package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.*;
import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service delle prenotazioni degli ombrelloni.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimplePrenotazioneOmbrellone} interagendo con il relativo
 * {@link PrenotazioneOmbrelloneRepository}.
 *
 * @see SimplePrenotazioneOmbrellone
 * @see PrenotazioneOmbrelloneRepository
 */
@Service
public class PrenotazioneOmbrelloneService extends AbstractService<SimplePrenotazioneOmbrellone, PrenotazioneOmbrelloneRepository> {

    private final RigaCatalogoOmbrelloneService catalogoService;
    private final UtenteService utenteService;

    /**
     * Crea un service per le prenotazioni degli ombrelloni iniettando il repository delle prenotazioni degli ombrelloni, il repository del catalogo ombrelloni e il service degli utenti specificati.
     *
     * @param repository         il repository delle prenotazioni degli ombrelloni
     * @param catalogoOmbrelloni il repository del catalogo degli ombrelloni
     * @param utenteService      il service degli utenti
     */
    @Autowired
    public PrenotazioneOmbrelloneService(PrenotazioneOmbrelloneRepository repository, RigaCatalogoOmbrelloneService catalogoOmbrelloni, UtenteService utenteService) {
        super(repository);
        this.catalogoService = catalogoOmbrelloni;
        this.utenteService = utenteService;
    }

    /**
     * Memorizza la {@link SimplePrenotazioneOmbrellone} specificata se il {@link SimpleOmbrellone} &egrave; libero secondo
     * la data e la {@link FasciaOraria} indicate nella {@code SimplePrenotazioneOmbrellone} specificata.
     *
     * @param prenotazione la prenotazione del {@code SimpleOmbrellone} da memorizzare nel database.
     * @return la {@code SimplePrenotazioneOmbrellone} memorizzata nel database se viene memorizzata con successo, {@code null} altrimenti
     */
    @Override
    public SimplePrenotazioneOmbrellone save( @Valid SimplePrenotazioneOmbrellone prenotazione) {
        System.out.println(prenotazione.getVendita().getUtente());
        var riga = this.catalogoService.getRigaBy(prenotazione.getOmbrellone());
        var utente = this.utenteService.getBy(prenotazione.getVendita().getUtente().getId());
        if (riga.isPresent() && utente.isPresent() && riga.get().getPrezzoOmbrellone() == prenotazione.getVendita().getCosto() && super.repository.findAll().stream().noneMatch(p -> p.equals(prenotazione))){
            prenotazione.getVendita().setPagata(false);
            return super.save(prenotazione);
        }
        return null;
    }

    /**
     * Restituisce la lista delle righe degli ombrelloni disponibili del catalogo ombrelloni secondo data e {@link FasciaOraria} specificate.
     *
     * @param data         la data in cui filtrare gli ombrelloni disponibili
     * @param fasciaOraria la {@code FasciaOraria} in cui filtrare gli ombrelloni disponibili
     * @return la lista di tutte le righe che contengono ombrelloni disponibili secondo data e {@code FasciaOraria} specificate
     */
    public List<SimpleRigaCatalogoOmbrellone> getRigheDisponibiliBy(Date data, FasciaOraria fasciaOraria) {
        return catalogoService.getAll()
                .stream()
                .filter(riga -> this.filtraBy(data, fasciaOraria).stream().noneMatch(p -> p.getOmbrellone().equals(riga.getValore())))
                .collect(Collectors.toList());
    }

    /**
     * Restituisce la lista delle righe degli ombrelloni disponibili del catalogo ombrelloni secondo data, la {@link FasciaOraria} e la {@code Categoria} specificate.
     *
     * @param data         la data in cui filtrare gli ombrelloni disponibili
     * @param fasciaOraria la {@code FasciaOraria} in cui filtrare gli ombrelloni disponibili
     * @param categoria    la {@code Categoria} in cui filtrare gli ombrelloni disponibili
     * @return la lista di tutte le righe che contengono ombrelloni disponibili secondo data, {@code FasciaOraria} e la {@code Categoria} specificate
     */
    public List<SimpleRigaCatalogoOmbrellone> getRigheDisponibiliBy(Date data, FasciaOraria fasciaOraria, Categoria categoria) {
        return catalogoService.filterBy(categoria)
                .stream()
                .filter(riga -> this.filtraBy(data, fasciaOraria).stream().noneMatch(p -> p.getOmbrellone().equals(riga.getValore())))
                .collect(Collectors.toList());
    }

    /**
     * Restituisce la lista di tutte le prenotazioni degli ombrelloni filtrate per la data e la {@link FasciaOraria} specificate.
     *
     * @param data         la data da filtrare per le prenotazioni degli ombrelloni
     * @param fasciaOraria la {@code FasciaOraria} da filtrare per le prenotazioni degli ombrelloni
     * @return la lista di tutte le prenotazioni degli ombrelloni filtrate per data e {@code FasciaOraria} specificate
     */
    public List<SimplePrenotazioneOmbrellone> filtraBy(Date data, FasciaOraria fasciaOraria) {
        return super.getAll().stream()
                .filter(p -> p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria))
                .collect(Collectors.toList());
    }

    /**
     * Restituisce la lista di tutte le prenotazioni degli ombrelloni filtrate per lo stato del pagamento specificato.
     *
     * @param statoPagamento lo stato del pagamento da filtrare per le prenotazioni degli ombrelloni
     * @return la lista di tutte le prenotazioni degli ombrelloni filtrate per lo stato pagamento specificato
     */
    public List<SimplePrenotazioneOmbrellone> filtraBy(boolean statoPagamento) {
        return super.getBy(p -> p.getVendita().isPagata() == statoPagamento);
    }

    /**
     * Restituisce la lista di tutte le prenotazioni degli ombrelloni filtrate per il {@link SimpleUtente} specificato.
     *
     * @param utente l' utente di cui ricavare le prenotazioni effettuate dallo stesso
     * @return la lista di tutte le prenotazione effettuate dal {@code SimpleUtente} specificato
     */
    public List<SimplePrenotazioneOmbrellone> filtraBy(SimpleUtente utente) {
        return super.getBy(p -> p.getVendita().getUtente().equals(utente));
    }

}

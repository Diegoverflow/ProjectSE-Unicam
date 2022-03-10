package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneAttivitaService extends AbstractService<SimplePrenotazioneAttivita, PrenotazioneAttivitaRepository> {

    private final RigaCatalogoAttivitaService catalogoAttivita;
    private final UtenteService utenteService;
    @Autowired
    public PrenotazioneAttivitaService(PrenotazioneAttivitaRepository repository, RigaCatalogoAttivitaService catalogoAttivita, UtenteService utenteService) {
        super(repository);
        this.catalogoAttivita = catalogoAttivita;
        this.utenteService = utenteService;
    }

    public List<SimpleRigaCatalogoAttivita> getAttivitaDisponibili() {
        return this.catalogoAttivita.getAttivitaDisponibili();
    }

    public SimpleRigaCatalogoAttivita getAttivitaDisponibiliBy(String nomeAttivita) {
        var r = this.catalogoAttivita.getRigaBy(nomeAttivita);
        if (r.isEmpty())
            return null;
        return r.get();
    }

    public List<SimplePrenotazioneAttivita> filtraBy(UUID idAttivita) {
        return super.getBy(prenotazioneAttivita ->
                prenotazioneAttivita.getAttivita().getId().equals(idAttivita));
    }

    public List<SimplePrenotazioneAttivita> filtraBy(SimpleAttivita attivita) {
        return super.getBy(prenotazioneAttivita ->
                prenotazioneAttivita.getAttivita().equals(attivita));
    }

    public List<SimplePrenotazioneAttivita> filtraBy(String nomeAttivita) {
        return super.getBy(prenotazioneAttivita ->
                prenotazioneAttivita.getAttivita().getNome().equals(nomeAttivita));
    }

    @Override
    public SimplePrenotazioneAttivita save(SimplePrenotazioneAttivita prenotazioneAttivita) {
        prenotazioneAttivita.getVendita().setUtente(this.utenteService.getLoggedUser());

        if (this.getBy(prenotazioneAttivita.getId()).isPresent())
            return null;
        if (this.clientIsFurbetto(prenotazioneAttivita))
            return null;
        var riga = this.catalogoAttivita.getRigaBy(prenotazioneAttivita.getAttivita());
        if (riga.isPresent()){
            riga.get().setPostiOccupati(riga.get().getPostiOccupati() + 1);
            if (this.catalogoAttivita.update(riga.get()) == null)
                return null;
        }
        return super.save(prenotazioneAttivita);
    }

    private boolean clientIsFurbetto(SimplePrenotazioneAttivita prenotazioneAttivita) {
        boolean flag = true;
        var res = this.catalogoAttivita.
                getRigaBy(prenotazioneAttivita.getAttivita().getNome()).
                map(simpleRigaCatalogoAttivita ->
                        simpleRigaCatalogoAttivita.getPrezzo() != prenotazioneAttivita.getVendita().getCosto() ||
                                prenotazioneAttivita.getVendita().isPagata());
        if (res.isPresent())
            flag = res.get();
        return flag;
    }

    public SimplePrenotazioneAttivita update(SimplePrenotazioneAttivita prenotazioneAttivita) {
        if (this.getBy(prenotazioneAttivita.getId()).isEmpty())
            return null;
        if (this.clientIsFurbetto(prenotazioneAttivita))
            return null;
        return super.save(prenotazioneAttivita);
    }

}

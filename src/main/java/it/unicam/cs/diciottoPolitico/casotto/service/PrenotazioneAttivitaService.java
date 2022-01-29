package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.PrenotazioneAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// TODO: javadoc
@Service
public class PrenotazioneAttivitaService extends AbstractService<SimplePrenotazioneAttivita, PrenotazioneAttivitaRepository> {

    private final RigaCatalogoAttivitaService catalogoAttivita;

    @Autowired
    public PrenotazioneAttivitaService(PrenotazioneAttivitaRepository repository, RigaCatalogoAttivitaService catalogoAttivita) {
        super(repository);
        this.catalogoAttivita = catalogoAttivita;
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
        if (this.getBy(prenotazioneAttivita.getId()).isPresent())
            return null;
        if (this.clientIsFurbetto(prenotazioneAttivita))
            return null;
        this.catalogoAttivita.
                getBy(prenotazioneAttivita.getAttivita().getId()).
                ifPresent(r -> r.setPostiOccupati(r.getPostiOccupati() + 1));
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

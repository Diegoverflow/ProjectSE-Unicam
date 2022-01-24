package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RigaCatalogoBarService extends AbstractService<SimpleRigaCatalogoBar, RigaCatalogoBarRepository> {

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        super(repository);
    }

    /**
     * Aggiunge la {@link SimpleOrdinazioneBar} specificata al database.
     * Restituisce un {@link Optional} che descrive la {@code SimpleOrdinazioneBar}
     * oppure un empty {@code Optional} se l' ordinazione &egrave; gi&agrave; presente nel database.
     *
     * @param ordinazioneBar l' ordinazione da aggiungere al database
     * @return un {@code Optional} che descrive l' {@code SimpleOrdinazioneBar} da aggiungere al database
     * oppure un empty {@code Optional} se l' ordinazione &egrave; gi&agrave; presente nel database
     */
    public Optional<SimpleRigaCatalogoBar> addOrdinazione(UUID id, SimpleOrdinazioneBar ordinazioneBar) {
        Optional<SimpleRigaCatalogoBar> foundRiga = super.repository.findAll().stream().filter(r -> r.getId().equals(id)).findFirst();
        if (foundRiga.isPresent()) {
            foundRiga.get().getOrdinazioniBar().add(ordinazioneBar);
            return Optional.of(super.repository.save(foundRiga.get()));
        }
        return Optional.empty();
    }

}

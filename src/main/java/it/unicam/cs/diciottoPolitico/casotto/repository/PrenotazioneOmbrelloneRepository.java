package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimplePrenotazioneOmbrellone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository della {@link SimplePrenotazioneOmbrellone}.
 */
@Repository
public interface PrenotazioneOmbrelloneRepository extends JpaRepository<SimplePrenotazioneOmbrellone, UUID> {
}

package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.model.SimplePrenotazioneAttivita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository della {@link SimplePrenotazioneAttivita}.
 */
@Repository
public interface PrenotazioneAttivitaRepository extends JpaRepository<SimplePrenotazioneAttivita, UUID> {
}

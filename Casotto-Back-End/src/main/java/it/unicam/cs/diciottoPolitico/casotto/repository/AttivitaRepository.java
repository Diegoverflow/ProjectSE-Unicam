package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleAttivita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository della {@link SimpleAttivita}.
 */
@Repository
public interface AttivitaRepository extends JpaRepository<SimpleAttivita, UUID> {
}

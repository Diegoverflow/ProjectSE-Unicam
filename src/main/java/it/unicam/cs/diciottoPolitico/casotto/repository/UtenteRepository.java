package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository del {@link SimpleUtente}.
 */
@Repository
public interface UtenteRepository extends JpaRepository<SimpleUtente, UUID> {
}

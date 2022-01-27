package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOmbrellone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository del {@link SimpleOmbrellone}.
 */
@Repository
public interface OmbrelloneRepository extends JpaRepository<SimpleOmbrellone, UUID> {
}

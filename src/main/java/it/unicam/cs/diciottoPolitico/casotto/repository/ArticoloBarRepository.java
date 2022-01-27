package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository del {@link SimpleArticoloBar}.
 */
@Repository
public interface ArticoloBarRepository extends JpaRepository<SimpleArticoloBar, UUID> {
}

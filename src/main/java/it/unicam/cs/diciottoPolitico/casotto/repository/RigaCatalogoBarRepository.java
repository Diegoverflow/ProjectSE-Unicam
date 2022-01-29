package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository della {@link SimpleRigaCatalogoBar}.
 */
@Repository
public interface RigaCatalogoBarRepository extends JpaRepository<SimpleRigaCatalogoBar, UUID> {
}

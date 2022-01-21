package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.AreaInfrastruttura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InfrastrutturaRepository extends JpaRepository<AreaInfrastruttura, UUID> {
}

package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleOrdinazioneBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository della {@link SimpleOrdinazioneBar}.
 */
@Repository
public interface OrdinazioneBarRepository extends JpaRepository<SimpleOrdinazioneBar, UUID> {
}

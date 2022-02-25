package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository del {@link SimpleUtente}.
 */
@Repository
public interface UtenteRepository extends JpaRepository<SimpleUtente, UUID> {

    @Query("SELECT u FROM SimpleUtente u WHERE u.email = :email")
    SimpleUtente getUserByUsername(@Param("email") String email);

}

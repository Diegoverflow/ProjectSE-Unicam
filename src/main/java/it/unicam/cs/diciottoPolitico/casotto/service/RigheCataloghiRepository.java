package it.unicam.cs.diciottoPolitico.casotto.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RigheCataloghiRepository<R> extends JpaRepository<R, UUID> {
}

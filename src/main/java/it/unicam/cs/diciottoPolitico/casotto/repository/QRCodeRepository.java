package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.utils.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Interfaccia per le operazioni CRUD sul repository del {@link QRCode}.
 */
public interface QRCodeRepository extends JpaRepository<QRCode, UUID> {
}

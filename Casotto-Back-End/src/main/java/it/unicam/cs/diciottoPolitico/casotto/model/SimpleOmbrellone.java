package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Ombrellone;
//import it.unicam.cs.diciottoPolitico.casotto.utils.QRCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
@Entity
@Table(name = "ombrellone")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @EqualsAndHashCode.Include
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(unique = true)
    @NonNull
    private String codiceSpiaggia;

    protected SimpleOmbrellone() {
        this.id = UUID.randomUUID();
    }

}

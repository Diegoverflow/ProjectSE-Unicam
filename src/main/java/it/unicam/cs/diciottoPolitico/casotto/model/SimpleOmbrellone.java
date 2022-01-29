package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.utils.QRCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qrcode_id")
    private QRCode codiceSpiaggia;

    protected SimpleOmbrellone() {
        this.id = UUID.randomUUID();
    }

}

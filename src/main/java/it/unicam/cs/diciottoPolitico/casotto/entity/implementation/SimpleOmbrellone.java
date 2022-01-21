package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
@Entity
@Table(name = "ombrellone")
@EqualsAndHashCode
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @Getter
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition = "BINARY(16)",updatable = false,nullable = false)
    private UUID id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Getter
    @Setter
    @Column
    private String codiceSpiaggia;

    /**
     * Costruisce un Ombrellone secondo i seguenti parametri:
     *
     * @param categoria      dell'ombrellone
     * @param codiceSpiaggia dell'ombrellone
     */
    public SimpleOmbrellone(Categoria categoria, String codiceSpiaggia) {
        this();
        this.categoria = categoria;
        this.codiceSpiaggia = codiceSpiaggia;
    }

    protected SimpleOmbrellone() {
    }

}

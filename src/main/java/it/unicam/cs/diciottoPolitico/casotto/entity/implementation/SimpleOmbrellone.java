package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
@Entity
@Table(name = "ombrellone")
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)",updatable = false,unique = true,nullable = false)
    @Getter
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Categoria categoria;

    @Column
    @Getter
    @Setter
    private String codiceSpiaggia;

    /**
     * Costruisce un Ombrellone secondo i seguenti parametri:
     *
     * @param categoria      dell'ombrellone
     * @param codiceSpiaggia dell'ombrellone
     */
    public SimpleOmbrellone(Categoria categoria, String codiceSpiaggia) {
        this.id = UUID.randomUUID();
        this.categoria = categoria;
        this.codiceSpiaggia = codiceSpiaggia;
    }

    protected SimpleOmbrellone() {
    }

}

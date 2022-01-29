package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
@Entity
@Table(name = "riga_catalogo_ombrellone")
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {

    @Id
    @EqualsAndHashCode.Include
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column
    @NonNull
    @Positive
    private double prezzoOmbrellone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ombrellone_id")
    @NonNull
    private SimpleOmbrellone valore;

    protected SimpleRigaCatalogoOmbrellone() {
        this.id = UUID.randomUUID();
    }

}

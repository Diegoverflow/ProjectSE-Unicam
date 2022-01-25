package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
@Entity
@Table(name = "riga_catalogo_ombrellone")
@Setter
@Getter
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column
    private double prezzoOmbrellone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ombrellone_id")
    private SimpleOmbrellone valore;

    protected SimpleRigaCatalogoOmbrellone() {
    }

}

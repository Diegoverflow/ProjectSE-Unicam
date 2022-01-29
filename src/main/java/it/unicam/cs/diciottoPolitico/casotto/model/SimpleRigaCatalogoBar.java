package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.RigaCatalogoBar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia RigaCatalogoBar.
 */
@Entity
@Table(name = "riga_catalogo_bar")
@Getter
@Setter
@EqualsAndHashCode
public class SimpleRigaCatalogoBar implements RigaCatalogoBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articolo_bar_id", unique = true, nullable = false)
    private SimpleArticoloBar valore;

    @Column(nullable = false)
    @Positive
    private double prezzo;

    @Column(nullable = false)
    @PositiveOrZero
    private int quantita;

    protected SimpleRigaCatalogoBar() {
        this.id = UUID.randomUUID();
    }

}

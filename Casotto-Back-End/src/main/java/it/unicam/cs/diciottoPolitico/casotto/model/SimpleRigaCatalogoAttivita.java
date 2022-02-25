package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.RigaCatalogoAttivita;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Table(name = "riga_catalogo_attivita")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleRigaCatalogoAttivita implements RigaCatalogoAttivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attivita_id", referencedColumnName = "id")
    @EqualsAndHashCode.Include
    private SimpleAttivita valore;

    @Column
    @Min(0)
    @EqualsAndHashCode.Include
    private double prezzo;

    @Column
    @Positive
    @EqualsAndHashCode.Include
    private int postiTotali;

    @Column
    @Min(0)
    private int postiOccupati;

    protected SimpleRigaCatalogoAttivita(){
        this.id = UUID.randomUUID();
    }
}

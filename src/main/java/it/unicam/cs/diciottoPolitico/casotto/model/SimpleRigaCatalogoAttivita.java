package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.RigaCatalogoAttivita;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "riga_catalogo_attivita")
@Getter
@Setter
public class SimpleRigaCatalogoAttivita implements RigaCatalogoAttivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attivita_id", referencedColumnName = "id")
    private SimpleAttivita valore;//todo brutto nome

    @Column
    private double prezzo;

    @Column
    private int postiTotali;

    @Column
    private int postiOccupati;

    protected SimpleRigaCatalogoAttivita(){
        this.id = UUID.randomUUID();
    }
}

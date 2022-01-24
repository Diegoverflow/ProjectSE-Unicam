package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia RigaCatalogoBar.
 */
@Entity
@Table(name = "riga_catalogo_bar")
@Getter
@Setter
public class SimpleRigaCatalogoBar implements RigaCatalogoBar {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articolo_bar_id", referencedColumnName = "id")
    private SimpleArticoloBar valore;

    @Column
    private double prezzo;

    @Column
    private int quantita;

    @OneToMany(targetEntity = SimpleOrdinazioneBar.class, fetch = FetchType.LAZY, mappedBy = "id")
    private List<SimpleOrdinazioneBar> ordinazioniBar;

}

package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoBar;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia RigaCatalogoBar.
 */
@Entity
@Table(name = "riga_catalogo_bar")
public class SimpleRigaCatalogoBar implements RigaCatalogoBar {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articolo_bar_id", referencedColumnName = "id")
    @Getter
    private SimpleArticoloBar valore;

    @Column
    @Getter
    @Setter
    private double prezzo;

    @Column
    @Getter
    @Setter
    private int quantita;

}

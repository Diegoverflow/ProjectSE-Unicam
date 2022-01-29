package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.ArticoloBar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia {@link ArticoloBar}.
 */
@Entity
@Table(name = "articolo_bar")
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class SimpleArticoloBar implements ArticoloBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(unique = true)
    private String nome;

    @Column(length = 1000)
    private String descrizione;

    protected SimpleArticoloBar() {
        this.id = UUID.randomUUID();
    }
}

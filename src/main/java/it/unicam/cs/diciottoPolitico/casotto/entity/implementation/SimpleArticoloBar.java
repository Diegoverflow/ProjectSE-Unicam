package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia {@link ArticoloBar}.
 */
@Entity
@Table(name="articolo_bar")
@Getter
@Setter
@EqualsAndHashCode
public class SimpleArticoloBar implements ArticoloBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column
    private String nome;

    @Column
    private String descrizione;

    protected SimpleArticoloBar(){
        this.id = UUID.randomUUID();
    }
}

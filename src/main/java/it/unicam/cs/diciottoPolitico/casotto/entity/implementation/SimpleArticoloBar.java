package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column
    private String descrizione;

}

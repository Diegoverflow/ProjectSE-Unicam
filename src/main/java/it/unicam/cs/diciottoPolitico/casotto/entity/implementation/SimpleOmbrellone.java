package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia Ombrellone.
 */
@Entity
@Table(name = "ombrellone")
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @EqualsAndHashCode.Exclude
    @Column(columnDefinition = "BINARY(16)",updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(unique = true)
    private String codiceSpiaggia;

    protected SimpleOmbrellone(){
        this.id = UUID.randomUUID();
    }

}

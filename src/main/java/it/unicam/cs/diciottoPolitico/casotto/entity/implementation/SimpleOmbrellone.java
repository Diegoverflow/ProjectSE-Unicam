package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
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
public class SimpleOmbrellone implements Ombrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column
    private String codiceSpiaggia;

    protected SimpleOmbrellone(){
        this.id = UUID.randomUUID();
    }

}

package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Vendita;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "vendita")
public class SimpleVendita implements Vendita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    private UUID id;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataAcquisto;

    @Column
    @Getter
    @Setter
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    @Getter
    @Setter
    private boolean pagata;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @Getter
    private SimpleUtente utente;

}

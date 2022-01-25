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
@Getter
@Setter
public class SimpleVendita implements Vendita {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private Date dataAcquisto;

    @Column
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean pagata;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private SimpleUtente utente;

}

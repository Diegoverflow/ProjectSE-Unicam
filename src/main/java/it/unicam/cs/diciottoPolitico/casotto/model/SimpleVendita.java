package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Vendita;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "vendita")
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class SimpleVendita implements Vendita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private Date dataAcquisto;

    @Column
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean pagata;

    @ManyToOne
    @JoinColumn(name = "utente_id", updatable = false)
    @NonNull
    private SimpleUtente utente;

    protected SimpleVendita() {
        this.id = UUID.randomUUID();
        this.dataAcquisto = new Date();
        this.pagata = false;
    }
}

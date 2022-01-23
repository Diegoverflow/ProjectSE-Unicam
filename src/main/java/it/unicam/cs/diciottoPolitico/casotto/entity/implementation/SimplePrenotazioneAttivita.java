package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia PrenotazioneAttivita.
 */
@Entity
@Table(name = "prenotazione_attivita")
public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    private UUID id;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataAcquisto;

    @Column(columnDefinition = "TINYINT(1)")
    @Getter
    @Setter
    private boolean pagata;

    @Column
    @Getter
    @Setter
    private double costo;

    @ManyToOne
    @JoinColumn(name = "attivita_id")
    @Getter
    private SimpleAttivita attivita;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @Getter
    private SimpleUtente utente;

}

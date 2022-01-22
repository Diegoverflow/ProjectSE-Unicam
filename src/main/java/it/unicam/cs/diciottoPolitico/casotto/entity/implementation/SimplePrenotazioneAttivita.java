package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
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

    @ManyToOne(targetEntity = SimpleAttivita.class)
    @JoinColumn(name = "attivita_id")
    @Getter
    private Attivita attivita;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    @Getter
    private Utente utente;

    /**
     * Costruisce una prenotazione attivit&agrave;
     *
     * @param costo    della prenotazione
     * @param attivita da associare alla prenotazione
     * @throws NullPointerException se l'attivit&agrave; o l'utente sono nulli
     * @apiNote la data di acquisto &egrave; impostata automaticamente dal sistema alla data corrente
     * e lo stato di pagamento &egrave; impostato automaticamente a {@code false}
     */
    public SimplePrenotazioneAttivita(double costo, Attivita attivita, Utente utente) {
        this.id = UUID.randomUUID();
        this.dataAcquisto = new Date();
        this.pagata = false;
        this.costo = costo;
        this.attivita = attivita;
        this.utente = Objects.requireNonNull(utente, "L'utente non puo' essere nullo");
    }

    protected SimplePrenotazioneAttivita() {
    }

}

package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Semplice implementazione di un' {@link Attivita}.
 * Un' attivit&agrave; ha una data ed un orario in cui inizia e una data ed un orario in cui termina.
 * Inoltre ha un numero di posti totali di clienti che possono partciparne ed un numero di posti occupati per sapere quanti partecipanti ci sono
 * attualmente per questa attivit&agrave;.
 * Infine ha un proprio id univoco ed una descrizione che appunto descrive cosa fa quest' attivit&agrave;.
 */

@Entity
@Table(name = "attivita")
@EqualsAndHashCode
public class SimpleAttivita implements Attivita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    @Getter
    private UUID id;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataOrarioInizio;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataOrarioFine;

    @Column
    @Getter
    @Setter
    private String descrizione;

    /**
     * Costruisce un'attvit&agrave;
     *
     * @param dataOrarioInizio dell'attvit&agrave;
     * @param dataOrarioFine   dell'attvit&agrave;
     * @param descrizione      dell'attvit&agrave;
     * @throws NullPointerException     se la {@code dataOrarioInizio}, {@code dataOrarioFine} o la {@code descrizione} sono {@code null}
     * @throws IllegalArgumentException se la {@code dataOrarioFine} precede la {@code dataOrarioInizio} oppure se {@code dataOrarioInizio} e {@code dataOrarioFine} sono uguali secondo il meotodo equals
     */

    public SimpleAttivita(Date dataOrarioInizio,
                          Date dataOrarioFine,
                          String descrizione) {
        this.id = UUID.randomUUID();
        this.dataOrarioInizio = dataOrarioInizio;
        this.dataOrarioFine = dataOrarioFine;
        this.descrizione = descrizione;
    }

    protected SimpleAttivita() {
    }
}

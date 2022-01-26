package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
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
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class SimpleAttivita implements Attivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private Date dataOrarioInizio;

    @Temporal(TemporalType.DATE)
    private Date dataOrarioFine;

    @Column
    private String descrizione;

    @Column
    private String nome;

    protected SimpleAttivita(){
        this.id = UUID.randomUUID();
    }
}

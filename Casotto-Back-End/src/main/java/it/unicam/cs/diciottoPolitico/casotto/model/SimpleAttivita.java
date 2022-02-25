package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Attivita;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleAttivita implements Attivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @NonNull
    @Column
    @EqualsAndHashCode.Include
    private LocalDate dataOrarioInizio;

    @NonNull
    @Column
    @EqualsAndHashCode.Include
    private LocalDate dataOrarioFine;

    @Column
    private String descrizione;

    @Column
    @EqualsAndHashCode.Include
    private String nome;

    protected SimpleAttivita(){
        this.id = UUID.randomUUID();
    }
}

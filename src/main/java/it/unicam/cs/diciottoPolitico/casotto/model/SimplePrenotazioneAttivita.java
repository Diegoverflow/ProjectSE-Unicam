package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.PrenotazioneAttivita;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia PrenotazioneAttivita.
 */
@Entity
@Table(name = "prenotazione_attivita")
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "attivita_id")
    private SimpleAttivita attivita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id")
    private SimpleVendita vendita;

    protected SimplePrenotazioneAttivita(){
        this.id = UUID.randomUUID();
    }

}

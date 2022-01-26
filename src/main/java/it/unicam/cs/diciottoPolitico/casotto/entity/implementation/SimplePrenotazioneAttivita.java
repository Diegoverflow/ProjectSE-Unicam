package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Semplice implementazione dell'interfaccia PrenotazioneAttivita.
 */
@Entity
@Table(name = "prenotazione_attivita")
@Getter
@Setter
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

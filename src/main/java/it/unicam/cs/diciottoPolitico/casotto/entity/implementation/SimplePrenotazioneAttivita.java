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
public class SimplePrenotazioneAttivita implements PrenotazioneAttivita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    @Setter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "attivita_id")
    @Getter
    @Setter
    private SimpleAttivita attivita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id")
    @Getter
    @Setter
    private SimpleVendita vendita;

}

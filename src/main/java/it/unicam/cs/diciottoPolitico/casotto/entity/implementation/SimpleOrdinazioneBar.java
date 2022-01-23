package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

/**
 * Semplice implementazione dell'interfaccia OrdinazioneBar.
 */
@Entity
@Table(name = "ordinazione_bar")
public class SimpleOrdinazioneBar implements OrdinazioneBar {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    @Getter
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "articolo_bar_id")
    @Getter
    @Setter
    private SimpleArticoloBar articoloBar;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private StatusOrdinazioneBar statusOrdinazioneBar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id")
    @Getter
    @Setter
    private SimpleVendita vendita;

}

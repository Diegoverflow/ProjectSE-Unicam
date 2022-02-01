package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.OrdinazioneBar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.UUID;
import javax.persistence.*;

/**
 * Semplice implementazione dell'interfaccia OrdinazioneBar.
 */
@Entity
@Table(name = "ordinazione_bar")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimpleOrdinazioneBar implements OrdinazioneBar {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "articolo_bar_id", updatable = false)
    private SimpleArticoloBar articoloBar;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusOrdinazioneBar statusOrdinazioneBar;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    @JoinColumn(name = "vendita_id", updatable = false)
    private SimpleVendita vendita;

    @Column(nullable = false)
    private String codiceSpiaggia;

    protected SimpleOrdinazioneBar() {
        this.id = UUID.randomUUID();
        this.statusOrdinazioneBar = StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO;
    }

}

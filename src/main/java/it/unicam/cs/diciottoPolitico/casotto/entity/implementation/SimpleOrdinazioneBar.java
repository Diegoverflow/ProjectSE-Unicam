package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.ArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.OrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.StatusOrdinazioneBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.GregorianCalendar;
import java.util.Objects;
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

    @ManyToOne(targetEntity = SimpleArticoloBar.class)
    @JoinColumn(name = "articolo_bar_id")
    @Getter
    private ArticoloBar articoloBar;

    @Temporal(TemporalType.DATE)
    @Getter
    private GregorianCalendar dataAcquisto;

    @Column
    @Getter
    @Setter
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    @Getter
    @Setter
    private boolean pagata;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private StatusOrdinazioneBar statusOrdinazioneBar;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    @Getter
    private Utente utente;

    /**
     * Metodo costruttore.
     *
     * @param articoloBar l'articolo bar associato all'ordinazione
     * @param costo       costo dell'ordinazione bar
     * @param utente      l'utente che ha effettuato l'ordinazione bar
     * @throws NullPointerException     se l'articolo bar o l'utente sono nulli
     * @throws IllegalArgumentException se il costo è negativo
     */
    public SimpleOrdinazioneBar(ArticoloBar articoloBar, double costo, Utente utente) {
        this.id = UUID.randomUUID();
        this.dataAcquisto = new GregorianCalendar();
        this.articoloBar = articoloBar;
        this.costo = costo;
        this.pagata = false;
        this.statusOrdinazioneBar = StatusOrdinazioneBar.DA_PRENDERE_IN_CARICO;
        this.utente = utente;
    }

    protected SimpleOrdinazioneBar() {
    }

}

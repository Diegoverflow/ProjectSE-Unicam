package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
@Entity
@Table(name = "riga_catalogo_ombrellone")
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    private UUID id;

    @OneToOne(targetEntity = SimpleOmbrellone.class)
    @JoinColumn(name = "ombrellone_id", referencedColumnName = "id")
    @Getter
    private Ombrellone valore;

    @Column
    @Getter
    @Setter
    private double prezzoOmbrellone;

    @OneToMany(targetEntity = SimplePrenotazioneOmbrellone.class,fetch = FetchType.LAZY)
    @Getter
    private List<PrenotazioneOmbrellone> prenotazioni;

    /**
     * Metodo costruttore.
     *
     * @param valore ombrellone associato alla riga
     * @param prezzoOmbrellone costo dell'ombrellone
     * @throws NullPointerException se l'ombrellone &egrave; nullo
     */
    public SimpleRigaCatalogoOmbrellone(Ombrellone valore, double prezzoOmbrellone) {
        this.id = UUID.randomUUID();
        this.valore = valore;
        this.prezzoOmbrellone = prezzoOmbrellone;
        this.prenotazioni = new ArrayList<>();
    }

    protected SimpleRigaCatalogoOmbrellone() {
    }

    @Override
    public boolean addPrenotazione(PrenotazioneOmbrellone prenotazione) {
        if(this.prenotazioni.contains(Objects.requireNonNull(prenotazione,"La prenotazione non puo' essere nulla")))
            return false;
        return this.prenotazioni.add(prenotazione);
    }
}

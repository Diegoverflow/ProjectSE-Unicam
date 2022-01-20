package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoOmbrellone;

import javax.persistence.*;
import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
@Entity
@Table(name = "righe_catalogo_ombrellone")
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private UUID id;

    @OneToOne(targetEntity = SimpleOmbrellone.class)
    @JoinColumn(name = "ombrellone_id")
    private Ombrellone ombrellone;

    @Column
    private double costo;

    @OneToMany(targetEntity = SimplePrenotazioneOmbrellone.class,fetch = FetchType.LAZY)
    private List<PrenotazioneOmbrellone> prenotazioni;

    /**
     * Metodo costruttore.
     *
     * @param ombrellone ombrellone associato alla riga
     * @param costo costo dell'ombrellone
     * @throws NullPointerException se l'ombrellone &egrave; nullo
     */
    public SimpleRigaCatalogoOmbrellone(Ombrellone ombrellone, double costo) {
        this();
        this.ombrellone = Objects.requireNonNull(ombrellone,"L'ombrellone non puo' essere nullo");
        this.costo = costo;
        this.prenotazioni = new ArrayList<>();
    }

    public SimpleRigaCatalogoOmbrellone() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId(){
        return  this.id;
    }

    @Override
    public double getPrezzoOmbrellone() {
        return this.costo;
    }

    @Override
    public List<PrenotazioneOmbrellone> getPrenotazioni() {
        return this.prenotazioni;
    }


    @Override
    public void setPrezzoOmbrellone(double nuovoPrezzo) {
        if (nuovoPrezzo<0)
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0");
        this.costo = nuovoPrezzo;
    }

    @Override
    public boolean addPrenotazione(PrenotazioneOmbrellone prenotazione) {
        if(this.prenotazioni.contains(Objects.requireNonNull(prenotazione,"La prenotazione non puo' essere nulla")))
            return false;
        return this.prenotazioni.add(prenotazione);
    }

    @Override
    public Ombrellone getValore() {
        return this.ombrellone;
    }
}

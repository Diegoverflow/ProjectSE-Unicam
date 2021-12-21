package it.unicam.cs.diciottoPolitico;

import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {

    private final Ombrellone ombrellone;
    private double costo;
    private final List<PrenotazioneOmbrellone> prenotazioni;

    /**
     * Metodo costruttore.
     *
     * @param ombrellone ombrellone associato alla riga
     * @param costo costo dell'ombrellone
     * @throws NullPointerException se l'ombrellone &egrave; nullo
     */
    public SimpleRigaCatalogoOmbrellone(Ombrellone ombrellone, double costo) {
        this.ombrellone = Objects.requireNonNull(ombrellone,"L'ombrellone non puo' essere nullo");
        this.costo = costo;
        this.prenotazioni = new ArrayList<>();
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
    public boolean getDisponibilita(GregorianCalendar data, FasciaOraria fasciaOraria) {
        return this.prenotazioni.stream().noneMatch(p -> p.getDataPrenotazione().equals(data) && p.getFasciaOraria().equals(fasciaOraria));
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

package it.unicam.cs.diciottoPolitico;

import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
public class SimpleRigaCatalogoOmbrellone implements RigaCatalogoOmbrellone {


    @Override
    public double getPrezzoOmbrellone() {
        return 0;
    }

    @Override
    public Ombrellone getOmbrellone() {
        return null;
    }

    @Override
    public List<PrenotazioneOmbrellone> getPrenotazioni() {
        return null;
    }

    @Override
    public boolean getDisponibilita(Date date, FasciaOraria fasciaOraria) {
        return false;
    }

    @Override
    public void setPrezzoOmbrellone(double nuovoPrezzo) {

    }

    @Override
    public boolean addPrenotazione(PrenotazioneOmbrellone prenotazione) {
        return false;
    }
}

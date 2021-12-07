package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;

//TODO inserire le API

/**
 * Rappresenta un gestore per la prenotazione di un ombrellone da parte di un cliente.
 */
public interface HandlerPrenotazioneOmbrellone {
    /**
     *
     *
     * @param data
     * @param fasciaOraria
     * @return
     */
    List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria);

    /**
     *
     *
     * @param data
     * @param fasciaOraria
     * @param ombrellone
     * @return
     */
    boolean creaPrenotazione(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);

    /**
     *
     *
     * @param data
     * @param fasciaOraria
     * @param ombrellone
     * @return
     */
    String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);

    /**
     *
     *
     * @param ombrellone
     * @return
     */
    double getCostoOmbrellone(Ombrellone ombrellone);
}

package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Rappresenta un gestore per la prenotazione di un ombrellone da parte di un cliente.
 */
public interface HandlerPrenotazioneOmbrellone {

    /**
     * Ritorna una lista di righe catalogo ombrellone disponibili in una certa data e fascia oraria.
     *
     * @param data data usata per verificare la disponibilit&agrave;
     * @param fasciaOraria fascia oraria usata per verificare la disponibilit&agrave;
     * @return una lista di righe catalogo ombrellone disponibili in una certa data e fascia oraria.
     * @throws NullPointerException se la data o la fascia oraria sono nulli
     */
    List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria);

    /**
     * Crea una prenotazione.
     *
     * @param dataPrenotazione data di prenotazione
     * @param fasciaOraria fascia oraria di prenotazione
     * @param rigaCatalogoOmbrellone riga contenente l'ombrellone scelto per la prenotazione
     * @param cliente cliente associato alla prenotazione
     * @return true se la prenotazione è stata creata, false altrimenti
     * @throws NullPointerException se uno qualsiasi dei parametri &egrave; nullo
     */
    boolean creaPrenotazione(GregorianCalendar dataPrenotazione, FasciaOraria fasciaOraria, RigaCatalogoOmbrellone rigaCatalogoOmbrellone, Cliente cliente);

    /**
     * Ritorna un riepilogo dei dati di prenotazione.
     *
     * @param data data di prenotazione
     * @param fasciaOraria fascia oraria di prenotazione
     * @param ombrellone ombrellone associato alla prenotazione
     * @return un riepilogo dei dati di prenotazione
     */
    String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);

}

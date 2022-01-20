package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.*;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Rappresenta un gestore per la prenotazione di un {@link Ombrellone} da parte di un {@link Cliente}.
 *
 * @see RigaCatalogoOmbrellone
 * @see FasciaOraria
 * @see Utente
 */
public interface HandlerPrenotazioneOmbrellone {

    /**
     * Ritorna una lista di righe catalogo ombrellone disponibili in una certa data e {@link FasciaOraria}.
     *
     * @param data         data usata per verificare la disponibilit&agrave;
     * @param fasciaOraria fascia oraria usata per verificare la disponibilit&agrave;
     * @return una lista di righe catalogo ombrellone disponibili in una certa data e fascia oraria.
     * @throws NullPointerException se la data o la fascia oraria sono {@code null}
     * @see RigaCatalogoOmbrellone
     */
    List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria);

    /**
     * Crea una prenotazione.
     *
     * @param dataPrenotazione       data di prenotazione
     * @param fasciaOraria           fascia oraria di prenotazione
     * @param rigaCatalogoOmbrellone riga contenente l'ombrellone scelto per la prenotazione
     * @param utente                 utente associato alla prenotazione
     * @return {@code true} se la prenotazione &egrave; stata creata, {@code false} altrimenti
     * @throws NullPointerException se uno qualsiasi dei parametri &egrave; nullo
     * @see FasciaOraria
     * @see RigaCatalogoOmbrellone
     * @see Utente
     */
    boolean creaPrenotazione(GregorianCalendar dataPrenotazione, FasciaOraria fasciaOraria, RigaCatalogoOmbrellone rigaCatalogoOmbrellone, Utente utente);

    /**
     * Ritorna un riepilogo dei dati di prenotazione.
     *
     * @param data         data di prenotazione
     * @param fasciaOraria fascia oraria di prenotazione
     * @param ombrellone   ombrellone associato alla prenotazione
     * @return un riepilogo dei dati di prenotazione
     * @see FasciaOraria
     * @see Ombrellone
     */
    String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);

    /**
     * Ritorna tutte le prenotazioni ombrellone fatte.
     *
     * @return tutte le prenotazioni ombrellone fatte
     */
    List<PrenotazioneOmbrellone> getPrenotazioniOmbrellone();

    /**
     * Rimuove una prenotazione ombrellone.
     *
     * @param prenotazioneOmbrellone la prenotazione ombrellone da rimuovere
     * @return true se la prenotazione ombrellone &egrave; stata rimossa, false se la prenotazione ombrellone non era presente
     * @throws NullPointerException se la prenotazione ombrellone &egrave; nulla
     */
    boolean removePrenotazioneOmbrellone(PrenotazioneOmbrellone prenotazioneOmbrellone);

}

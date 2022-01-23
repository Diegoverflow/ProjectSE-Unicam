package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Interfaccia che descrive una prenotazione di un ombrellone.
 *
 * @see Ombrellone
 * @see FasciaOraria
 * @see Categoria
 */
public interface PrenotazioneOmbrellone {

    /**
     * Ottieni la data in cui &egrave; riservata la prenotazione.
     *
     * @return la data di prenotazione
     */
    Date getDataPrenotazione();

    /**
     * Ottieni l' {@link Ombrellone} associato alla prenotazione
     *
     * @return l'ombrellone della prenotazione
     */
    Ombrellone getOmbrellone();

    /**
     * Ottieni la {@link FasciaOraria} nella quale la prenotazione &egrave; riservata.
     *
     * @return la fascia oraria della prenotazione
     */
    FasciaOraria getFasciaOraria();

}

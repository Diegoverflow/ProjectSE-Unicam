package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Interfaccia che descrive un'attvit&agrave;
 */
public interface Attivita {

    /**
     * Ottieni l'identificativo dell'attivit&agrave;
     *
     * @return l'id dell'attivit&agrave;
     */
    UUID getId();

    /**
     * Ottieni l'orario di inizio dell'attivit&agrave;
     *
     * @return l'orario di inizio dell'attivit&agrave;
     */
    Date getDataOrarioInizio();

    /**
     * Ottieni l'ora in cui l'attivit&agrave; termina
     *
     * @return l'ora a in cui termina l'attivit&agrave;
     */
    Date getDataOrarioFine();

    /**
     * Ottieni la descrizione dell'attivit&agrave;
     *
     * @return la descrizione dell'attivit&agrave;
     */
    String getDescrizione();

    /**
     * Imposta la descrizione dell'attivit&agrave;
     *
     * @param descrizione da impostare
     */
    void setDescrizione(String descrizione);

    /**
     * Confronta l' elemento specificato con questa attivit&agrave;
     * Restituisce {@code true} se l' elemento specificato &egrave; anch' esso un' attivit&agrave; ed
     * ha le stesse caratteristiche di questa attivit&agrave;.
     * (Due elementi {@code e1} e {@code e2} sono <i>uguali</i> se {@code Objects.equals(e1,e2)}.)
     *
     * @param o l' elemento da essere confrontato per l' uguaglianza con questa attivit&agrave;
     * @return {@code true} se l' elemento specificato &egrave; uguale a questa attivit&agrave;
     */
    boolean equals(Object o);

    /**
     * Restituisce l' hashCode per questa attivit&agrave;
     *
     * @return l' hashCode per questa attivit&agrave;
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}

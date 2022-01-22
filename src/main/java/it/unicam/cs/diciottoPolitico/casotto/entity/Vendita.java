package it.unicam.cs.diciottoPolitico.casotto.entity;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Interfaccia che descrive una generica Vendita
 */
public interface Vendita {

    /**
     * Ottieni l'id univoco associato alla vendita
     * @return l'id identificativo della vendita
     */
    UUID getId();

    /**
     * Ottieni la data in cui &grave; stata effettuata la vendita
     * @return la data di acquisto della vendita
     */
    GregorianCalendar getDataAcquisto();

    /**
     * Ottieni il costo associato ad una vendita
     * @return il costo della prenotazione
     */
    double getCosto();

    /**
     * Imposta il costo della vendita.
     *
     * @param costo il nuovo costo della vendita
     */
    void setCosto(double costo);

    /**
     * Ottieni lo stato di pagamento della vendita
     * @return {@code true} se la vendita &grave; stata saldata,
     *         {@code false} altrimenti
     */
    boolean isPagata();

    /**
     * Imposta lo stato del pagamento della vendita secondo quanto descritto
     * dal {@param stataPagamento}
     * @param statoPagamento della vendita
     */
    void setPagata(boolean statoPagamento);
}

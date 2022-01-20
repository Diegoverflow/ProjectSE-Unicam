package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Vendita;

import java.util.List;

/**
 * Interfaccia che descrive un gestore Vendite
 */
public interface HandlerVendita {

    /**
     * Ottieni tutte le vendite da saldare
     * @return le vendite da saldare
     */
    List<Vendita> getVenditeDaSaldare();

    /**
     * Ottieni tutte le prenotazioni ombrellone da saldare
     * @return le prenotazioni ombrellone da saldare
     */
    List<Vendita> getPrenotazioniOmbrelloneDaSaldare();

    /**
     * Ottierni tutte le ordinazioni Bar da saldare
     * @return tutte le ordinazioni Bar da saldare
     */
    List<Vendita> getOrdinazioniBarDaSaldare();

    /**
     * Ottieni tutte le prenotazioni attivit&agrave; da saldare
     * @return le prenotazioni attivit&agrave; da saldare
     */
    List<Vendita> getPrenotazioniAttivitaDaSaldare();

    /**
     * Salda una vedita impostando lo stato del pagamento a {@code true}
     * @param vendita da saldare
     * @return {@code true} se la vendita &egrave; stata saldata
     *         {@code false} altrimenti
     */
    boolean saldaVendita(Vendita vendita);

}

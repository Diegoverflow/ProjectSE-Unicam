package it.unicam.cs.diciottoPolitico.casotto.model.interfaces;

import it.unicam.cs.diciottoPolitico.casotto.model.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.utils.QRCode;

import java.util.UUID;

/**
 * Rappresenta un ombrellone.
 */
public interface Ombrellone {

    /**
     * Ritorna l'id dell'ombrellone.
     *
     * @return id dell'ombrellone
     */
    UUID getId();

    /**
     * Ottieni il codice identificativo dell'ombrellone sulla spieggia
     *
     * @return il codice dell'ombrellone
     */
    QRCode getCodiceSpiaggia();

    /**
     * Imposta il codice della spiaggia.
     *
     * @param codiceSpiaggia il nuovo codice della spiaggia
     */
    void setCodiceSpiaggia(QRCode codiceSpiaggia);

    /**
     * Ritorna la {@link Categoria} dell'ombrellone.
     *
     * @return la categoria dell'ombrellone
     */
    Categoria getCategoria();

    /**
     * Imposta la categoria dell'ombrellone.
     *
     * @param categoria la nuova categoria dell'ombrellone
     * @throws NullPointerException se la categoria &egrave; {@code null}
     */
    void setCategoria(Categoria categoria);
}

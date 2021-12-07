package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia ArticoloBar
 */
public class SimpleArticoloBar implements ArticoloBar{
    private long id;
    private String descrizione;

    /**
     * Metodo Costruttore.
     *
     * @param descrizione descrizione dell'articolo bar
     * @throws NullPointerException se la descrizione &egrave; nulla
     */
    public SimpleArticoloBar(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione,"La descrizione deve essere non nulla");
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione,"La descrizione deve essere non nulla");
    }
}

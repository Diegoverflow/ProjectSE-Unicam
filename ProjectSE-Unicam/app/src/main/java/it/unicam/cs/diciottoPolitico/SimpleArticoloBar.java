package it.unicam.cs.diciottoPolitico;

/**
 * Semplice implementazione dell'interfaccia ArticoloBar
 */
public class SimpleArticoloBar implements ArticoloBar{
    private long id;
    private String descrizione;

    /**
     * Metodo Costruttore.
     *
     * @param id id dell'articolo bar
     * @param descrizione descrizione dell'articolo bar
     */
    public SimpleArticoloBar(long id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    /**
     * Metodo Costruttore senza id.
     *
     * @param descrizione descrizione dell'articolo bar
     */
    public SimpleArticoloBar(String descrizione) {
        this.descrizione = descrizione;
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
        this.descrizione = descrizione;
    }
}

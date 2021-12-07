package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

public class SimpleAttivita implements Attivita {

    private long id;
    private final GregorianCalendar dataOrarioInizio;
    private final GregorianCalendar dataOrarioFine;
    private String descrizione;
    private final int postiTotali;
    private int postiOccupati;

    /**
     * Costruisce un'attvit&agrave;
     *
     * @param id               attvit&agrave;
     * @param dataOrarioInizio dell'attvit&agrave;
     * @param dataOrarioFine   dell'attvit&agrave;
     * @param descrizione      dell'attvit&agrave;
     * @param postiTotali      dell'attvit&agrave;
     * @param postiOccupati    dell'attvit&agrave;
     */
    public SimpleAttivita(long id,
                          GregorianCalendar dataOrarioInizio,
                          GregorianCalendar dataOrarioFine,
                          String descrizione,
                          int postiTotali,
                          int postiOccupati) {
        if (dataOrarioInizio == null || dataOrarioFine == null || descrizione == null)
            throw new NullPointerException("Non è possibile inserire campi nulli");
        if (dataOrarioFine.before(dataOrarioFine) || dataOrarioInizio.equals(dataOrarioFine))
            throw new IllegalArgumentException("Orario inzio e fine attività non validi");
        this.id = id;
        this.dataOrarioInizio = dataOrarioInizio;
        this.dataOrarioFine = dataOrarioFine;
        this.descrizione = descrizione;
        this.postiTotali = postiTotali;
        this.postiOccupati = postiOccupati;
    }

    /**
     * Costruisce un'attvit&agrave;
     *
     * @param dataOrarioInizio dell'attvit&agrave;
     * @param dataOrarioFine   dell'attvit&agrave;
     * @param descrizione      dell'attvit&agrave;
     * @param postiTotali      dell'attvit&agrave;
     * @param postiOccupati    dell'attvit&agrave;
     */
    public SimpleAttivita(GregorianCalendar dataOrarioInizio,
                          GregorianCalendar dataOrarioFine,
                          String descrizione,
                          int postiTotali,
                          int postiOccupati) {
        if (dataOrarioInizio == null || dataOrarioFine == null || descrizione == null)
            throw new NullPointerException("Non è possibile inserire campi nulli");
        if (dataOrarioFine.before(dataOrarioFine) || dataOrarioInizio.equals(dataOrarioFine))
            throw new IllegalArgumentException("Orario inzio e fine attività non validi");
        this.dataOrarioInizio = dataOrarioInizio;
        this.dataOrarioFine = dataOrarioFine;
        this.descrizione = descrizione;
        this.postiTotali = postiTotali;
        this.postiOccupati = postiOccupati;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public GregorianCalendar getDataOrarioInizio() {
        return this.dataOrarioInizio;
    }

    @Override
    public GregorianCalendar getDataOrarioFine() {
        return this.dataOrarioFine;
    }

    @Override
    public String getDescrizione() {
        return this.descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int getPostiTotali() {
        return this.postiTotali;
    }

    @Override
    public int getPostiOccupati() {
        return this.postiOccupati;
    }

    @Override
    public boolean setPostiOccupati(int postiOccupati) {
        if (postiOccupati > this.postiTotali || postiOccupati < 0)
            return false;
        this.postiOccupati = postiOccupati;
        return true;
    }

}

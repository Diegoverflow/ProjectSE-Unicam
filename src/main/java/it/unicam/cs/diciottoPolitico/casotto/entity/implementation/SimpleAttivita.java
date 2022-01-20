package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;

import javax.persistence.*;
import java.util.*;

/**
 * Semplice implementazione di un' {@link Attivita}.
 * Un' attivit&agrave; ha una data ed un orario in cui inizia e una data ed un orario in cui termina.
 * Inoltre ha un numero di posti totali di clienti che possono partciparne ed un numero di posti occupati per sapere quanti partecipanti ci sono
 * attualmente per questa attivit&agrave;.
 * Infine ha un proprio id univoco ed una descrizione che appunto descrive cosa fa quest' attivit&agrave;.
 */

@Entity
@Table(name = "attivita")
public class SimpleAttivita implements Attivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private final UUID id;
    @Column
    private GregorianCalendar dataOrarioInizio;
    @Column
    private GregorianCalendar dataOrarioFine;
    @Column
    private String descrizione;
    @Column
    private int postiTotali;
    @Column
    private int postiOccupati;  // TODO: eliminarlo per lasciarlo calcolare all' handler
    /**
     * Costruisce un'attvit&agrave;
     *
     * @param dataOrarioInizio dell'attvit&agrave;
     * @param dataOrarioFine   dell'attvit&agrave;
     * @param descrizione      dell'attvit&agrave;
     * @param postiTotali      dell'attvit&agrave;
     * @param postiOccupati    dell'attvit&agrave;
     * @throws NullPointerException     se la {@code dataOrarioInizio}, {@code dataOrarioFine} o la {@code descrizione} sono {@code null}
     * @throws IllegalArgumentException se la {@code dataOrarioFine} precede la {@code dataOrarioInizio} oppure se {@code dataOrarioInizio} e {@code dataOrarioFine} sono uguali secondo il meotodo equals
     */

    public SimpleAttivita(GregorianCalendar dataOrarioInizio,
                          GregorianCalendar dataOrarioFine,
                          String descrizione,
                          int postiTotali,
                          int postiOccupati) {
        this();
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

    protected SimpleAttivita() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleAttivita that = (SimpleAttivita) o;
        return id == that.id && postiTotali == that.postiTotali && dataOrarioInizio.equals(that.dataOrarioInizio) && dataOrarioFine.equals(that.dataOrarioFine) && descrizione.equals(that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataOrarioInizio, dataOrarioFine, descrizione, postiTotali);
    }
}

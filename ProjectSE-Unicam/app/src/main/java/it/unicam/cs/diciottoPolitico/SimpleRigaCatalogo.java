package it.unicam.cs.diciottoPolitico;

import java.util.*;

/**
 * Implementazione di una semplice classe per il catalogo degli ombrelloni.
 */
public class SimpleRigaCatalogo implements RigaCatalogo {

    private final Ombrellone ombrellone;
    private double prezzoOmbrellone;
    private List<Prenotazione> prenotazioni;

    /**
     * Crea una semplice riga catalogo in base all' ombrellone, il relativo prezzo e la lista delle prenotazioni ad esso associate.
     *
     * @param ombrellone       l' ombrellone relativo alla prenotazione
     * @param prezzoOmbrellone il prezzo associato all' ombrellone
     * @param prenotazione     la prenotazione associata all' ombrellone
     */
    public SimpleRigaCatalogo(Ombrellone ombrellone, double prezzoOmbrellone, Prenotazione prenotazione) {
        this(ombrellone, prezzoOmbrellone);
        if (prenotazione == null)
            throw new NullPointerException("Prenotazione da aggiungere null!");
        this.prenotazioni = new ArrayList<>();
        this.prenotazioni.add(prenotazione);
    }

    /**
     * Crea una semplice riga catalogo in base all' ombrellone il relativo prezzo e la lista delle prenotazioni ad esso associate
     *
     * @param ombrellone       l' ombrellone relativo alle prenotazioni
     * @param prezzoOmbrellone il prezzo associato all' ombrellone
     * @param prenotazioni     la lista delle prenotazioni associate all' ombrellone
     */
    public SimpleRigaCatalogo(Ombrellone ombrellone, double prezzoOmbrellone, List<Prenotazione> prenotazioni) {
        this(ombrellone, prezzoOmbrellone);
        if (prenotazioni == null) {
            throw new NullPointerException("Prenotazioni da aggiungere null!");
        }
        this.prenotazioni = new ArrayList<>();
        this.prenotazioni.addAll(prenotazioni);
    }

    /**
     * Crea una semplice riga catalogo passando l' ombrellone e il relativo prezzo.
     *
     * @param ombrellone       l' ombrellone da inserire nella riga catalogo
     * @param prezzoOmbrellone il prezzo associato all' ombrellone
     */
    public SimpleRigaCatalogo(Ombrellone ombrellone, double prezzoOmbrellone) {
        if (ombrellone == null)
            throw new NullPointerException("Ombrellone null!");
        if (prezzoOmbrellone < 0)
            throw new IllegalArgumentException("Prezzo negativo!");
        this.ombrellone = ombrellone;
        this.prezzoOmbrellone = prezzoOmbrellone;
    }


    @Override
    public double getPrezzoOmbrellone() {
        return this.prezzoOmbrellone;
    }

    @Override
    public Ombrellone getOmbrellone() {
        return this.ombrellone;
    }

    @Override
    public List<Prenotazione> getPrenotazioni() {
        return this.prenotazioni;
    }

    @Override
    public boolean getDisponibilita(Date date, FasciaOraria fasciaOraria) {
        // TODO: implementare
        return false;
    }

    @Override
    public void setPrezzoOmbrellone(double prezzoOmbrellone) {
        if (prezzoOmbrellone < 0)
            throw new IllegalArgumentException("Prezzo negativo!");
        this.prezzoOmbrellone = prezzoOmbrellone;
    }

    @Override
    public boolean addPrenotazione(Prenotazione prenotazione) {
        if (prenotazione == null)
            throw new NullPointerException("Prenotazione null!");

        return this.prenotazioni.add(prenotazione);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleRigaCatalogo that = (SimpleRigaCatalogo) o;
        return Double.compare(that.prezzoOmbrellone, prezzoOmbrellone) == 0 && Objects.equals(ombrellone, that.ombrellone) && Objects.equals(prenotazioni, that.prenotazioni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ombrellone, prezzoOmbrellone, prenotazioni);
    }
}

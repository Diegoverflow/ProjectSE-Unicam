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
     * @throws NullPointerException     se l' ombrellone o la prenotazione specificati &egrave; null
     * @throws IllegalArgumentException se il prezzo specificato non &egrave; valido
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
     * @throws NullPointerException     se l' ombrellone o la lista delle prenotazioni specificati &egrave; null
     * @throws IllegalArgumentException se il prezzo specificato non &egrave; valido
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
     * @throws NullPointerException     se l' ombrellone specificato &egrave; null
     * @throws IllegalArgumentException se il prezzo specificato non &egrave; valido
     */
    public SimpleRigaCatalogo(Ombrellone ombrellone, double prezzoOmbrellone) {
        if (ombrellone == null)
            throw new NullPointerException("Ombrellone null!");
        if (prezzoOmbrellone < 0)
            throw new IllegalArgumentException("Prezzo non valido!");
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
    public boolean getDisponibilita(Date data, FasciaOraria fasciaOraria) {
        if (data == null)
            throw new NullPointerException("Data null!");
        if (fasciaOraria == null)
            throw new NullPointerException("Fascia oraria null!");
        // TODO: Inserire controlli eccezione per data e fascia oraria non validi, ovvero se sono precedenti al giorno attuale
        return this.prenotazioni.stream()
                .anyMatch(p ->
                        p.getDataPrenotazione().equals(data)
                                && p.getFasciaOraria().equals(fasciaOraria));
    }

    @Override
    public void setPrezzoOmbrellone(double nuovoPrezzo) {
        if (nuovoPrezzo < 0)
            throw new IllegalArgumentException("Prezzo non valido!");
        this.prezzoOmbrellone = nuovoPrezzo;
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

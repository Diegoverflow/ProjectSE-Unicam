package it.unicam.cs.diciottoPolitico;

public class SimpleRigaCatologoAttivita implements RigaCatalogoAttivita  {

    private final Attivita attivita;
    private double prezzo;

    public SimpleRigaCatologoAttivita(Attivita attivita, double prezzo) {
        this.attivita = attivita;
        this.prezzo = prezzo;
    }

    @Override
    public Attivita getValore() {
        return this.attivita;
    }

    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}

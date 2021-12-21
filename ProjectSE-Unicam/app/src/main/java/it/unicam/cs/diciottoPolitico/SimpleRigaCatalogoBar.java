package it.unicam.cs.diciottoPolitico;
import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia RigaCatalogoBar.
 */
public class SimpleRigaCatalogoBar implements RigaCatalogoBar {

    private final ArticoloBar articoloBar;
    private double prezzo;
    private int quantita;

    /**
     * Metodo costruttore.
     *
     * @param articoloBar l'articolo bar associato alla riga
     * @param prezzo il prezzo associato alla riga
     * @param quantita la quantit&agrave; di articoli bar contenuti nella riga
     * @throws NullPointerException se l'articolo &egrave; nullo
     */
    public SimpleRigaCatalogoBar(ArticoloBar articoloBar, double prezzo, int quantita) {
        this.articoloBar = Objects.requireNonNull(articoloBar,"L'articolo bar non puo' essere nullo");
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    @Override
    public ArticoloBar getValore() {
        return this.articoloBar;
    }

    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public int getQuantita() {
        return this.quantita;
    }

    @Override
    public void setQuantita(int quantita) {
        if(quantita < 0)
            throw new IllegalArgumentException("La quantita' deve essere maggiore di 0");
        this.quantita = quantita;
    }

    @Override
    public void setPrezzo(double prezzo) {
        if(prezzo < 0)
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0");
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleRigaCatalogoBar)) return false;
        SimpleRigaCatalogoBar that = (SimpleRigaCatalogoBar) o;
        return Double.compare(that.getPrezzo(), getPrezzo()) == 0 && getQuantita() == that.getQuantita() && articoloBar.equals(that.articoloBar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articoloBar, getPrezzo(), getQuantita());
    }
}

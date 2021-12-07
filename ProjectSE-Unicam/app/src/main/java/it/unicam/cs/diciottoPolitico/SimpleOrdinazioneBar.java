package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia OrdinazioneBar.
 */
public class SimpleOrdinazioneBar implements OrdinazioneBar {

    private long id;
    private final GregorianCalendar dataAcquisto;
    private final double costo;
    private boolean consegnato;
    private boolean pagato;
    private boolean presoIncarico;

    /**
     * Metodo costruttore.
     *
     * @param dataAcquisto data di acquisto dell'ordinazione bar
     * @param costo        costo dell'ordinazione bar
     * @throws NullPointerException     se la data di acquisto è nulla
     * @throws IllegalArgumentException se il costo è negativo
     */
    public SimpleOrdinazioneBar(GregorianCalendar dataAcquisto, double costo) {
        this.dataAcquisto = Objects.requireNonNull(dataAcquisto, "La data di acquisto non puo' essere nulla");
        if (costo < 0) throw new IllegalArgumentException("Il costo non puo' essere negativo");
        this.costo = costo;
        this.consegnato = false;
        this.pagato = false;
        this.presoIncarico = false;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return this.dataAcquisto;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public boolean isConsegnato() {
        return this.consegnato;
    }

    @Override
    public boolean isPagato() {
        return this.pagato;
    }

    @Override
    public boolean isPresoInCarico() {
        return this.presoIncarico;
    }

    @Override
    public void setPagato(boolean pagato) {
        this.pagato = pagato;
    }

    @Override
    public void setConsegnato(boolean consegnato) {
        this.consegnato = consegnato;
    }

    @Override
    public void setPresoInCarico(boolean presoIncarico) {
        this.presoIncarico = presoIncarico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleOrdinazioneBar)) return false;
        SimpleOrdinazioneBar that = (SimpleOrdinazioneBar) o;
        return getId() == that.getId() && Double.compare(that.getCosto(), getCosto()) == 0 && isConsegnato() == that.isConsegnato() && isPagato() == that.isPagato() && presoIncarico == that.presoIncarico && getDataAcquisto().equals(that.getDataAcquisto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataAcquisto(), getCosto(), isConsegnato(), isPagato(), presoIncarico);
    }
}

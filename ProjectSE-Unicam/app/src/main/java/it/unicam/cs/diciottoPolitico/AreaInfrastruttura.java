package it.unicam.cs.diciottoPolitico;

import java.util.Objects;

/**
 * Rappresenta un' area dell' infrastruttura chalet che si occupa di fornire informazioni su
 * questa stessa area specifica.
 */
public class AreaInfrastruttura {

    private final long id;
    private String nome;
    private String descrizione;

    /**
     * Crea un' area dell' infrastruttura dello chalet in base a id, nome e descrizione specificati.
     *
     * @param id          l' id univoco di questa area infrastruttura
     * @param nome        il nome di quest' area infrastruttura
     * @param descrizione la descrizione di quest' area infrastruttura
     */
    public AreaInfrastruttura(long id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    /**
     * Restituisce l' id di questa area infrastruttura
     *
     * @return l' id di questa area infrastruttura
     */
    public long getId() {
        return id;
    }

    /**
     * Restituisce il nome di questa area infrastruttura
     *
     * @return il nome di questa area infrastruttura
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome specificato a questa area infrastruttura.
     *
     * @param nome il nome che avr&agrave; questa infrastruttura
     * @throws NullPointerException se il nome specificato &egrave; {@code null}
     */
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome, "Nome null!");
    }

    /**
     * Restituisce la descrizione riguardante questa area infrastruttura.
     *
     * @return la descrizione di questa area infrastruttura
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta la descrizione a questa area infrastruttura.
     *
     * @param descrizione la descrizione che avr&agrave; questa area infrastruttura
     * @throws NullPointerException se la dscrizione specificata &egrave; {@code null}
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione, "Descrizione null!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaInfrastruttura that = (AreaInfrastruttura) o;
        return id == that.id && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

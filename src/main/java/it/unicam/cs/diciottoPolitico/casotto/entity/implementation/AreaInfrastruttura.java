package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

/**
 * Rappresenta un' area dell' infrastruttura chalet che si occupa di fornire informazioni su
 * questa stessa area specifica.
 */
@Entity
@Table(name = "area_infrastruttura")
public class AreaInfrastruttura {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private final UUID id;
    @Column
    private String nome;
    @Column
    private String descrizione;

    /**
     * Crea un' area dell' infrastruttura dello chalet in base a id, nome e descrizione specificati.
     *
     * @param nome        il nome di quest' area infrastruttura
     * @param descrizione la descrizione di quest' area infrastruttura
     */
    public AreaInfrastruttura(String nome, String descrizione) {
        this();
        this.nome = nome;
        this.descrizione = descrizione;
    }

    protected AreaInfrastruttura() {
        this.id = UUID.randomUUID();
    }

    /**
     * Restituisce l' id di questa area infrastruttura
     *
     * @return l' id di questa area infrastruttura
     */
    public UUID getId() {
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

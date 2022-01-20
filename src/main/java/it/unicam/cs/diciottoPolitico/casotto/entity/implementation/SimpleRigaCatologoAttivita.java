package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoAttivita;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "righe_catalogo_attivita")
public class SimpleRigaCatologoAttivita implements RigaCatalogoAttivita {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private final UUID id;

    @OneToOne(targetEntity = SimpleAttivita.class)
    @JoinColumn(name = "attivita_id")
    private Attivita attivita;

    @Column
    private double prezzo;

    public SimpleRigaCatologoAttivita(Attivita attivita, double prezzo) {
        this();
        this.attivita = attivita;
        this.prezzo = prezzo;
    }

    public SimpleRigaCatologoAttivita() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId(){
        return  this.id;
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
        if(prezzo < 0)
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di 0");
        this.prezzo = prezzo;
    }
}

package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoAttivita;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "riga_catalogo_attivita")
public class SimpleRigaCatalogoAttivita implements RigaCatalogoAttivita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    @Getter
    private UUID id;

    @OneToOne(targetEntity = SimpleAttivita.class)
    @JoinColumn(name = "attivita_id", referencedColumnName = "id")
    @Getter
    private Attivita valore;//todo brutto nome

    @Column
    @Getter
    @Setter
    private double prezzo;

    @Column
    @Getter
    private int postiTotali;

    @OneToMany(targetEntity = SimplePrenotazioneAttivita.class,fetch = FetchType.LAZY,mappedBy = "id")
    @Getter
    private List<PrenotazioneAttivita> prenotazioniAttivita;

    public SimpleRigaCatalogoAttivita(Attivita attivita, double prezzo, int postiTotali) {
        this.id = UUID.randomUUID();
        this.valore = attivita;
        this.prezzo = prezzo;
        this.postiTotali = postiTotali;
        this.prenotazioniAttivita = new ArrayList<>();
    }

    public SimpleRigaCatalogoAttivita() {
    }

}

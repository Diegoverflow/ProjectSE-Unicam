package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoAttivita;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "riga_catalogo_attivita")
@Getter
@Setter
public class SimpleRigaCatalogoAttivita implements RigaCatalogoAttivita {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attivita_id", referencedColumnName = "id")
    private SimpleAttivita valore;//todo brutto nome

    @Column
    private double prezzo;

    @Column
    private int postiTotali;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
    private List<SimplePrenotazioneAttivita> prenotazioniAttivita;

}

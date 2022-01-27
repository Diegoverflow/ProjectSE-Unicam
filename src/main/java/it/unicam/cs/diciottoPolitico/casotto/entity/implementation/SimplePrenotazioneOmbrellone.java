package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prenotazione_ombrellone")
@Getter
@Setter
public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private FasciaOraria fasciaOraria;

    @ManyToOne
    @JoinColumn(name = "ombrellone_id",nullable = false)
    private SimpleOmbrellone ombrellone;

    @Temporal(TemporalType.DATE)
    private Date dataPrenotazione;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id",nullable = false)
    private SimpleVendita vendita;

    protected SimplePrenotazioneOmbrellone(){
        this.id = UUID.randomUUID();
    }

}

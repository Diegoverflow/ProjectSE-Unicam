package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prenotazione_ombrellone")
public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)",updatable = false,unique = true,nullable = false)
    @Getter
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private FasciaOraria fasciaOraria;

    @ManyToOne
    @JoinColumn(name = "ombrellone_id")
    @Getter
    @Setter
    private SimpleOmbrellone ombrellone;

    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date dataPrenotazione;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id")
    @Getter
    @Setter
    private SimpleVendita vendita;

}

package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.PrenotazioneOmbrellone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prenotazione_ombrellone")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false)
    private UUID id;

    @EqualsAndHashCode.Include
    @Enumerated(EnumType.STRING)
    @NonNull
    private FasciaOraria fasciaOraria;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "ombrellone_id")
    @NonNull
    private SimpleOmbrellone ombrellone;

    @EqualsAndHashCode.Include
    @Temporal(TemporalType.DATE)
    @NonNull
    private Date dataPrenotazione;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id",unique = true)
    @NonNull
    private SimpleVendita vendita;

    protected SimplePrenotazioneOmbrellone(){
        this.id = UUID.randomUUID();
    }

}

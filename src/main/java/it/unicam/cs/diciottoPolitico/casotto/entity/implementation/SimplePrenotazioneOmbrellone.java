package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private FasciaOraria fasciaOraria;

    @ManyToOne(targetEntity = SimpleOmbrellone.class)
    @JoinColumn(name = "ombrellone_id")
    @Getter
    private Ombrellone ombrellone;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataPrenotazione;

    @Temporal(TemporalType.DATE)
    @Getter
    private Date dataAcquisto;

    @Column
    @Getter
    @Setter
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    @Getter
    @Setter
    private boolean pagata;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    @Getter
    private Utente utente;

    /**
     *Costruisce una prenotazione.
     * @param fasciaOraria del giorno in cui si vuole fissare la prenotazione
     * @param ombrellonePrenotato ombrellone che si vuole prenotare
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @param costo della prenotazione
    * @apiNote alla data di acquisto &egrave; assegnata la data odierna e
     *          allo stato di pagamento &egrave; assegnato false di default
     */
    public SimplePrenotazioneOmbrellone(FasciaOraria fasciaOraria,
                              Ombrellone ombrellonePrenotato,
                                        Date dataPrenotazione,
                              double costo, Utente utente) {
        this.id = UUID.randomUUID();
        this.fasciaOraria = fasciaOraria;
        this.ombrellone = ombrellonePrenotato;
        this.dataPrenotazione = dataPrenotazione;
        this.costo = costo;
        this.utente = utente;
        this.dataAcquisto = new Date();
        this.pagata = false;
    }

    protected SimplePrenotazioneOmbrellone() {
    }

}

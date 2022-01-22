package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.FasciaOraria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prenotazione_ombrellone")
public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false,unique = true,nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private FasciaOraria fasciaOraria;

    @ManyToOne(targetEntity = SimpleOmbrellone.class)
    @JoinColumn(name = "ombrellone_id")
    private Ombrellone ombrellone;

    @Temporal(TemporalType.DATE)
    private GregorianCalendar dataPrenotazione;

    @Temporal(TemporalType.DATE)
    private GregorianCalendar dataAcquisto;

    @Column
    private double costo;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean statoPagamento;

    @ManyToOne(targetEntity = SimpleUtente.class)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @Column
    private static final int LIMITE_PRENOTAZIONE_MATTINA = 13;

    @Column
    private static final int LIMITE_PRENOTAZIONE_POMERIGGIO= 19;

    /**
     *Costruisce una prenotazione.
     * @param fasciaOraria del giorno in cui si vuole fissare la prenotazione
     * @param ombrellonePrenotato ombrellone che si vuole prenotare
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @param costo della prenotazione
     * @throws NullPointerException se la fascia oraria o l'ombrellone o la data di prenotazione o l'utente sono nulli
     * @throws IllegalArgumentException se la data della prenotazione o la fascia oraria sono antecedenti
     *                                  al momento in cui la prenotazione &egrave; effettuata oppure se
     *                                  non è più possibile prenotare in quella giornata perché passato l'orario di chiusura
     * @apiNote alla data di acquisto &egrave; assegnata la data odierna e
     *          allo stato di pagamento &egrave; assegnato false di default
     */
    public SimplePrenotazioneOmbrellone(FasciaOraria fasciaOraria,
                              Ombrellone ombrellonePrenotato,
                              GregorianCalendar dataPrenotazione,
                              double costo, Utente utente) {
        this();
        if (ombrellonePrenotato == null)
            throw new NullPointerException("Inserire un ombrellone non nullo");
        this.ombrellone = ombrellonePrenotato;
        this.dataAcquisto = new GregorianCalendar();
        if (dataPrenotazione == null)
            throw new NullPointerException("Inserire una data di prenotazione non nulla");
        if (dataPrenotazione.before(this.dataAcquisto))
            throw new IllegalArgumentException("Inserire una data valida");
        if (!this.dataPrenotazioneValida(dataPrenotazione, dataAcquisto))
            throw new IllegalArgumentException("Chiudiamo alle 19:00, scegliere un altro giorno");
        this.dataPrenotazione = dataPrenotazione;
        if (fasciaOraria == null)
            throw  new NullPointerException("Inserire una fascia orario non nulla");
        this.fasciaOraria = fasciaOraria;
        if (!this.fasciaOrariaValida(fasciaOraria, this.dataPrenotazione, this.dataAcquisto))
            throw new IllegalArgumentException("Fascia oraria non valida: mattina dalle 08:00 alle 13:00 - " +
                    "pomeriggio dalle 14:00 alle 19:00");
        this.costo = costo;
        this.statoPagamento = false;
        this.utente = Objects.requireNonNull(utente,"L'utente non puo' essere nullo");
    }


    protected SimplePrenotazioneOmbrellone() {
        this.id = UUID.randomUUID();
    }

    /**
     * Ipotizzando che la fascia oraria della giornata si estenda fino alle 19,
     * controlla che la data di prenotazione fissata nel corso della giornata odierna sia valida
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @param dataAcquisto nella quale la prenotazione &egrave; registrata
     * @return true se la data di prenotazione &egrave; valida,
     *         false altrimenti
     */
    private boolean dataPrenotazioneValida(GregorianCalendar dataPrenotazione, GregorianCalendar dataAcquisto){
        if (dataPrenotazione.get(GregorianCalendar.YEAR)==dataAcquisto.get(GregorianCalendar.YEAR) &&
                dataPrenotazione.get(GregorianCalendar.MONTH)==dataAcquisto.get(GregorianCalendar.MONTH) &&
                dataPrenotazione.get(GregorianCalendar.DAY_OF_MONTH)==dataAcquisto.get(GregorianCalendar.DAY_OF_MONTH)) {
            return dataAcquisto.get(GregorianCalendar.HOUR_OF_DAY) < SimplePrenotazioneOmbrellone.LIMITE_PRENOTAZIONE_POMERIGGIO;
        }
        return true;
    }

    /**
     * Ipotizzando che la fascia oraria della mattina sia fino alle 13 e quella della sera fino alle 19,
     * controlla la validita della fascia oraria selezionata
     * @param fasciaOraria del giorno in cui si vuole fissare la prenotazione
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @return true fascia ora
     */
    private boolean fasciaOrariaValida(FasciaOraria fasciaOraria,
                                       GregorianCalendar dataPrenotazione,
                                       GregorianCalendar dataAcquisto){
        if (dataPrenotazione.get(GregorianCalendar.YEAR)==dataAcquisto.get(GregorianCalendar.YEAR) &&
                dataPrenotazione.get(GregorianCalendar.MONTH)==dataAcquisto.get(GregorianCalendar.MONTH) &&
                dataPrenotazione.get(GregorianCalendar.DAY_OF_MONTH)==dataAcquisto.get(GregorianCalendar.DAY_OF_MONTH)) {
            if (fasciaOraria.equals(FasciaOraria.MATTINO)) {
                if (dataAcquisto.get(GregorianCalendar.HOUR_OF_DAY) >= SimplePrenotazioneOmbrellone.LIMITE_PRENOTAZIONE_MATTINA)
                    return false;
            }
            return dataAcquisto.get(GregorianCalendar.HOUR_OF_DAY) < SimplePrenotazioneOmbrellone.LIMITE_PRENOTAZIONE_POMERIGGIO;
        }
        return true;
    }

    @Override
    public UUID getCodice() {
        return this.id;
    }

    @Override
    public GregorianCalendar getDataPrenotazione() {
        return this.dataPrenotazione;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return this.dataAcquisto;
    }

    @Override
    public boolean isPagata() {
        return this.statoPagamento;
    }

    @Override
    public void setPagata(boolean statoPagamento) {
        this.statoPagamento = statoPagamento;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public Ombrellone getOmbrellone() {
        return this.ombrellone;
    }

    @Override
    public FasciaOraria getFasciaOraria() {
        return this.fasciaOraria;
    }

    @Override
    public Utente getUtente() {
        return this.utente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimplePrenotazioneOmbrellone)) return false;
        SimplePrenotazioneOmbrellone that = (SimplePrenotazioneOmbrellone) o;
        return getFasciaOraria() == that.getFasciaOraria() && getOmbrellone().equals(that.getOmbrellone()) && getDataPrenotazione().equals(that.getDataPrenotazione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFasciaOraria(), getOmbrellone(), getDataPrenotazione());
    }
}

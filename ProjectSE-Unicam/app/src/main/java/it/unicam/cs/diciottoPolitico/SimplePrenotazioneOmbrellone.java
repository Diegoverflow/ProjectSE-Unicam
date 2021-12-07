package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone{

    private long codice;
    private final FasciaOraria fasciaOraria;
    private final Ombrellone ombrellone;
    private final GregorianCalendar dataPrenotazione;
    private final GregorianCalendar dataAcquisto;
    private final double costo;
    private final boolean statoPagamento;
    private static final int LIMITE_PRENOTAZIONE_MATTINA = 13;
    private static final int LIMITE_PRENOTAZIONE_POMERIGGIO= 19;

    /**
     *Costruisce una prenotazione.
     * @param codice identificativo del cliente
     * @param fasciaOraria del giorno in cui si vuole fissare la prenotazione
     * @param ombrellonePrenotato ombrellone che si vuole prenotare
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @param costo della prenotazione
     * @throws NullPointerException se la fascia oraria o l'ombrellone o la data di prenotazione sono nulli
     * @throws IllegalArgumentException se la data della prenotazione o la fascia oraria sono antecedenti
     *                                  al momento in cui la prenotazione &egrave; effettuata oppure se
     *                                  non è più possibile prenotare in quella giornata perché passato l'orario di chiusura
     * @apiNote alla data di acquisto &egrave; assegnata la data odierna e
     *          allo stato di pagamento &egrave; assegnato false di default
     */
    public SimplePrenotazioneOmbrellone(long codice,
                              FasciaOraria fasciaOraria,
                              Ombrellone ombrellonePrenotato,
                              GregorianCalendar dataPrenotazione,
                              double costo) {
        this.codice = codice;
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
    }

    /**
     *Costruisce una prenotazione.
     * @param fasciaOraria del giorno in cui si vuole fissare la prenotazione
     * @param ombrellonePrenotato ombrellone che si vuole prenotare
     * @param dataPrenotazione nella quale la prenotazione &egrave; riservata
     * @param costo della prenotazione
     * @throws NullPointerException se la fascia oraria o l'ombrellone o la data di prenotazione sono nulli
     * @throws IllegalArgumentException se la data della prenotazione o la fascia oraria sono antecedenti
     *                                  al momento in cui la prenotazione &egrave; effettuata oppure se
     *      *                           non è più possibile prenotare in quella giornata perché passato l'orario di chiusura
     * @apiNote alla data di acquisto &egrave; assegnata la data odierna e
     *          allo stato di pagamento &egrave; assegnato false di default
     */
    public SimplePrenotazioneOmbrellone(FasciaOraria fasciaOraria,
                              Ombrellone ombrellonePrenotato,
                              GregorianCalendar dataPrenotazione,
                              double costo) {
        if (ombrellonePrenotato == null)
            throw new NullPointerException("Inserire un ombrellone non nullo");
        this.ombrellone = ombrellonePrenotato;
        this.dataAcquisto = new GregorianCalendar();
        if (dataPrenotazione == null)
            throw new NullPointerException("Inserire una data di prenotazione non nulla");
        if (dataPrenotazione.before(this.dataAcquisto))
            throw new IllegalArgumentException("Inserire una data valida");
        if (!this.dataPrenotazioneValida(dataPrenotazione, this.dataAcquisto))
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
    public long getId() {
        return this.codice;
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
    public boolean getStatoPagamento() {
        return this.statoPagamento;
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
}

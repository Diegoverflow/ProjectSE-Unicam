package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Semplice implementazione dell'interfaccia Cliente
 */
public class SimpleCliente implements Cliente{

    private long id;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private String numero;
    private String password;
    private final Queue<Notifica> notifiche;
    private final List<PrenotazioneOmbrellone> prenotazioni;
    private final List<PrenotazioneAttivita> prenotazioniAttivita;
    private final List<OrdinazioneBar> ordinazioniBar;
    /**
     * Costruisce un SimpleCliente
     * @param codiceFiscale del cliente
     * @param password del cliente
     * @param nome del cliente
     * @param cognome del cliente
     * @param numero del cliente
     */
    public SimpleCliente(long id , String codiceFiscale,String password, String nome, String cognome, String numero) {
        this(codiceFiscale,password,nome,cognome,numero);
        this.id = id;
    }

    /**
     * Costruisce un SimpleCliente
     * @param codiceFiscale del cliente
     * @param password del cliente
     * @param nome del cliente
     * @param cognome del cliente
     * @param numero del cliente
     */
    public SimpleCliente(String codiceFiscale,String password, String nome, String cognome, String numero) {
        if (codiceFiscale == null || password == null || nome == null || cognome == null || numero == null) {
            throw new NullPointerException("Inserire dei dati non nulli");
        }
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.notifiche = new LinkedList<>();
        this.prenotazioni = new LinkedList<>();
        this.prenotazioniAttivita = new LinkedList<>();
        this.ordinazioniBar = new LinkedList<>();
    }

    @Override
    public String getCodiceFiscale() {
        return this.codiceFiscale;
    }

    @Override
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = Objects.requireNonNull(codiceFiscale,"Il codice non puo' essere nullo");
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password,"La password non puo' essere nulla");
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        if (nome == null)
            throw new NullPointerException("Inserire un nome non nullo");
        this.nome = nome;
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }

    @Override
    public void setCognome(String cognome) {
        if (cognome == null)
            throw new NullPointerException("Inserire un cognome non nullo");
        this.cognome = cognome;
    }

    @Override
    public String getNumero() {
        return this.numero;
    }

    @Override
    public void setNumero(String numero) {
        if (numero == null)
            throw new NullPointerException("Inserire un numero non nullo");
        this.numero = numero;
    }

    @Override
    public Queue<Notifica> getNotifiche() {
        return this.notifiche;
    }

    @Override
    public boolean addNotica(Notifica notifica) {
        if (notifica == null)
            throw new NullPointerException("Notifica nulla");
        if (!this.notifiche.contains(notifica))
            return this.notifiche.add(notifica);
        return false;
    }

    @Override
    public boolean removeNotifica(Notifica notifica) {
        int sizeNotifiche = this.notifiche.size();
        this.notifiche.stream()
                .parallel()
                .filter(n -> n.equals(notifica))
                .findFirst()
                .ifPresent(this.notifiche::remove);
        return this.notifiche.size() < sizeNotifiche;
    }

    @Override
    public List<PrenotazioneOmbrellone> getPrenotazioniOmbrelloni() {
        return this.prenotazioni;
    }

    @Override
    public boolean addPrenotazioneOmbrellone(PrenotazioneOmbrellone prenotazione) {
        if (prenotazione == null)
            throw new NullPointerException("Prenotazione nulla");
        if (!this.prenotazioni.contains(prenotazione))
            return this.prenotazioni.add(prenotazione);
        return false;
    }

    @Override
    public List<PrenotazioneAttivita> getPrenotazioniAttivita() {
        return this.prenotazioniAttivita;
    }

    @Override
    public boolean addPrenotazioneAttivita(PrenotazioneAttivita prenotazioneAttivita) {
        if (prenotazioneAttivita == null)
            throw new NullPointerException("Prenotazione nulla");
        if (!this.prenotazioniAttivita.contains(prenotazioneAttivita))
            return this.prenotazioniAttivita.add(prenotazioneAttivita);
        return false;
    }

    @Override
    public List<OrdinazioneBar> getOrdinazioniBar() {
        return this.ordinazioniBar;
    }

    @Override
    public boolean addOrdinazioneBar(OrdinazioneBar ordinazioneBar) {
        if (ordinazioneBar == null)
            throw new NullPointerException("Ordinazione bar nulla");
        if (!this.ordinazioniBar.contains(ordinazioneBar))
            return this.ordinazioniBar.add(ordinazioneBar);
        return false;
    }

}

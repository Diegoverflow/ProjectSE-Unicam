package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

// TODO: completare javadoc

/**
 * Semplice implementazione dell'interfaccia {@link Cliente}
 */
public class SimpleCliente implements Cliente {

    private long id;
    private String email;
    private String nome;
    private String cognome;
    private String cellulare;
    private String password;
    private final Queue<Notifica> notifiche;
    private final List<PrenotazioneOmbrellone> prenotazioni;
    private final List<PrenotazioneAttivita> prenotazioniAttivita;
    private final List<OrdinazioneBar> ordinazioniBar;

    /**
     * Costruisce un SimpleCliente
     *
     * @param email    del cliente
     * @param password del cliente
     * @param nome     del cliente
     * @param cognome  del cliente
     * @param cellulare   del cliente
     */
    public SimpleCliente(long id, String email, String password, String nome, String cognome, String cellulare) {
        this(email, password, nome, cognome, cellulare);
        this.id = id;
    }

    /**
     * Costruisce un SimpleCliente
     *
     * @param email    del cliente
     * @param password del cliente
     * @param nome     del cliente
     * @param cognome  del cliente
     * @param cellulare   del cliente
     */
    public SimpleCliente(String email, String password, String nome, String cognome, String cellulare) {
        if (email == null || password == null || nome == null || cognome == null || cellulare == null) {
            throw new NullPointerException("Inserire dei dati non nulli");
        }
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.cellulare = cellulare;
        this.notifiche = new LinkedList<>();
        this.prenotazioni = new LinkedList<>();
        this.prenotazioniAttivita = new LinkedList<>();
        this.ordinazioniBar = new LinkedList<>();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setCodiceFiscale(String codiceFiscale) {
        this.email = Objects.requireNonNull(codiceFiscale, "Il codice non puo' essere nullo");
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
        this.password = Objects.requireNonNull(password, "La password non puo' essere nulla");
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
    public String getCellulare() {
        return this.cellulare;
    }

    @Override
    public void setCellulare(String cellulare) {
        if (cellulare == null)
            throw new NullPointerException("Inserire un numero non nullo");
        this.cellulare = cellulare;
    }

    @Override
    public Queue<Notifica> getNotifiche() {
        return this.notifiche;
    }

    @Override
    public boolean addNotifica(Notifica notifica) {
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

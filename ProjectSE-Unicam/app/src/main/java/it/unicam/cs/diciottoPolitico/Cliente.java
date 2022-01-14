package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Rappresenta un cliente che pu&ograve; effettuare operazioni di prenotazione per gli ombrelloni,
 * per le ordinazioni bar e le attivit&agrave; messe a disposizione dallo chalet.
 * Il cliente pu&ograve; essere notificato per eventuali promozioni.
 */
public class Cliente implements Utente {

    public static final RuoloUtente ruolo = RuoloUtente.CLIENTE;
    private final long id;
    private String nome;
    private String cognome;
    private String password;
    private String cellulare;
    private String email;
    private final Queue<Notifica> notifiche;
    private final List<PrenotazioneAttivita> prenotazioniAttivita;
    private final List<OrdinazioneBar> ordinazioniBar;

    /**
     * Crea un cliente in base a id, nome, cognome, password, cellulare ed email specificati.
     *
     * @param id        l' id associato a questo addetto bar
     * @param nome      il nome a questo addetto bar
     * @param cognome   il cognome associato a questo addetto bar
     * @param password  la password di questo addetto bar
     * @param cellulare il cellulare di questo addetto bar
     * @param email     l' email di questo addetto bar
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public Cliente(long id, String nome, String cognome, String password, String cellulare, String email) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Cellulare null!");
        this.email = Objects.requireNonNull(email, "Email null!");
        this.notifiche = new LinkedList<>();
        this.prenotazioniAttivita = new ArrayList<>();
        this.ordinazioniBar = new ArrayList<>();
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
        this.password = Objects.requireNonNull(password, "Password null!");
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull("Nome null!");
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull("Cognome null!");
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }

    @Override
    public String getCellulare() {
        return this.cellulare;
    }

    @Override
    public void setCellulare(String cellulare) {
        this.cellulare = Objects.requireNonNull(cellulare, "Cellulare null!");
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "Email null!");
    }

    @Override
    public Queue<Notifica> getNotifiche() {
        return this.notifiche;
    }

    @Override
    public boolean addNotifica(Notifica notifica) {
        if (!this.notifiche.contains(Objects.requireNonNull(notifica, "Notifica null!")))
            return this.notifiche.add(notifica);
        return false;
    }

    @Override
    public boolean removeNotifica(Notifica notifica) {
        return this.notifiche.remove(notifica);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente that = (Cliente) o;
        return getId() == that.getId() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCognome());
    }


    /**
     * Restituisce la lista delle prenotazioni delle attivit&agrave; effettuate da questo cliente.
     *
     * @return la lista delle prenotazioni delle attivit&agrave; effettuate da questo cliente
     */
    public List<PrenotazioneAttivita> getPrenotazioniAttivita() {
        return this.prenotazioniAttivita;
    }

    /**
     * Aggiunge la {@link PrenotazioneAttivita} specificata alle prenotazioni delle attivit&agrave; di questo cliente.
     * Restituisce {@code true} se la prenotazione specificata viene aggiunta con successo,
     * {@code false} altrimenti.
     *
     * @param prenotazione la prenotazione da aggiungere alle prenotazioni di questo cliente
     * @return {@code true} se la prenotazione viene aggiunta alle prenotazioni delle attivit&agrave;
     * di questo cliente, {@code false} altrimenti
     */
    public boolean addPrenotazioneAttivita(PrenotazioneAttivita prenotazione) {
        Objects.requireNonNull(prenotazione, "Prenotazione null!");
        if (!this.prenotazioniAttivita.contains(prenotazione))
            return this.prenotazioniAttivita.add(prenotazione);
        return false;
    }

    /**
     * Restituisce la lista delle ordinazioni bar effettuate da questo cliente.
     *
     * @return la lista di tutte le ordinazioni bar effettuate da questo cliente
     */
    public List<OrdinazioneBar> getOrdinazioniBar() {
        return this.ordinazioniBar;
    }

    /**
     * Aggiunge l' {@link OrdinazioneBar} specificata alle ordinazioni effettuate da questo cliente.
     * Restituisce {@code true} se l' ordinazione specificata viene aggiunta con successo,
     * {@code false} altrimenti.
     *
     * @param ordinazione l' ordinazione da aggiungere alle ordinazioni di questo cliente
     * @return {@code true} se la prenotazione viene aggiunta alle ordinazioni effettuate
     * da questo cliente, {@code false} altrimenti
     */
    public boolean addOrdinazioneBar(OrdinazioneBar ordinazione) {
        Objects.requireNonNull(ordinazione, "Ordinazione bar null!");
        if (!this.ordinazioniBar.contains(ordinazione))
            return this.ordinazioniBar.add(ordinazione);
        return false;
    }

}

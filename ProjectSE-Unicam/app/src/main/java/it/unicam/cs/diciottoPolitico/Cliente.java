package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
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
        this.nome = Objects.requireNonNull(nome,"Nome null!");
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull(cognome,"Cognome null!");
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

    @Override
    public RuoloUtente getRuolo() {
        return Cliente.ruolo;
    }

}

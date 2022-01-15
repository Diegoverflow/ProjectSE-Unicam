package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Semplice implementazione dell'interfaccia Utente.
 */
public class SimpleUtente implements Utente {

    private long id;
    private String nome;
    private String cognome;
    private String password;
    private String cellulare;
    private String email;
    private final RuoloUtente ruoloUtente;
    private final Queue<Notifica> notifiche;

    /**
     * Crea un utente in base a id, nome, cognome, password, cellulare ed email specificati.
     *
     * @param nome      il nome a questo addetto bar
     * @param cognome   il cognome associato a questo addetto bar
     * @param password  la password di questo addetto bar
     * @param cellulare il cellulare di questo addetto bar
     * @param email     l' email di questo addetto bar
     * @param ruoloUtente il ruolo dell'utente
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public SimpleUtente(String nome, String cognome, String password, String cellulare, String email, RuoloUtente ruoloUtente) {
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Cellulare null!");
        this.email = Objects.requireNonNull(email, "Email null!");
        this.ruoloUtente = Objects.requireNonNull(ruoloUtente,"Ruolo null!");
        this.notifiche = new LinkedList<>();
    }

    /**
     * Crea un utente in base a id, nome, cognome, password, cellulare ed email specificati.
     *
     * @param id        l' id associato a questo addetto bar
     * @param nome      il nome a questo addetto bar
     * @param cognome   il cognome associato a questo addetto bar
     * @param password  la password di questo addetto bar
     * @param cellulare il cellulare di questo addetto bar
     * @param email     l' email di questo addetto bar
     * @param ruoloUtente il ruolo dell'utente
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public SimpleUtente(long id, String nome, String cognome, String password, String cellulare, String email, RuoloUtente ruoloUtente) {
        this(nome, cognome, password, cellulare, email, ruoloUtente);
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUtente that = (SimpleUtente) o;
        return id == that.id && nome.equals(that.nome) && cognome.equals(that.cognome) && password.equals(that.password) && cellulare.equals(that.cellulare) && email.equals(that.email) && ruoloUtente == that.ruoloUtente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, password, cellulare, email, ruoloUtente);
    }

    @Override
    public RuoloUtente getRuolo() {
        return this.ruoloUtente;
    }

}

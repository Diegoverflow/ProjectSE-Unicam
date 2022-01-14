package it.unicam.cs.diciottoPolitico;

import java.util.Objects;
import java.util.Queue;

/**
 * Rappresenta il gestore dello chalet che si occupa di gestire lo chalet.
 */
public class Gestore implements Utente {

    public static final RuoloUtente ruolo = RuoloUtente.GESTORE;
    private final long id;
    private String nome;
    private String cognome;
    private String password;
    private String cellulare;
    private String email;

    /**
     * Crea un gestore in base a id, nome, cognome, password, cellulare ed email specificati.
     *
     * @param id        l' id associato a questo gestore
     * @param nome      il nome a questo addetto gestore
     * @param cognome   il cognome associato a questo gestore
     * @param password  la password di questo gestore
     * @param cellulare il cellulare di questo gestore
     * @param email     l' email di questo gestore
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public Gestore(long id, String nome, String cognome, String password, String cellulare, String email) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Cellulare null!");
        this.email = Objects.requireNonNull(email, "Email null!");
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
        this.nome = Objects.requireNonNull(nome, "Nome null!");
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
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
        throw new UnsupportedOperationException("Il gestore non ha notifiche");
    }

    @Override
    public boolean addNotifica(Notifica notifica) {

        throw new UnsupportedOperationException("Il gestore non aggiunge notifiche");
    }

    @Override
    public boolean removeNotifica(Notifica notifica) {
        throw new UnsupportedOperationException("Il gestore non rimuove notifiche");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gestore)) return false;
        Gestore that = (Gestore) o;
        return getId() == that.getId() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCognome());
    }

    @Override
    public RuoloUtente getRuolo() {
        return Gestore.ruolo;
    }

}

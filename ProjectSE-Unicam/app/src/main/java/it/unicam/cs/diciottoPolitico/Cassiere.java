package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Rappresenta un cassiere che si occupa di far pagare i clienti che richiedono di saldare una vendita.
 */
public class Cassiere implements Utente {

    private final long id;
    private String nome;
    private String cognome;
    private String password;
    private RuoloUtente ruolo;
    private String cellulare;
    private String email;
    private final Queue<Notifica> notifiche; // TODO: rimuovere notifiche oppure no? UnsupportedOperationException

    /**
     * Crea un cassiere in base a id, nome, cognome, password, cellulare ed email specificati.
     *
     * @param id        l' id associato a questo cassiere
     * @param nome      il nome a questo cassiere
     * @param cognome   il cognome associato a questo cassiere
     * @param password  la password di questo cassiere
     * @param cellulare il cellulare di questo cassiere
     * @param email     l' email di questo cassiere
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public Cassiere(long id, String nome, String cognome, String password, String cellulare, String email) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.ruolo = RuoloUtente.CASSIERE;
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
    public RuoloUtente getRuolo() {
        return this.ruolo;
    }

    @Override
    public void setRuolo(RuoloUtente ruolo) {
        this.ruolo = Objects.requireNonNull(ruolo, "Ruolo null!");
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
        //return this.notifiche;
        throw new UnsupportedOperationException("Il cassiere non ha notifiche");
    }

    @Override
    public boolean addNotifica(Notifica notifica) {
        /*if (!this.notifiche.contains(Objects.requireNonNull(notifica, "Notifica null!")))
            return this.notifiche.add(notifica);
        return false;*/
        throw new UnsupportedOperationException("Il cassiere non aggiunge notifiche");
    }

    @Override
    public boolean removeNotifica(Notifica notifica) {
        //return this.notifiche.remove(notifica);
        throw new UnsupportedOperationException("Il cassiere non rimuove notifiche");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cassiere)) return false;
        Cassiere that = (Cassiere) o;
        return getId() == that.getId() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCognome());
    }

}

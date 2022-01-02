package it.unicam.cs.diciottoPolitico;

import java.util.*;

/**
 * Implementazione di un semplice {@link AddettoBar}.
 */
public class SimpleAddettoBar implements AddettoBar {

    private long id;
    private String nome;
    private String cognome;
    private String password;
    private String cellulare;
    private final Queue<Notifica> notifiche;
    private final Queue<OrdinazioneBar> ordinazioniBarConsegnate;

    /**
     * Crea un semplice addetto bar in base all' id, nome, cognome e password specificati.
     *
     * @param id       l' id dell' addetto bar da creare
     * @param nome     il nome dell' addetto bar da creare
     * @param cellulare  cellulare dell'addetto bar
     * @param cognome  il cognome dell' addetto bar da creare
     * @param password la password dell' addetto bar da creare
     * @throws NullPointerException se almeno uno dei parametri &egrave; {@code null}
     */

    public SimpleAddettoBar(long id, String nome, String cellulare, String cognome, String password) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Il cellulare non puo' essere nullo");
        this.notifiche = new LinkedList<>();
        this.ordinazioniBarConsegnate = new LinkedList<>();
    }

    /**
     * Crea un semplice addetto bar in base al nome, cognome e password specificati.
     *
     * @param nome     il nome dell' addetto bar da creare
     * @param cellulare  cellulare dell'addetto bar
     * @param cognome  il cognome dell' addetto bar da creare
     * @param password la password dell' addetto bar da creare
     * @throws NullPointerException se almeno uno dei parametri &egrave; {@code null}
     */

    public SimpleAddettoBar(String nome, String cellulare, String cognome, String password) {
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Il cellulare non puo' essere nullo");
        this.notifiche = new LinkedList<>();
        this.ordinazioniBarConsegnate = new LinkedList<>();
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getNome() {
        return this.nome;
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
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome, "Il nome non puo' essere nullo");
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull(cognome, "Il cognome non puo' essere nullo");
    }

    @Override
    public void setCellulare(String cellulare) {
        this.cellulare = Objects.requireNonNull(cellulare, "Il cellulare non puo' essere nullo");
    }

    @Override
    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password, "La password non puo' essere nulla");
    }

    @Override
    public Queue<Notifica> getNotifiche() {
        return this.notifiche;
    }

    @Override
    public boolean addNotifica(Notifica notifica) {
        if (!this.notifiche.contains(Objects.requireNonNull(notifica, "Notifica nulla")))
            return this.notifiche.add(notifica);
        return false;
    }

    @Override
    public boolean removeNotifica(Notifica notifica) {
        return this.notifiche.remove(notifica);
    }


    @Override
    public Queue<OrdinazioneBar> getordinazioniBarConsegnate() {
        return this.ordinazioniBarConsegnate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleAddettoBar)) return false;
        SimpleAddettoBar that = (SimpleAddettoBar) o;
        return getId() == that.getId() && getNome().equals(that.getNome()) && getCognome().equals(that.getCognome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCognome());
    }
}

package it.unicam.cs.diciottoPolitico;

import java.util.*;

//TODO: Modifica javadoc

/**
 * Implementazione di un semplice addetto bar.
 */
public class SimpleAddettoBar implements AddettoBar {

    private final long id;
    private String nome;
    private String cognome;
    private String password;
    private String numero;
    private final Queue<Notifica> notifiche;
    private final Queue<OrdinazioneBar> ordinazioneBarConsegnate;

    /**
     * Crea un semplice addetto bar in base all' id, nome, cognome e password specificati.
     *
     * @param id                    l' id dell' addetto bar da creare
     * @param nome                  il nome dell' addetto bar da creare
     * @param cognome               il cognome dell' addetto bar da creare
     * @param password              la password dell' addetto bar da creare
     * @param handlerOrdinazioneBar l' handler per le ordinazioni bar con cui l' addetto interagisce
     * @throws NullPointerException se uno dei parametri &egrave; nullo
     */

    public SimpleAddettoBar(long id, String nome, String numero, String cognome, String password, HandlerOrdinazioneBar handlerOrdinazioneBar) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.numero = Objects.requireNonNull(numero, "Il numero non puo' essere nullo");
        this.notifiche = new LinkedList<>();
        this.ordinazioneBarConsegnate = new LinkedList<>();
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
    public String getNumero() {
        return this.numero;
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
    public void setNumero(String numero) {
        this.numero = Objects.requireNonNull(numero, "Il numero non puo' essere nullo");
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
    public Queue<OrdinazioneBar> getOrdinazione() {
        return this.ordinazioneBarConsegnate;
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

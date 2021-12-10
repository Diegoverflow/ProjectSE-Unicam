package it.unicam.cs.diciottoPolitico;

import java.util.*;

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
     * @param id                    l' id dell' addetto bar da creare
     * @param nome                  il nome dell' addetto bar da creare
     * @param cognome               il cognome dell' addetto bar da creare
     * @param password              la password dell' addetto bar da creare
     * @param handlerOrdinazioneBar l' handler per le ordinazioni bar con cui l' addetto interagisce
     * @throws NullPointerException se uno dei parametri &egrave; nullo
     * @link {https://www.google.com/search?q=uomo+che+dorme&client=firefox-b-d&sxsrf=AOaemvJLUBVPxFt-cgCBWq3HmSg3qPWRjA:1638974026904&tbm=isch&source=iu&ictx=1&fir=i6PNe-OlOFicJM%252CQKxMucXT4LEodM%252C_%253B-Fyx7NfMn7kAxM%252CoXUihJRJYXF3yM%252C_%253B5TN6_r-7tKqV3M%252CKJbnn_aw6OnQUM%252C_%253B_fPD0JYnZC3NKM%252CdyE47U1FzIfPDM%252C_%253BCnwH1azAGgG6aM%252CUVsa0gEpEs9ZbM%252C_%253Bbe2beVQBGoC5FM%252Cy8tp1-H98PqyGM%252C_%253BR0_GZ2jy1Lo8YM%252Cjz68LeW3dUii7M%252C_%253Ba8nCc5o40Xvj-M%252C49BV6u0HAK9akM%252C_%253BhYbwlX83SIVDoM%252C_LPfFM_gYSmMbM%252C_%253Bt-4HAC5GsJsvMM%252CTH40Er5y4jklJM%252C_%253B7qw8MklDnYgHVM%252Clpdd7lj84JVyEM%252C_%253BWt4KabQProJLOM%252C0VXKSqz2YgrU4M%252C_&vet=1&usg=AI4_-kRzsgYs4qYH_k0nBx_NEPJJmtgIlQ&sa=X&ved=2ahUKEwiTh62FttT0AhURCewKHbn_AuoQ9QF6BAgPEAE&biw=1536&bih=739&dpr=1.25#imgrc=hYbwlX83SIVDoM}
     * Crea un semplice addetto bar in base all' id, nome, cognome e password specificati.
     */

    public SimpleAddettoBar(long id, String nome, String numero, String cognome, String password, HandlerOrdinazioneBar handlerOrdinazioneBar) {
        Objects.requireNonNull(nome, "Nome null!");
        Objects.requireNonNull(cognome, "Cognome null!");
        Objects.requireNonNull(password, "Password null!");
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.numero = Objects.requireNonNull(numero,"Il numero non puo' essere nullo");
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
        this.nome = Objects.requireNonNull(nome,"Il nome non puo' essere nullo");
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull(cognome,"Il cognome non puo' essere nullo");
    }

    @Override
    public void setNumero(String numero) {
        this.numero = Objects.requireNonNull(numero,"Il numero non puo' essere nullo");
    }
    @Override
    public Queue<Notifica> getNotifiche() {
        return this.notifiche;
    }

    @Override
    public boolean addNotica(Notifica notifica) {
        if (!this.notifiche.contains(Objects.requireNonNull(notifica,"Notifica nulla")))
            return this.notifiche.add(notifica);
        return false;
    }

    @Override
    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password,"La password non puo' essere nulla");
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

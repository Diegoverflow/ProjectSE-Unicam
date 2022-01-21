package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Notifica;
import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import javax.persistence.*;
import java.util.*;

/**
 * Semplice implementazione dell' interfaccia Utente.
 */
@Entity
@Table(name = "utente")
public class SimpleUtente implements Utente {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private final UUID id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String password;
    @Column
    private String cellulare;
    @Column
    private String email;
    @Enumerated(EnumType.STRING)
    private RuoloUtente ruoloUtente;

    @ManyToMany(targetEntity = SimpleNotifica.class, fetch = FetchType.LAZY)
    @JoinTable(name = "utente_notifica",
            joinColumns = {@JoinColumn(name = "utente_id")},
            inverseJoinColumns = {@JoinColumn(name = "notifica_id")}
    )
    private final List<Notifica> notifiche;

    /**
     * Crea un utente in base a id, nome, cognome, password, cellulare, email e ruolo utente specificati.
     *
     * @param nome        il nome a questo addetto bar
     * @param cognome     il cognome associato a questo addetto bar
     * @param password    la password di questo addetto bar
     * @param cellulare   il cellulare di questo addetto bar
     * @param email       l' email di questo addetto bar
     * @param ruoloUtente il ruolo dell'utente
     * @throws NullPointerException se almeno uno sei parametri specificati &egrave; {@code null}
     */
    public SimpleUtente(String nome, String cognome, String password, String cellulare, String email, RuoloUtente ruoloUtente) {
        this();
        this.nome = Objects.requireNonNull(nome, "Nome null!");
        this.cognome = Objects.requireNonNull(cognome, "Cognome null!");
        this.password = Objects.requireNonNull(password, "Password null!");
        this.cellulare = Objects.requireNonNull(cellulare, "Cellulare null!");
        this.email = Objects.requireNonNull(email, "Email null!");
        this.ruoloUtente = Objects.requireNonNull(ruoloUtente, "Ruolo null!");
    }

    protected SimpleUtente() {
        this.id = UUID.randomUUID();
        this.notifiche = new ArrayList<>();
    }

    @Override
    public UUID getId() {
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
    public RuoloUtente getRuoloUtente() {
        return ruoloUtente;
    }

    @Override
    public void setRuoloUtente(RuoloUtente ruoloUtente) {
        this.ruoloUtente = Objects.requireNonNull(ruoloUtente, "Ruolo null!");
    }

    @Override
    public List<Notifica> getNotifiche() {
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
}

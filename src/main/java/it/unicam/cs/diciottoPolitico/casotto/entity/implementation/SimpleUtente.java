package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Notifica;
import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Semplice implementazione dell' interfaccia Utente.
 */
@Entity
@Table(name = "utente")
@EqualsAndHashCode
public class SimpleUtente implements Utente {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    @Getter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String nome;

    @Column
    @Getter
    @Setter
    private String cognome;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String cellulare;

    @Column
    @Getter
    @Setter
    private String email;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private RuoloUtente ruoloUtente;

    @ManyToMany(cascade = {CascadeType.PERSIST} , targetEntity = SimpleNotifica.class, fetch = FetchType.LAZY)
    @JoinTable(name = "utente_notifica",
            joinColumns = {
                    @JoinColumn(name = "utente_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "notifica_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    @Getter
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
     */
    public SimpleUtente(String nome, String cognome, String password, String cellulare, String email, RuoloUtente ruoloUtente) {
        this();
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.cellulare = cellulare;
        this.email = email;
        this.ruoloUtente = ruoloUtente;
    }

    protected SimpleUtente() {
        this.notifiche = new ArrayList<>();
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

}
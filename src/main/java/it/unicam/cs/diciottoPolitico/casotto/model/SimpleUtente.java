package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Utente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Semplice implementazione dell' interfaccia Utente.
 */
@Entity
@Table(name = "utente")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SimpleUtente implements Utente {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    @NotNull
    private String password;

    @Column
    private String cellulare;

    @Column(unique = true)
    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RuoloUtente ruoloUtente;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "utente_notifica",
            joinColumns = {
                    @JoinColumn(name = "utente_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "notifica_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private  List<SimpleNotifica> notifiche;

    public SimpleUtente(){
        this.id = UUID.randomUUID();
        this.notifiche = new ArrayList<>();
    }

}
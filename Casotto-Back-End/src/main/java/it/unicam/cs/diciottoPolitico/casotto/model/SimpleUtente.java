package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Utente;
import lombok.*;

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
@EqualsAndHashCode
@ToString
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

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "utenti", fetch = FetchType.LAZY)
    @NonNull
    private  Set<SimpleNotifica> notifiche;

    public SimpleUtente(){
        this.id = UUID.randomUUID();
        this.notifiche = new HashSet<>();
    }

}
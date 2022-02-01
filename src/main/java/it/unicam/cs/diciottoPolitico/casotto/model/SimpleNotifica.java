package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Notifica;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "notifica")
@Getter
@Setter
@ToString
public class SimpleNotifica implements Notifica {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(updatable = false)
    private String messaggio;


    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "utente_notifica",
            joinColumns = {
                    @JoinColumn(name = "notifica_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "utente_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private Set<SimpleUtente> utenti;

    public SimpleNotifica() {
        this.id = UUID.randomUUID();
        this.utenti = new HashSet<>();
    }
}

package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Notifica;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notifica")
public class SimpleNotifica implements Notifica {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private final UUID id;
    @Column(updatable = false)
    private String messaggio;

    @ManyToMany(mappedBy = "notifiche", targetEntity = SimpleUtente.class, fetch = FetchType.LAZY)
    private List<Utente> utenti;

    public SimpleNotifica(String messaggio) {
        this();
        this.messaggio = messaggio;
    }

    protected SimpleNotifica() {
        this.id = UUID.randomUUID();
        this.utenti = new ArrayList<>();
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getMessaggio() {
        return this.messaggio;
    }
}

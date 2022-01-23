package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Notifica;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notifica")
public class SimpleNotifica implements Notifica {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    @Getter
    private UUID id;

    @Column(updatable = false)
    @Getter
    private String messaggio;

    @ManyToMany(mappedBy = "notifiche", targetEntity = SimpleUtente.class, fetch = FetchType.LAZY)
    @Getter
    private List<Utente> utenti;
}

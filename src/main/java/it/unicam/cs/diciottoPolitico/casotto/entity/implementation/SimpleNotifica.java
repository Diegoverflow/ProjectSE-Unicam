package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.Notifica;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notifica")
@Getter
@Setter
public class SimpleNotifica implements Notifica {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(updatable = false)
    private String messaggio;

    @ManyToMany(mappedBy = "notifiche", fetch = FetchType.LAZY)
    @NonNull
    private List<SimpleUtente> utenti;
}

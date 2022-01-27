package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
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
    @NonNull
    private String password;

    @Column
    private String cellulare;

    @Column
    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
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

    protected SimpleUtente(){
        this.id = UUID.randomUUID();
        this.notifiche = new ArrayList<>();
    }

}
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
@Getter
@Setter
@EqualsAndHashCode
public class SimpleUtente implements Utente {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

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

    @ManyToMany(cascade = {CascadeType.PERSIST} , targetEntity = SimpleNotifica.class, fetch = FetchType.LAZY)
    @JoinTable(name = "utente_notifica",
            joinColumns = {
                    @JoinColumn(name = "utente_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "notifica_id", referencedColumnName = "id",
                            nullable = false, updatable = false)}
    )
    private  List<Notifica> notifiche;

    // TODO: 23/01/22 rimuovere add e remove notifica

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
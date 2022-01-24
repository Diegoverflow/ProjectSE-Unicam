package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Rappresenta un' area dell' infrastruttura chalet che si occupa di fornire informazioni su
 * questa stessa area specifica.
 */
@Entity
@Table(name = "area_infrastruttura")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AreaInfrastruttura {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @Getter
    private UUID id;

    @Column
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String nome;

    @Column
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String descrizione;


}

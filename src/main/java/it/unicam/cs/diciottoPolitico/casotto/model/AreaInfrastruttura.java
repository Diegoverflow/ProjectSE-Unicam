package it.unicam.cs.diciottoPolitico.casotto.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Rappresenta un' area dell' infrastruttura chalet che si occupa di fornire informazioni su
 * questa stessa area specifica.
 */
@Entity
@Table(name = "area_infrastruttura")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AreaInfrastruttura {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(length = 40, unique = true, nullable = false)
    private String nome;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String descrizione;

    public AreaInfrastruttura() {
        this.id = UUID.randomUUID();
    }
}

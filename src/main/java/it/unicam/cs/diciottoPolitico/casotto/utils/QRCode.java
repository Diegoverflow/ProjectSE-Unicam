package it.unicam.cs.diciottoPolitico.casotto.utils;

import java.awt.image.RenderedImage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * QRCode che rappresenta una stringa.
 * Si occupa di conservare al suo interno la stringa che rappresenta e l' array di byte, ovvero i byte che equivalgono alla
 * {@link RenderedImage} del QRCode generato.
 */
@Entity
@Table(name = "qrcode")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class QRCode {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String nome;

    @Lob
    @Column(name = "qrcode_image", columnDefinition = "BLOB")
    private byte[] QRCodeImage;

    protected QRCode() {
        this.id = UUID.randomUUID();
    }

}

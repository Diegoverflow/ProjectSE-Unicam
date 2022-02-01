package it.unicam.cs.diciottoPolitico.casotto.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.PrenotazioneOmbrellone;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prenotazione_ombrellone")
@Getter
@Setter
public class SimplePrenotazioneOmbrellone implements PrenotazioneOmbrellone {

    @Id
    @Column(columnDefinition = "BINARY(16)",updatable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private FasciaOraria fasciaOraria;

    @ManyToOne
    @JoinColumn(name = "ombrellone_id")
    @NonNull
    private SimpleOmbrellone ombrellone;

    @Column
    @NonNull
    private LocalDate dataPrenotazione;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendita_id",unique = true)
    @NotNull
    private SimpleVendita vendita;

    protected SimplePrenotazioneOmbrellone(){
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimplePrenotazioneOmbrellone)) return false;
        SimplePrenotazioneOmbrellone that = (SimplePrenotazioneOmbrellone) o;
        return (FasciaOraria.sameFasciaOraria(this.getFasciaOraria(),that.getFasciaOraria()))
                && getOmbrellone().equals(that.getOmbrellone())
                &&  getDataPrenotazione().equals(that.getDataPrenotazione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFasciaOraria(), getOmbrellone(), getDataPrenotazione());
    }
}

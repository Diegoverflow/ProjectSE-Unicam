package it.unicam.cs.diciottoPolitico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CatalogoOmbrelloni {
    boolean addRigaOmbrellone(Ombrellone ombrellone, double prezzo);

    boolean removeRigaOmbrellone(Ombrellone ombrellone);

    boolean modificaPrezzo(Ombrellone ombrellone, double nuovoPrezzo);

    Optional<Ombrellone> getOmbrelloneBy(long id);

    List<Ombrellone> getOmbrelloniBy(double prezzo);

    List<Ombrellone> getOmbrelloniBy(Date data, FasciaOraria fasciaOraria);

    Optional<RigaCatalogo> getRigaCatalogoBy(Ombrellone ombrellone);
}

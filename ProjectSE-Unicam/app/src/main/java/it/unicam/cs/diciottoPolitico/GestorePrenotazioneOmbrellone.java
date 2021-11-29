package it.unicam.cs.diciottoPolitico;

import java.util.Date;
import java.util.List;
//TODO inserire le API
public interface GestorePrenotazioneOmbrellone {
    List<Ombrellone> getOmbrelloneBy(Date data, FasciaOraria fasciaOraria);
    boolean creaPrenotazione();
    String getRiepilogo(Date data, FasciaOraria fasciaOraria, Ombrellone ombrellone);
}

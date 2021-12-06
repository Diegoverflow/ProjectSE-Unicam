package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;

//TODO inserire le API
public interface HandlerPrenotazioneOmbrellone {
    List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria);
    boolean creaPrenotazione(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);
    String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone);
    double getCostoOmbrellone(Ombrellone ombrellone);
}

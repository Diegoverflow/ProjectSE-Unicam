package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;


public class SimpleHandlerPrenotazioneOmbrellone implements HandlerPrenotazioneOmbrellone{

    @Override
    public List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria) {
        return null;
    }

    @Override
    public boolean creaPrenotazione(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone) {
        return false;
    }

    @Override
    public String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone) {
        return null;
    }

    @Override
    public double getCostoOmbrellone(Ombrellone ombrellone) {
        return 0;
    }
}

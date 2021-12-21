package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: inserire javadoc

public class SimpleHandlerPrenotazioneOmbrellone implements HandlerPrenotazioneOmbrellone {

    private final Catalogo<Ombrellone, RigaCatalogoOmbrellone> catalogoOmbrelloni;

    /**
     * Metodo Costruttore.
     */
    public SimpleHandlerPrenotazioneOmbrellone() {
        this.catalogoOmbrelloni = new SimpleCatalogo<>();
    }

    @Override
    public List<RigaCatalogoOmbrellone> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria) {
        return this.catalogoOmbrelloni.getAllRighe().stream()
                .filter(riga -> riga.getDisponibilita(data, fasciaOraria))
                .collect(Collectors.toList());
    }

    //todo synchronized qui o sul controller?
    @Override
    public boolean creaPrenotazione(GregorianCalendar data, FasciaOraria fasciaOraria, RigaCatalogoOmbrellone rigaCatalogoOmbrellone, Cliente cliente) {
        if (rigaCatalogoOmbrellone.getDisponibilita(data, fasciaOraria)) {
            PrenotazioneOmbrellone prenotazioneOmbrellone = new SimplePrenotazioneOmbrellone(fasciaOraria, rigaCatalogoOmbrellone.getValore(), data, rigaCatalogoOmbrellone.getPrezzoOmbrellone());
            rigaCatalogoOmbrellone.addPrenotazione(prenotazioneOmbrellone);
            cliente.addPrenotazioneOmbrellone(prenotazioneOmbrellone);
            return true;
        }
        return false;
    }

    @Override
    public String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone) {
        return data.getTime() + "\n" + fasciaOraria.toString() + "\n" + ombrellone.getId();
    }
}

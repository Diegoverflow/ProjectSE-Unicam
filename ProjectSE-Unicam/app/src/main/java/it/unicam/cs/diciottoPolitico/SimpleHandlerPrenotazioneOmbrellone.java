package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;


public class SimpleHandlerPrenotazioneOmbrellone implements HndlerPrenotazioneOmbrellone{
    private final CatalogoOmbrelloni catalogoOmbrelloni;

    public SimpleGestorePrenotazioneOmbrellone(CatalogoOmbrelloni catalogoOmbrelloni) {
        this.catalogoOmbrelloni = catalogoOmbrelloni;
    }

    @Override
    public List<RigaCatalogo> getRigheCatalogoBy(GregorianCalendar data, FasciaOraria fasciaOraria) {
        List<RigaCatalogo> righeCatalogo = new ArrayList<>();
        Optional<List<Ombrellone>> ombrelloni =  this.catalogoOmbrelloni.getOmbrelloniBy(data, fasciaOraria);
        ombrelloni.ifPresent(listO-> listO.forEach(o->this.catalogoOmbrelloni.getRigaCatalogoBy(o).ifPresent(righeCatalogo::add)));
        return righeCatalogo;
    }

    @Override
    public boolean creaPrenotazione(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone) {
        RigaCatalogo rigaCatalogo = catalogoOmbrelloni.getRigaCatalogoBy(ombrellone).orElseThrow(()-> new IllegalArgumentException("L'ombrellone non è presente nel catalogo"));
        Prenotazione prenotazione = new SimplePrenotazione(fasciaOraria,ombrellone,data,rigaCatalogo.getPrezzoOmbrellone());
        if(rigaCatalogo.getPrenotazioni().contains(prenotazione))
            return false; // prenotazione duplicata
        rigaCatalogo.addPrenotazione(prenotazione);
        return true;
    }

    @Override
    public String getRiepilogo(GregorianCalendar data, FasciaOraria fasciaOraria, Ombrellone ombrellone) {
        return data.toString()+"\n"+fasciaOraria.toString()+"\n"+ombrellone.getId();
    }

    @Override
    public double getCostoOmbrellone(Ombrellone ombrellone) {
        RigaCatalogo rigaCatalogo = this.catalogoOmbrelloni.getRigaCatalogoBy(ombrellone).orElseThrow(()->new IllegalArgumentException("L'ombrellone non è presente nel catalogo"));
        return rigaCatalogo.getPrezzoOmbrellone();
    }
}

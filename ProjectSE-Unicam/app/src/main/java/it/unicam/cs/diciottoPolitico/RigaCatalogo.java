package it.unicam.cs.diciottoPolitico;

import java.util.Date;
import java.util.List;
//TODO inserire le API
public interface RigaCatalogo {
    double getPrezzoOmbrellone();
    Ombrellone getOmbrellone();
    List<Prenotazione> getPrenotazioni();
    boolean getDisponibilita(Date date, FasciaOraria fasciaOraria);
    void setPrezzoOmbrellone(double prezzoOmbrellone);
    boolean addPrenotazione(Prenotazione prenotazione);
}

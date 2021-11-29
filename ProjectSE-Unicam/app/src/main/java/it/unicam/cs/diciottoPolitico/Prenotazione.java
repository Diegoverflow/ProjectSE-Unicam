package it.unicam.cs.diciottoPolitico;

import java.util.Date;
//TODO inserire le API
public interface Prenotazione {
    long getCodice();
    Date getDataPrenotazione();
    Date getDataAcquisto();
    boolean getStatoPagamento();//io lo chiamerei isPagato()
    double getCosto();
    FasciaOraria getFasciaOraria();
}

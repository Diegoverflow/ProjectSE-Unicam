package it.unicam.cs.diciottoPolitico;

import java.util.List;

public interface HandlerVendita {

    List<Vendita> getVendite();

    List<Vendita> getPrenotazioniOmbrellone();

    List<Vendita> getOrdinazioniBar();

    List<Vendita> getPrenotazioniAttiivita();

    boolean saldaVendita(Vendita vendita);

}

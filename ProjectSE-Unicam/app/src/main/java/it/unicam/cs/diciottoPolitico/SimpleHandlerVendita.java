package it.unicam.cs.diciottoPolitico;

import java.util.List;

// TODO: 16/01/22 completare 
public class SimpleHandlerVendita implements HandlerVendita{

    @Override
    public List<Vendita> getVenditeDaSaldare() {
        return null;
    }

    @Override
    public List<Vendita> getPrenotazioniOmbrelloneDaSaldare() {
        return null;
    }

    @Override
    public List<Vendita> getOrdinazioniBarDaSaldare() {
        return null;
    }

    @Override
    public List<Vendita> getPrenotazioniAttivitaDaSaldare() {
        return null;
    }

    @Override
    public boolean saldaVendita(Vendita vendita) {
        return false;
    }
}

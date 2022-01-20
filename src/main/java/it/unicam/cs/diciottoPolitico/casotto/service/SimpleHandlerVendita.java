package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Vendita;

import java.util.List;
import java.util.Set;

// TODO: 16/01/22 completare 
public class SimpleHandlerVendita implements HandlerVendita{

    private Set<Vendita> prenotazioniOmbrellone;
    private Set<Vendita> ordinazioniBar;
    private Set<Vendita> prenotaziniAttivita;

    public SimpleHandlerVendita (Set<Vendita> prenotazioniOmbrellone, Set<Vendita> ordinazioniBar, Set<Vendita> prenotaziniAttivita){
        this.prenotazioniOmbrellone = prenotazioniOmbrellone;
        this.ordinazioniBar = ordinazioniBar;
        this.prenotaziniAttivita = prenotaziniAttivita;
    }

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

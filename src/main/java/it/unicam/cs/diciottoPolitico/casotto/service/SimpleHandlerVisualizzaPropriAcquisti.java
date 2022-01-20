package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

/**
 * Semplice implementazione dell'interfaccia {@link HandlerVisualizzaPropriAcquisti}.
 */
public class SimpleHandlerVisualizzaPropriAcquisti implements HandlerVisualizzaPropriAcquisti {
//todo rifare metodo
    @Override
    public String getAcquisti(Utente cliente) {
       /* StringBuilder messaggio = new StringBuilder();
        cliente.getPrenotazioniOmbrelloni().stream().sequential().forEach(o -> getAcquisti(o,messaggio));
        cliente.getPrenotazioniAttivita().stream().sequential().forEach(a -> getAcquisti(a,messaggio));
        cliente.getOrdinazioniBar().stream().sequential().forEach(a -> getAcquisti(a,messaggio));
        return messaggio.toString();
    }

    private void getAcquisti(Object o,StringBuilder messaggio){
        messaggio.append(o.toString());
        messaggio.append("\n");
    */return  null;
    }
}

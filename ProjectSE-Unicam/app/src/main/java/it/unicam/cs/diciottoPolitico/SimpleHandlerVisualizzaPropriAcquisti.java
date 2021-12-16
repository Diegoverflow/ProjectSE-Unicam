package it.unicam.cs.diciottoPolitico;

/**
 * Semplice implementazione dell'interfaccia {@link HandlerVisualizzaPropriAcquisti}.
 * @see Cliente
 */
public class SimpleHandlerVisualizzaPropriAcquisti implements HandlerVisualizzaPropriAcquisti {

    @Override
    public String getAcquisti(Cliente cliente) {
        StringBuilder messaggio = new StringBuilder();
        cliente.getPrenotazioniOmbrelloni().stream().sequential().forEach(o -> getAcquisti(o,messaggio));
        cliente.getPrenotazioniAttivita().stream().sequential().forEach(a -> getAcquisti(a,messaggio));
        cliente.getOrdinazioniBar().stream().sequential().forEach(a -> getAcquisti(a,messaggio));
        return messaggio.toString();
    }

    private void getAcquisti(Object o,StringBuilder messaggio){
        messaggio.append(o.toString());
        messaggio.append("\n");
    }
}

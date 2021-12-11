package it.unicam.cs.diciottoPolitico;

/**
 * Implementazione di un semplice gestore di notifiche.
 */
public class SimpleHandlerNotifica implements HandlerNotifica {
    @Override
    public boolean notifica(Notifica notifica, AddettoBar addettoBar) {
        return addettoBar.addNotifica(notifica);
    }

    @Override
    public boolean notifica(Notifica notifica, Cliente cliente) {
        return cliente.addNotifica(notifica);
    }
}

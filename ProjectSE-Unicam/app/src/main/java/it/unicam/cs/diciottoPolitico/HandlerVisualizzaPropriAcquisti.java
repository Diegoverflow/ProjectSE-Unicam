package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore utile a visualizzare, sotto forma di stringa, tutti gli acquisti effettuati da un cliente.
 */
public interface HandlerVisualizzaPropriAcquisti {

    /**
     * Ritorna una stringa contenente tutti gli acquisti effettuati da un cliente.
     *
     * @param cliente il cliente di cui si vogliono visulizzare gli acquisti
     * @return una stringa contenente tutti gli acquisti del cliente
     */
    String getAcquisti(Cliente cliente);
}

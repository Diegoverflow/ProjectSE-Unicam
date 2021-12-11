package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore che manda notifiche a diverse tipologie di utenti.
 * Le notifiche contengono messaggi.
 */
public interface HandlerNotifica {

    /**
     * Invia la notifica con il messaggio specificato all' addetto bar specificato.
     *
     * @param messaggio  il messaggio da inserire nella notifica
     * @param addettoBar l' addetto bar destinatario a cui inviare la notifica
     */
    boolean notifica(Notifica notifica, AddettoBar addettoBar);

    /**
     * Invia la notifica con il messaggio specificato al cliente.
     *
     * @param messaggio il messaggio da inserire nella notifica
     * @param cliente   il cliente destinatario a cui inviare la notifica
     */
    boolean notifica(Notifica notifica, Cliente cliente);

}

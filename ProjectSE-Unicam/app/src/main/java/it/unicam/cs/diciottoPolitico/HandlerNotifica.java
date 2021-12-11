package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore che manda notifiche a diverse tipologie di utenti.
 * Le notifiche contengono messaggi.
 */
public interface HandlerNotifica {

    /**
     * Invia la notifica con il messaggio specificato all' utente loggato.
     *
     * @param notifica      la notifica da inviare all' utente loggato
     * @param utenteLoggato l' utente destinatario che riceve la notifica
     */
    static void notifica(Notifica notifica, UtenteLoggato utenteLoggato) {
        utenteLoggato.addNotifica(notifica);
    }

}

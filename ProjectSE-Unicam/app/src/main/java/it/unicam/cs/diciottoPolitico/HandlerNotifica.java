package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore che invia notifiche a diverse tipologie di utenti.
 * Una {@link Notifica} contiene uno specifico messaggio da inviare ad uno specifico {@link UtenteLoggato} destinatario.
 */
public interface HandlerNotifica {

    /**
     * Invia la notifica con il messaggio specificato all' utente loggato.
     *
     * @param notifica      la notifica da inviare all' utente loggato
     * @param utenteLoggato l' utente destinatario che riceve la notifica
     * @see Notifica
     * @see UtenteLoggato
     */
    void notifica(Notifica notifica, UtenteLoggato utenteLoggato);

}

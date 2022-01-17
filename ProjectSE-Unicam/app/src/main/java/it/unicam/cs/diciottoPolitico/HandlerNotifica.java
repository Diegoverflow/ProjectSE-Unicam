package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta un gestore che invia notifiche a diverse tipologie di utenti.
 * Una {@link Notifica} contiene uno specifico messaggio da inviare ad uno specifico {@link Utente} destinatario.
 */
public interface HandlerNotifica {

    /**
     * Invia la notifica con il messaggio specificato all' utente.
     *
     * @param notifica      la notifica da inviare all' utente loggato
     * @param utente l' utente destinatario che riceve la notifica
     * @see Notifica
     * @see Utente
     */
    static void notifica(Notifica notifica, Utente utente) {
        utente.addNotifica(notifica);
    }

}

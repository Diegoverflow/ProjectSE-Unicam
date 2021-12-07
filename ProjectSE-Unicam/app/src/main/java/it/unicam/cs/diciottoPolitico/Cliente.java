package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 *Interfaccia che descrive un cliente.
 */
public interface Cliente {
    /**
     * Ottieni il codice fiscale del cliente.
     * @return il codice fiscale del cliente
     */
    String getCodiceFiscale();

    /**
     * Ottieni il nome del cliente.
     * @return il nome del cliente
     */
    String getNome();

    /**
     * Ottieni il cognome del cliente.
     * @return il cognome del cliente
     */
    String getCognome();

    /**
     * Ottieni il numero del cliente.
     * @return il numero del cliente
     */
    String getNumero();

    /**
     * Modifica il nome del cliente in base al nome passato come parametro.
     * @param nome con il quale si vuole aggiornare il nome del cliente
     */
    void setNome(String nome);

    /**
     * Modifica il cognome del cliente in base al cognome passato come parametro.
     * @param cognome con il quale si vuole aggiornare il cognome del cliente
     */
    void setCognome(String cognome);

    /**
     * Modifica il numero del cliente in base al numero passato come parametro.
     * @param numero con il quale si vuole aggiornare il numero del cliente
     */
    void setNumero(String numero);

    /**
     * Ottieni le notifiche nella casella notifiche del cliente.
     * @return la lista di notifiche del cliente
     */
    List<Notifica> getNotifiche();

    /**
     * Aggiunge una notifica alla casella notifiche del cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     * @param notifica da aggiungere alla casella notifiche del cliente
     * @return true se la notifica &egrave; stata aggiunta,
     *         false altrimenti
     */
    boolean addNotica(Notifica notifica);

    /**
     * Rimuovi una notifica dalla casella notifiche del cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     * @param idNotifica da rimuovere dalla casella notifiche del cliente
     * @return true se la notifica &egrave; stata rimossa,
     *         false altrimenti
     */
    boolean removeNotifica(long idNotifica);

    /**
     * Ottieni le prenotazioni di ombrelloni del cliente.
     * @return la lista di prenotazioni effettuate dal cliente
     */
    List<PrenotazioneOmbrellone> getPrenotazioniOmbrelloni();

    /**
     * Aggiunge una prenotazione alle prenotazioni associate al cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     * @param prenotazione che si vuole aggiungere alla lista prenotazioni
     * @return true se la prenotazione &egrave; stata aggiunta,
     *         false altrimenti
     */
    boolean addPrenotazioneOmbrellone(PrenotazioneOmbrellone prenotazione);

    /**
     * Ottieni le attvit&agrave; prenotate dal cliente.
     * @return la lista di attvit&agrave; prenotate dal cliente
     */
    List<PrenotazioneAttivita> getPrenotazioniAttivita();

    /**
     * Aggiunge un'attvit&agrave; alle attvit&agrave; prenotate dal cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     * @param attivita che si vuole aggiungere alla lista prenotazioni attvit&agrave;
     * @return true se l'attvit&agrave; &egrave; stata aggiunta,
     *         false altrimenti
     */
    boolean addPrenotazioneAttivita(PrenotazioneAttivita attivita);

    /**
     * Ottieni le ordinazioni bar effettuate dal cliente.
     * @return la lista drlle ordinazioni bar effettuate dal cliente
     */
    List<OrdinazioneBar> getOrdinazioniBar();

    /**
     * Aggiunge un'ordinazione bar alle ordinazioni effettuate dal cliente e
     * verifica che l'operazione sia stata svolta correttamente.
     * @param ordinazioneBar che si vuole registrare
     * @return true se ordinazione &egrave; stata registrata
     *         false altrimenti
     */
    boolean addOrdinazioneBar(OrdinazioneBar ordinazioneBar);
}

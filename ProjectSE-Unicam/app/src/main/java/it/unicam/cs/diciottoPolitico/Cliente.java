package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Interfaccia che descrive un cliente.
 */
public interface Cliente extends UtenteLoggato {
    /**
     * Ottieni il codice fiscale del cliente.
     *
     * @return il codice fiscale del cliente
     */
    String getEmail();

    /**
     * Imposta il codice fiscale.
     *
     * @param codiceFiscale il nuovo codice fiscale del cliente
     * @throws NullPointerException se il codice fiscale &egrave; {@code null}
     */
    void setCodiceFiscale(String codiceFiscale);

    /**
     * Ottieni le prenotazioni di ombrelloni del cliente.
     *
     * @return la lista di prenotazioni effettuate dal cliente
     */
    List<PrenotazioneOmbrellone> getPrenotazioniOmbrelloni();

    /**
     * Aggiunge una prenotazione alle prenotazioni associate al cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     *
     * @param prenotazione che si vuole aggiungere alla lista prenotazioni
     * @return {@code true} se la prenotazione &egrave; stata aggiunta,
     * {@code false} altrimenti
     */
    boolean addPrenotazioneOmbrellone(PrenotazioneOmbrellone prenotazione);

    /**
     * Ottieni le attvit&agrave; prenotate dal cliente.
     *
     * @return la lista di attvit&agrave; prenotate dal cliente
     */
    List<PrenotazioneAttivita> getPrenotazioniAttivita();

    /**
     * Aggiunge un'attvit&agrave; alle attvit&agrave; prenotate dal cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     *
     * @param attivita che si vuole aggiungere alla lista prenotazioni attvit&agrave;
     * @return {@code true} se l'attvit&agrave; &egrave; stata aggiunta,
     * {@code false} altrimenti
     */
    boolean addPrenotazioneAttivita(PrenotazioneAttivita attivita);


    /**
     * Ottieni le ordinazioni bar effettuate dal cliente.
     *
     * @return la lista drlle ordinazioni bar effettuate dal cliente
     */
    List<OrdinazioneBar> getOrdinazioniBar();

    /**
     * Aggiunge un'ordinazione bar alle ordinazioni effettuate dal cliente e
     * verifica che l'operazione sia stata svolta correttamente.
     *
     * @param ordinazioneBar che si vuole registrare
     * @return {@code true} se ordinazione &egrave; stata registrata
     * {@code false} altrimenti
     */
    boolean addOrdinazioneBar(OrdinazioneBar ordinazioneBar);
}

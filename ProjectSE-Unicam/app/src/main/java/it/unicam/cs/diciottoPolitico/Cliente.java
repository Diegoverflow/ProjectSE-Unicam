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
     * Aggiunge una prenotazione alle prenotazioni associate al cliente e
     * verifica che l'operazione sia stata effettuata correttamente.
     * @param prenotazione che si vuole aggiungere
     * @return true se la prenotazione &egrave; stata aggiunta,
     *         false altrimenti
     */
    boolean addPrenotazione(PrenotazioneOmbrellone prenotazione);

    /**
     * Ottieni le prenotazioni di ombrelloni del cliente
     * @return la lista di prenotazioni effettuate dal cliente
     */
    List<PrenotazioneOmbrellone> getPrenotazioni();
}

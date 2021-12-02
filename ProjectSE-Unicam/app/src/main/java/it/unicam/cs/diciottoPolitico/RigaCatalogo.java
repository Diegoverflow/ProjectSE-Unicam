package it.unicam.cs.diciottoPolitico;

import java.util.Date;
import java.util.List;

/**
 * Rappresenta una riga di un catalogo ombrelloni.
 * La riga &egrave; una tripla formata da Ombrellone, prezzo e la lista delle prenotazioni dell' ombrellone.
 */
public interface RigaCatalogo {

    /**
     * Restituisce il prezzo associato all' ombrellone presente in questa riga.
     *
     * @return il prezzo associato all' ombrellone
     */
    double getPrezzoOmbrellone();

    /**
     * Restituisce l' ombrellone presente in questa riga.
     *
     * @return l' ombrellone di questa riga
     */
    Ombrellone getOmbrellone();

    /**
     * Restituisce la lista delle prenotazioni associate all' ombrellone di questa riga.
     *
     * @return la lista delle prenotazioni di questa riga
     */
    List<Prenotazione> getPrenotazioni();

    /**
     * Determina se l' ombrellone di questa riga &egrave; disponibile in base alla data e la fascia oraria specificate.
     * Restituisce true se c'&egrave; disponibilit&agrave;, false altrimenti.
     *
     * @param date         la data in cui verificare se l' ombrellone &egrave; disoonibile oppure no.
     * @param fasciaOraria la fascia oraria in cui verificare se l' ombrellone &egrave; disoonibile oppure no.
     * @return true se l' ombrellone &egrave; disponibile per la data e la fascia oraria specificate, false altrimenti.
     * @throws NullPointerException se almeno uno dei parametri specificati &egrave; null
     */
    boolean getDisponibilita(Date date, FasciaOraria fasciaOraria);

    /**
     * Imposta un nuovo prezzo all' ombrellone di questa riga.
     *
     * @param nuovoPrezzo il nuovo prezzo da impostare all' ombrellone di questa riga.
     * @throws IllegalArgumentException se il prezzo specificato non &egrave; valido
     */
    void setPrezzoOmbrellone(double nuovoPrezzo);

    /**
     * Aggiunge la prenotazione specificata a questa riga catalogo.
     * La prenotazione viene aggiunta in coda a tutte le prenotazioni associate all' ombrellone di questa riga.
     *
     * @param prenotazione la prenotazione da aggiungere
     * @return true se la prenotazione viene aggiunta con successo, false altrimenti.
     * @throws NullPointerException se la prenotazione specificata &egrave; null
     */
    boolean addPrenotazione(Prenotazione prenotazione);
}

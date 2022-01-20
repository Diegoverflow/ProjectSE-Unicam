package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Attivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.PrenotazioneAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.RigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Rappresenta un gestore delle prenotazioni relative alle attivit&agrve; offerte dallo chalet.
 *
 * @see PrenotazioneAttivita
 * @see Attivita
 * @see RigaCatalogoAttivita
 */
public interface HandlerPrenotazioneAttivita {

    /**
     * Restituisce la lista di tutte le attivit&agrave; attualmente disponibili nello chalet.
     *
     * @return la lista di tutte le attivit&agrave; che lo chalet attualmente offre
     * @see RigaCatalogoAttivita
     */
    List<RigaCatalogoAttivita> getRigheAttivitaDisponibili();

    /**
     * Restituisce la lista di tutte le attivit&agrave; attualmente disponibili nello chalet
     * filtrate tramite l' istante temporale specificato.
     *
     * @param data l' istante temporale per filtrare le attivit&agrve;
     * @return la lista di tutte le attivit&agrave; attualmente disponibili offerte dallo chalet nell' istante temporale specificato
     * @throws NullPointerException se la data specificata &egrave; {@code null}
     * @see RigaCatalogoAttivita
     */
    List<RigaCatalogoAttivita> getRigheAttivitaDisponibiliBy(GregorianCalendar data);

    /**
     * Crea una {@link PrenotazioneAttivita} dell' attivit&agrave; specificata per il {@link Cliente} specificato.
     * Restituisce {@code true} se la prenotazione viene creata con successo, altrimenti {@code false}.
     *
     * @param attivita l' attivit&agrave; da creare
     * @param utente  l'utente che sta effettuando una prenotazione per l' attivit&agrave; specificata
     * @return {@code true} se la prenotazione viene creata con successo, altrimenti {@code false}
     * @throws NullPointerException     se almeno uno dei parametri specificati &egrave; {@code null}
     * @throws IllegalArgumentException se l' attivit&agrave; non esiste, ovvero non fa parte del catalogo attivit&agrave;
     * @see Attivita
     * @see Utente
     */
    boolean creaPrenotazioneAttivita(Attivita attivita, Utente utente);

    /**
     * Ritorna tutte le prenotazioni attivit&agrave; fatte.
     *
     * @return tutte le prenotazioni ombrellone attivit&agrave; fatte
     */
    List<PrenotazioneAttivita> getPrenotazioniAttivita();

    /**
     * Rimuove una prenotazione attivit&agrave;.
     *
     * @param prenotazioneAttivita la prenotazione attivit&agrave; da rimuovere
     * @return true se la prenotazione attivit&agrave; &egrave; stata rimossa, false se la prenotazione attivit&agrave; non era presente
     * @throws NullPointerException se la prenotazione attivit&agrave; &egrave; nulla
     */
    boolean removePrenotazioneAttivita(PrenotazioneAttivita prenotazioneAttivita);
}

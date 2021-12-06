package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Rappresenta un gestore delle prenotazioni relative alle attivit&agrve; offerte dallo chalet.
 */
public interface HandlerPrenotazioneAttivita {

    /**
     * Restituisce la lista di tutte le attivit&agrave; attualmente disponibili nello chalet.
     *
     * @return la lista di tutte le attivit&agrave; che lo chalet attualmente offre
     */
    List<Object> getRigheAttivitaDisponibili(); // TODO: Refactor di Object con RigaAttivita

    /**
     * Restituisce la lista di tutte le attivit&agrave; attualmente disponibili nello chalet
     * filtrate tramite l' istante temporale specificato.
     *
     * @param data l' istante temporale per filtrare le attivit&agrve;
     * @return la lista di tutte le attivit&agrave; attualmente disponibili offerte dallo chalet nell' istante temporale specificato
     */
    List<Object> getRigheAttivitaDisponibiliBy(GregorianCalendar data); // TODO: Refactor di Object con RigaCatalogoAttivita

    /**
     * Crea una prenotazione dell' attivit&agrave; specificata per il cliente specificato.
     * Restituisce true se la prenotazione viene creata con successo, altrimenti false.
     *
     * @param attivita l' attivit&agrave; da creare
     * @param cliente  il cliente che sta effettuando una prenotazione per l' attivit&agrave; specificata
     * @return true se la prenotazione viene creata con successo, altrimenti false
     */
    boolean creaPrenotazioneAttivita(Object attivita, Cliente cliente); // TODO: Refactor di Object con Attivita

}
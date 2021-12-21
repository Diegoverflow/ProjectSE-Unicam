package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Rappresenta un gestore delle prenotazioni relative alle attivit&agrve; offerte dallo chalet.
 *
 * @see PrenotazioneAttivita
 * @see Attivita
 * @see Cliente
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
     * @param cliente  il cliente che sta effettuando una prenotazione per l' attivit&agrave; specificata
     * @return {@code true} se la prenotazione viene creata con successo, altrimenti {@code false}
     * @throws NullPointerException     se almeno uno dei parametri specificati &egrave; {@code null}
     * @throws IllegalArgumentException se l' attivit&agrave; non esiste, ovvero non fa parte del catalogo attivit&agrave;
     * @see Attivita
     * @see Cliente
     */
    boolean creaPrenotazioneAttivita(Attivita attivita, Cliente cliente);

}

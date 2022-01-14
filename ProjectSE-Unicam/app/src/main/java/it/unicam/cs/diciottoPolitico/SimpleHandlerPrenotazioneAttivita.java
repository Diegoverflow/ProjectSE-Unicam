package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementazione di un semplice gestore per le prenotazioni effettuate dai clienti relative alle
 * attivit&agrave; offerte dallo chalet.
 *
 * @see PrenotazioneAttivita
 * @see Attivita
 * @see Cliente
 * @see Catalogo
 * @see RigaCatalogoAttivita
 */
public class SimpleHandlerPrenotazioneAttivita implements HandlerPrenotazioneAttivita {

    private final Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita;
    private final List<PrenotazioneAttivita> prenotazioniAttivita;

    public SimpleHandlerPrenotazioneAttivita() {
        this.catalogoAttivita = new SimpleCatalogo<>();
        this.prenotazioniAttivita = new ArrayList<>();
    }

    @Override
    public List<RigaCatalogoAttivita> getRigheAttivitaDisponibili() {
        return this.catalogoAttivita.getRigheBy(r -> r.getValore().getPostiTotali() != r.getValore().getPostiOccupati());
    }

    @Override
    public List<RigaCatalogoAttivita> getRigheAttivitaDisponibiliBy(GregorianCalendar data) {
        return this.getRigheAttivitaDisponibili().stream().filter(r -> r.getValore().getDataOrarioInizio().equals(
                Objects.requireNonNull(data, "Data null!"))).collect(Collectors.toList());
    }

    @Override
    public synchronized boolean creaPrenotazioneAttivita(Attivita attivita, Utente utente) {
        Objects.requireNonNull(utente, "Utente null!");
        if (this.catalogoAttivita.getRigheBy(r -> r.getValore().equals(
                Objects.requireNonNull(attivita, "Attivita' null!"))).isEmpty())
            throw new IllegalArgumentException("Attivita' non esistente!");
        if (attivita.addPosti(1))
            return this.prenotazioniAttivita.add(
                    new SimplePrenotazioneAttivita(attivita.getId(),
                            this.catalogoAttivita.getRigheBy(r -> r.getValore().equals(attivita)).get(0).getPrezzo(),
                            attivita,
                            utente));
        return false;
    }

    @Override
    public List<PrenotazioneAttivita> getPrenotazioniAttivita() {
        return this.prenotazioniAttivita;
    }

    @Override
    public boolean removePrenotazioneAttivita(PrenotazioneAttivita prenotazioneAttivita) {
        Objects.requireNonNull(prenotazioneAttivita,"La prenotazione attivita' non puo' essere nulla");
        return this.prenotazioniAttivita.removeIf(prenotazione -> prenotazione.equals(prenotazioneAttivita));
    }

}

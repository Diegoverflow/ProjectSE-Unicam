package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

/**
 * Implementazione di un semplice gestore per le prenotazioni effettuate dai clienti relative alle
 * attivit&agrave; offerte dallo chalet.
 */
public class SimpleHandlerPrenotazioneAttivita implements HandlerPrenotazioneAttivita {

    private final Catalogo<Attivita, RigaCatalogoAttivita> catalogoAttivita;

    public SimpleHandlerPrenotazioneAttivita() {
        this.catalogoAttivita = new SimpleCatalogoAttivita();
    }

    @Override
    public List<RigaCatalogoAttivita> getRigheAttivitaDisponibili() {
        return this.catalogoAttivita.getRigaBy(a -> true);
    }

    @Override
    public List<RigaCatalogoAttivita> getRigheAttivitaDisponibiliBy(GregorianCalendar data) {
        return this.catalogoAttivita.getRigaBy(a -> a.getValore().getDataOrarioInizio().equals(data));
    }

    @Override
    public boolean creaPrenotazioneAttivita(Attivita attivita, Cliente cliente) {
        Objects.requireNonNull(attivita, "Attivita' null!");
        Objects.requireNonNull(cliente, "Cliente null!");
        if (this.catalogoAttivita.getRigaBy(r -> r.getValore().equals(attivita)).isEmpty())
            throw new IllegalArgumentException("Attivita' non esistente!");
        return cliente.addPrenotazioneAttivita(
                new SimplePrenotazioneAttivita(attivita.getId(),
                        this.catalogoAttivita.getRigaBy(r -> r.getValore().equals(attivita)).get(0).getPrezzo(),
                        attivita
                ));
    }
}

package it.unicam.cs.diciottoPolitico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Rappresenta un gestore dell' infrastruttura dello chalet.
 * Esso si occupa di effettuare operazioni di aggiunta, modifica e rimozione delle area dell' infrastruttura.
 */
public class HandlerInfrastruttura {

    private static HandlerInfrastruttura instance = null;
    private final List<AreaInfrastruttura> infrastruttura;

    /**
     * Crea un gestore dell' infrastruttura.
     */
    private HandlerInfrastruttura() {
        this.infrastruttura = new ArrayList<>();
    }

    /**
     * Restituisce l' istanza di questa classe Singleton.
     *
     * @return l' istanza di questa classe Singleton
     */
    public static HandlerInfrastruttura getInstance() {
        if (instance == null)
            instance = new HandlerInfrastruttura();
        return instance;
    }

    /**
     * Imposta il nome specificato all' {@link AreaInfrastruttura} specificata.
     *
     * @param nome il nome che avr&agrave; l' area
     * @param area l' area a cui assegnare il nome
     * @throws NullPointerException     se almeno uno dei parametri &egrave; {@code null}
     * @throws IllegalArgumentException se l' area non &egrave; presente nell' infrastruttura
     */
    public void setNomeArea(String nome, AreaInfrastruttura area) {
        Optional<AreaInfrastruttura> ai = this.infrastruttura.stream()
                .filter(a -> a.equals(area))
                .findFirst();
        if (ai.isEmpty())
            throw new IllegalArgumentException("Area infrastruttura inesistente!");
        ai.get().setNome(nome);
    }

    /**
     * Imposta la descrizione specificata all' {@link AreaInfrastruttura} specificata.
     *
     * @param descrizione la descrizione che avr&agrave; l' area
     * @param area        l' area a cui assegnare il nome
     * @throws NullPointerException     se almeno uno dei parametri &egrave; {@code null}
     * @throws IllegalArgumentException se l' area non &egrave; presente nell' infrastruttura
     */
    public void setDescrizioneArea(String descrizione, AreaInfrastruttura area) {
        Optional<AreaInfrastruttura> ai = this.infrastruttura.stream()
                .filter(a -> a.equals(area))
                .findFirst();
        if (ai.isEmpty())
            throw new IllegalArgumentException("Area infrastruttura inesistente!");
        ai.get().setDescrizione(descrizione);
    }

    /**
     * Restituisce la lista di tutte le aree dell' infrastruttura.
     *
     * @return la lista di tutte le aree presenti nell' infrastruttura
     */
    public List<AreaInfrastruttura> getAree() {
        return this.infrastruttura;
    }

    /**
     * Aggiunge l' {@link AreaInfrastruttura} specificata a questa infrastruttura.
     * Restituisce {@code true} se l' area viene aggiunta con successo all' infrastruttura,
     * {@code false} altrimenti.
     *
     * @param area l' area da aggiungere a questa infrastruttura
     * @return {@code true} se l' area viene aggiunta con successo a questa infrastruttura,
     * {@code false} altrimenti
     * @throws NullPointerException se l' area specificata &egrave; null
     */
    public boolean addArea(AreaInfrastruttura area) {
        Objects.requireNonNull(area, "Area null!");
        if (this.infrastruttura.stream()
                .noneMatch(a -> a.equals(area)))
            return this.infrastruttura.add(area);
        return false;
    }

    /**
     * Rimuove l' {@link AreaInfrastruttura} specificata da questa infrastruttura.
     * Restituisce {@code true} se l' area viene rimossa con successo dall' infrastruttura,
     * {@code false} altrimenti.
     *
     * @param area l' area da rimuovere da questa infrastruttura
     * @return {@code true} se l' area viene rimossa con successo da questa infrastruttura,
     * {@code false} altrimenti
     * @throws NullPointerException se l' area specificata &egrave; null
     */
    public boolean deleteArea(AreaInfrastruttura area) {
        Objects.requireNonNull(area, "Area null!");
        if (this.infrastruttura.stream()
                .noneMatch(a -> a.equals(area)))
            return false;
        return this.infrastruttura.remove(area);
    }

}

package it.unicam.cs.diciottoPolitico;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementazione di una semplice classe per il catalogo ombrelloni.
 */
public class SimpleCatalogoOmbrelloni implements CatalogoOmbrelloni {

    private final Set<RigaCatalogo> righe;

    /**
     * Crea un semplice catalogo ombrelloni
     */
    public SimpleCatalogoOmbrelloni() {
        this.righe = new HashSet<>();
    }

    @Override
    public boolean addRigaOmbrellone(Ombrellone ombrellone, double prezzo) {
        RigaCatalogo rigaCatalogo = new SimpleRigaCatalogo(ombrellone, prezzo);
        return this.righe.add(rigaCatalogo);
    }

    @Override
    public boolean removeRigaOmbrellone(Ombrellone ombrellone) {
        this.ombrelloneNullException(ombrellone);
        return this.righe.removeIf(rigaCatalogo ->
                rigaCatalogo.getOmbrellone().getId() == ombrellone.getId());
    }

    @Override
    public boolean modificaPrezzo(Ombrellone ombrellone, double nuovoPrezzo) {
        this.ombrelloneNullException(ombrellone);
        if (this.getRigaCatalogoBy(ombrellone).isPresent())
            return false;
        RigaCatalogo rigaCatalogo = this.getRigaCatalogoBy(ombrellone).get();
        if (rigaCatalogo.getPrezzoOmbrellone() == nuovoPrezzo)
            return false;
        this.righe.remove(rigaCatalogo);
        rigaCatalogo.setPrezzoOmbrellone(nuovoPrezzo);
        return this.righe.add(rigaCatalogo);
        // PROBLEMA: CAMBIANDO IL PREZZO DELLA RIGA, LE VECCHIE PRENOTAZIONI SALVATE NELLA LISTA
        // NON HANNO PIù IL LORO VECCHIO PREZZO ASSOCIATO!
    }

    @Override
    public Optional<Ombrellone> getOmbrelloneBy(long id) {
        Optional<RigaCatalogo> rigaCatalogo =
                this.righe.stream()
                        .filter(r -> r.getOmbrellone().getId() == id)
                        .findFirst();
        if (rigaCatalogo.isEmpty())
            return Optional.empty();
        return Optional.of(rigaCatalogo.get().getOmbrellone());
    }

    @Override
    public List<Ombrellone> getOmbrelloniBy(double prezzo) {
        if (prezzo < 0)
            throw new IllegalArgumentException("Prezzo non valido!");
        List<RigaCatalogo> righeCatalogo = this.righe.stream()
                .filter(r -> r.getPrezzoOmbrellone() == prezzo)
                .collect(Collectors.toList());
        List<Ombrellone> ombrelloni = new ArrayList<>();
        for (RigaCatalogo r : righeCatalogo)
            ombrelloni.add(r.getOmbrellone());
        return ombrelloni;
    }

    @Override
    public List<Ombrellone> getOmbrelloniBy(Date data, FasciaOraria fasciaOraria) {
        if (data == null)
            throw new NullPointerException("Data null!");
        if (fasciaOraria == null)
            throw new NullPointerException("Fascia oraria null!");
        // TODO: Inserire controlli eccezione per data e fascia oraria non validi, ovvero se sono precedenti al giorno attuale
        // TODO: da testare!
        List<RigaCatalogo> rigaCatalogoStream = this.righe.stream()
                .filter(r -> r.getPrenotazioni()
                        .stream()
                        .filter(p -> p.getDataPrenotazione().equals(data)
                                && p.getFasciaOraria().equals(fasciaOraria)).isParallel()).toList();
        List<Ombrellone> ombrelloni = new ArrayList<>();
        for (RigaCatalogo r : rigaCatalogoStream)
            ombrelloni.add(r.getOmbrellone());
        return ombrelloni;
    }

    @Override
    public Optional<RigaCatalogo> getRigaCatalogoBy(Ombrellone ombrellone) {
        this.ombrelloneNullException(ombrellone);
        return this.righe.stream()
                .filter(r -> r.getOmbrellone().equals(ombrellone))
                .findFirst();
    }

    private void ombrelloneNullException(Ombrellone ombrellone) {
        if (ombrellone == null)
            throw new NullPointerException("Ombrellone null!");
    }
}

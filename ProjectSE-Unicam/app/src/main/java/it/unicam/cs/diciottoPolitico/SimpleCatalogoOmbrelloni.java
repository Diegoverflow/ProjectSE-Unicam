package it.unicam.cs.diciottoPolitico;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Semplice implementazione di un catalogo ombrelloni.
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
        if (ombrellone == null)
            throw new NullPointerException("Ombrellone null!");
        return this.righe.removeIf(rigaCatalogo ->
                rigaCatalogo.getOmbrellone().getId() == ombrellone.getId());
    }

    @Override
    public boolean modificaPrezzo(Ombrellone ombrellone, double nuovoPrezzo) {
        if (ombrellone == null)
            throw new NullPointerException("Ombrellone null!");
        if (this.getRigaCatalogoBy(ombrellone).isPresent())
            return false;
        RigaCatalogo rigaCatalogo = this.getRigaCatalogoBy(ombrellone).get();
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
        return Optional.of(rigaCatalogo.get().getOmbrellone());
    }

    @Override
    public List<Ombrellone> getOmbrelloniBy(double prezzo) {
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
        // TODO: implementare
        return null;
    }

    @Override
    public Optional<RigaCatalogo> getRigaCatalogoBy(Ombrellone ombrellone) {
        return this.righe.stream()
                .filter(r -> r.getOmbrellone().equals(ombrellone))
                .findFirst();
    }
}

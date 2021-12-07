package it.unicam.cs.diciottoPolitico;

//todo api
public interface RigaCatalogoBar extends RigaCatalogo<ArticoloBar>{
    double getPrezzo();
    int getQuantita();
    void setQuantita(double quantita);
    void setPrezzo(double prezzo);
}

package it.unicam.cs.diciottoPolitico;

//TODO inserire le API
public interface Ombrellone {
    long getId();
    boolean getLibero();//io lo chiamerei isLibero()
    Categoria getCategoria();
    void setLibero(boolean libero);
    void setCategoria(Categoria categoria);
}

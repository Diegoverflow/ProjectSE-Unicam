package it.unicam.cs.diciottoPolitico;

public interface HandlerCatalogo <R> {

    boolean aggiungiRigaCatalogo(R rigaDaAggiungere);

    boolean rimuoviRigaCatalogo(R rigaDaEliminare);


}

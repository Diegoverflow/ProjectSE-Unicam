package it.unicam.cs.diciottoPolitico;

public interface Notifica2 {
    Utente getUtente();

    String getMessaggio();

    long getId();

    boolean daLeggere();
}

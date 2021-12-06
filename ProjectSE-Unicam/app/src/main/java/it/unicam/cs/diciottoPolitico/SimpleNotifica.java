package it.unicam.cs.diciottoPolitico;

public class SimpleNotifica implements Notifica{

    private long id;
    private final String messaggio;

    public SimpleNotifica(long id, String messaggio) {
        this.id = id;
        this.messaggio = messaggio;
    }

    public SimpleNotifica(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getMessaggio() {
        return this.messaggio;
    }
}

package it.unicam.cs.diciottoPolitico;

import java.util.List;

public class SimpleHandleUtenti implements  HandlerUtenti{

    // TODO: 15/01/22 rendere Singleton

    private List<Utente> clienti;
    private List<Utente> personaleBar;
    private List<Utente> cassieri;
    private List<Utente> gestori;

    @Override
    public List<Utente> getClienti() {
        return this.clienti;
    }

    @Override
    public List<Utente> getPersonaleBar() {
        return this.personaleBar;
    }

    @Override
    public List<Utente> getCassieri() {
        return this.cassieri;
    }

    @Override
    public List<Utente> getGestori() {
        return this.gestori;
    }

    @Override
    public boolean creaCliente(String nome, String cognome, String password, String cellulare, String email) {
        return false;
    }

    @Override
    public boolean creaPersonaleBar(String nome, String cognome, String password, String cellulare, String email) {
        return false;
    }

    @Override
    public boolean creaCassiere(String nome, String cognome, String password, String cellulare, String email) {
        return false;
    }

    @Override
    public boolean creaGestore(String nome, String cognome, String password, String cellulare, String email) {
        return false;
    }

    @Override
    public boolean eliminaUtente(long codice) {
        return false;
    }

    @Override
    public boolean autenticarsi(String email, String password) {
        return false;
    }
}

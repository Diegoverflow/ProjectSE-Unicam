package it.unicam.cs.diciottoPolitico;

import java.util.List;
import java.util.Objects;

/**
 * Semplice implementazione dell'interfaccia HandlerUtenti.
 * Questa classe &egrave; una classe singleton.
 */
public class SimpleHandlerUtenti implements HandlerUtenti{

    private static SimpleHandlerUtenti instance;
    private List<Cliente> clienti;
    private List<AddettoBar> addettiBar;

    private SimpleHandlerUtenti(){
    }

    @Override
    public boolean creaCliente(String password, String nome, String cognome, String cellulare, String email) {
        Cliente cliente = new SimpleCliente(Objects.requireNonNull(email),Objects.requireNonNull(password),Objects.requireNonNull(nome),Objects.requireNonNull(cognome),Objects.requireNonNull(cellulare));
        if (this.clienti.contains(cliente))
            return false;
        return this.clienti.add(cliente);
    }

    @Override
    public boolean creaAddettoBar(String password, String nome, String cognome, String cellulare) {
        AddettoBar addettoBar = new SimpleAddettoBar(Objects.requireNonNull(nome),Objects.requireNonNull(cellulare),Objects.requireNonNull(cognome),Objects.requireNonNull(password));
        if (this.addettiBar.contains(addettoBar))
            return false;
        return this.addettiBar.add(addettoBar);
    }

    @Override
    public List<Cliente> getClienti() {
        return this.clienti;
    }

    @Override
    public List<AddettoBar> getAddettiBar() {
        return this.addettiBar;
    }

    @Override
    public boolean eliminaUtente(long id) {
        return this.clienti.removeIf(c->c.getId() == id) || this.addettiBar.removeIf(a->a.getId() == id);
    }

    @Override
    public HandlerUtenti getInstance() {
        if (instance == null) {
            instance = new SimpleHandlerUtenti();
        }
        return instance;
    }
}

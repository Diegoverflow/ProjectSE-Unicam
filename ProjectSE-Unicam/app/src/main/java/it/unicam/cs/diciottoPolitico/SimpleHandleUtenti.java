package it.unicam.cs.diciottoPolitico;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleHandleUtenti implements  HandlerUtenti{

    // TODO: 15/01/22 rendere Singleton

    private Set<Utente> utenti;

    @Override
    public Set<Utente> getClienti() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuolo().equals(RuoloUtente.CLIENTE)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getPersonaleBar() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuolo().equals(RuoloUtente.ADDETTO_BAR)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getCassieri() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuolo().equals(RuoloUtente.CASSIERE)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getGestori() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuolo().equals(RuoloUtente.GESTORE)).
                collect(Collectors.toSet());
    }

    @Override
    public boolean creaCliente(String nome, String cognome, String password, String cellulare, String email) {
        return this.utenti.add(new SimpleUtente(nome, cognome, password, cellulare, email, RuoloUtente.CLIENTE));
    }

    @Override
    public boolean creaPersonaleBar(String nome, String cognome, String password, String cellulare, String email) {
        return this.utenti.add(new SimpleUtente(nome, cognome, password, cellulare, email, RuoloUtente.ADDETTO_BAR));
    }

    @Override
    public boolean creaCassiere(String nome, String cognome, String password, String cellulare, String email) {
        return this.utenti.add(new SimpleUtente(nome, cognome, password, cellulare, email, RuoloUtente.CASSIERE));
    }

    @Override
    public boolean creaGestore(String nome, String cognome, String password, String cellulare, String email) {
        return this.utenti.add(new SimpleUtente(nome, cognome, password, cellulare, email, RuoloUtente.GESTORE));
    }

    @Override
    public boolean eliminaUtente(long codice) {
        Optional<Utente> optionalUtente= this.utenti.parallelStream().
                                    filter(utente -> utente.getId()==codice).
                                        findFirst();
        if (optionalUtente.isPresent()){
            this.utenti.remove(optionalUtente.get());
            return true;
        }
        return false;
    }


    @Override
    public boolean autenticarsi(String email, String password) {
        Optional<Utente> optionalUtente= this.utenti.parallelStream().
                filter(utente -> utente.getEmail().equals(email)).
                filter(utente -> utente.getPassword().equals(password)).
                findFirst();
        if (optionalUtente.isPresent()){
            this.utenti.remove(optionalUtente.get());
            return true;
        }
        return false;
    }
}

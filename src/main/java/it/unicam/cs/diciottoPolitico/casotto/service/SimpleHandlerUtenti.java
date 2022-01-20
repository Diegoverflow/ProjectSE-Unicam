package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleHandlerUtenti implements  HandlerUtenti{

    // TODO: 15/01/22 rendere Singleton

    private final Set<Utente> utenti;
    private HandlerUtenti uniqueIstance;

    private SimpleHandlerUtenti (Set<Utente> utenti){
        this.utenti = utenti;
    }

    public static HandlerUtenti getIstance(Set<Utente> utenti){
        return null;
    }

    @Override
    public Set<Utente> getClienti() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuoloUtente().equals(RuoloUtente.CLIENTE)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getPersonaleBar() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuoloUtente().equals(RuoloUtente.ADDETTO_BAR)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getCassieri() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuoloUtente().equals(RuoloUtente.CASSIERE)).
                collect(Collectors.toSet());
    }

    @Override
    public Set<Utente> getGestori() {
        return this.utenti.stream().parallel().
                filter(utente -> utente.getRuoloUtente().equals(RuoloUtente.GESTORE)).
                collect(Collectors.toSet());
    }

    @Override
    public boolean creaUtente(String nome, String cognome, String password, String cellulare, String email, RuoloUtente ruoloUtente) {
        return this.utenti.add(new SimpleUtente(nome, cognome, password, cellulare, email, ruoloUtente));
    }

    @Override
    public boolean eliminaUtente(long codice) {
        /*Optional<Utente> optionalUtente= this.utenti.parallelStream().
                                    filter(utente -> utente.getId()==codice).
                                        findFirst();
        if (optionalUtente.isPresent()){
            this.utenti.remove(optionalUtente.get());
            return true;
        }*/
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

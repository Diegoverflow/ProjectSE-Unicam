package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtentiService {

    private final UtenteRepository utenteRepository;

    @Autowired
    protected UtentiService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> getUtenti(){
        return this.utenteRepository.findAll();
    }

    public List<Utente> getClienti(){
        return this.getUtenti(RuoloUtente.CLIENTE);
    }

    public List<Utente> getCassieri(){
        return this.getUtenti(RuoloUtente.CASSIERE);
    }

    public List<Utente> getAddettiBar(){
        return this.getUtenti(RuoloUtente.ADDETTO_BAR);
    }

    public List<Utente> getGestore(){
        return this.getUtenti(RuoloUtente.GESTORE);
    }

    public boolean autenticazione(String email, String password) {
        return this.getUtenti().stream()
                .anyMatch(utente -> utente.getEmail().equals(email) && utente.getPassword().equals(password));
    }

    public Utente addUtente(Utente utente){
        return this.utenteRepository.save(utente);
    }

    public void removeUtente(SimpleUtente utente){
        this.utenteRepository.delete(utente);
    }

    public SimpleUtente updateUtente(SimpleUtente utente){
        return this.utenteRepository.findById(utente.getId()).isPresent()?
             this.utenteRepository.save(utente)
                :null;
    }

    private List<Utente> getUtenti(RuoloUtente ruoloUtente){
        return this.getUtenti().stream()
                .filter(utente -> utente.getRuoloUtente() == ruoloUtente)
                .collect(Collectors.toList());
    }

}

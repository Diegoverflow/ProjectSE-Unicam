package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtentiService extends AbstractService<SimpleUtente, UtenteRepository>{

    @Autowired
    protected UtentiService(UtenteRepository repository) {
        super(repository);
    }

    public List<SimpleUtente> filtraBy(RuoloUtente ruoloUtente){
        return super.getBy(u->u.getRuoloUtente().equals(ruoloUtente));
    }

    public boolean autenticazione(String email, String password) {
        return super.getAll().stream()
                .anyMatch(utente -> utente.getEmail().equals(email) && utente.getPassword().equals(password));
    }

}

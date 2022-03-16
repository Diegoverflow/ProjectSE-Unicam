package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleNotifica;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service degli utenti che vogliono usufruire dei servizi dello chalet.
 * Esso si occupa di gestire le operazioni CRUD riguardanti il {@link SimpleUtente} interagendo con il relativo
 * {@link UtenteRepository}.
 *
 * @see SimpleUtente
 * @see UtenteRepository
 */
@Service
public class UtenteService extends AbstractService<SimpleUtente, UtenteRepository> {

    /**
     * Crea un service per gli utenti iniettando il repository degli utenti.
     *
     * @param repository il repository degli utenti da iniettare
     */
    @Autowired
    public UtenteService(UtenteRepository repository) {
        super(repository);
    }

    /**
     * Restituisce la lista di tutti gli utenti che hanno il  {@link RuoloUtente} specificato.
     *
     * @param ruoloUtente il ruolo utente che possiedono gli utenti da filtrare
     * @return la lista di tutti gli utenti che hanno il  {@code RuoloUtente} specificato
     */
    public List<SimpleUtente> filtraBy(RuoloUtente ruoloUtente) {
        return super.getBy(u -> u.getRuoloUtente().equals(ruoloUtente));
    }

    public SimpleUtente getBy(String email){
        return super.getBy(u -> u.getEmail().equals(email)).stream().findFirst().orElse(null);
    }

    public SimpleUtente getLoggedUser(){
        return this.getBy((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public List<SimpleNotifica> getAllNotificheLoggedUser(){
        return this.getLoggedUser().getNotifiche();
    }

}

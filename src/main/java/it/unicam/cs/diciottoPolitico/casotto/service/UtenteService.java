package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.RuoloUtente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // TODO: javadoc
    public boolean autenticazione(String email, String password) {
        return super.getAll().stream()
                .anyMatch(utente -> utente.getEmail().equals(email) && utente.getPassword().equals(password));
    }

}

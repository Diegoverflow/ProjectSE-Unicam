package it.unicam.cs.diciottoPolitico.casotto.security;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SimpleUtente utente = utenteRepository.getUserByUsername(username);
        if (utente == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UtenteWrapper(utente);
    }
}

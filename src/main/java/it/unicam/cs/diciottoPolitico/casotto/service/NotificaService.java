package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleNotifica;
import it.unicam.cs.diciottoPolitico.casotto.repository.NotificaRepository;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NotificaService {

    // TODO: 21/01/22 SISTEMARE  
    private final NotificaRepository notificaRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public NotificaService(NotificaRepository notificaRepository, UtenteRepository utenteRepository) {
        this.notificaRepository = notificaRepository;
        this.utenteRepository = utenteRepository;
    }

    public void notifica(SimpleNotifica notifica, List<Utente> utentiDestinatari){
        this.notificaRepository.save(notifica);
        this.utenteRepository.
                findAllById(this.getUUIDs(utentiDestinatari)).
                forEach(utente->utente.addNotifica(notifica));
    }

    private List<UUID> getUUIDs(List<Utente> utentiDestinatari){
        List<UUID> uuids = new ArrayList<>();
        for (Utente u :
                utentiDestinatari) {
            uuids.add(u.getId());
        }
        return uuids;
    }


}

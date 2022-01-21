package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleNotifica;
import it.unicam.cs.diciottoPolitico.casotto.repository.NotificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificaService {

    private final NotificaRepository notificaRepository;

    @Autowired
    public NotificaService(NotificaRepository notificaRepository) {
        this.notificaRepository = notificaRepository;
    }

    public void notifica(SimpleNotifica notifica){
        this.notificaRepository.save(notifica);
    }




}

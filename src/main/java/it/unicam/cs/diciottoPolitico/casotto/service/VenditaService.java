package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VenditaService {

    private final VenditaRepository venditaRepository;

    @Autowired
    public VenditaService(VenditaRepository venditaRepository) {
        this.venditaRepository = venditaRepository;
    }

    public List<SimpleVendita> getVenditeClienteDaPagare(UUID idUtente){
        return this.venditaRepository.
                findAll().
                stream().
                parallel().
                filter(vendita->vendita.getUtente().getId().equals(idUtente)).
                collect(Collectors.toList());
        
    }

    public void saldaVendita(SimpleVendita vendita){
        this.venditaRepository.findById(vendita.getId()).ifPresent(v->v.setPagata(true));
    }
    
    public SimpleVendita addVendita(SimpleVendita vendita){
        return this.venditaRepository.save(vendita);
    }

    public void removeVendita(SimpleVendita vendita){
        this.venditaRepository.delete(vendita);
    }

    public void updateVendita(SimpleVendita vendita){
        // TODO: 24/01/22 sul controllere utilizzare "addVendita" 
    }

}
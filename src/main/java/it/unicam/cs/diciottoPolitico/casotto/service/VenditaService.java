package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VenditaService extends AbstractService<SimpleVendita, VenditaRepository>{

    @Autowired
    private VenditaRepository venditaRepository;

    public VenditaService(VenditaRepository repository) {
        super(repository);
    }

    public List<SimpleVendita> getVenditeClienteDaPagare(UUID idUtente){
        return this.venditaRepository.
                findAll().
                stream().
                parallel().
                filter(vendita->vendita.getUtente().getId().equals(idUtente)).
                collect(Collectors.toList());
        
    }

    public void saldaVendita(UUID id){
        this.venditaRepository.findById(id).ifPresent(vendita->vendita.setPagata(true));
    }

}
package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoAttivita;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoAttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RigaCatalogoAttivitaService extends AbstractService<SimpleRigaCatalogoAttivita, RigaCatalogoAttivitaRepository>{

    @Autowired
    public RigaCatalogoAttivitaService(RigaCatalogoAttivitaRepository repository) {
        super(repository);
    }

    public List<SimpleRigaCatalogoAttivita> getAttivitaDisponibili(){
        return super.getBy(riga -> riga.getPostiTotali()> riga.getPostiOccupati());
    }

    public List<SimpleRigaCatalogoAttivita> getAttivitaNonDisponibili(){
        return super.getBy(riga -> riga.getPostiTotali()== riga.getPostiOccupati());
    }

    public List<SimpleRigaCatalogoAttivita> filtraBy(double prezzoLimite){
        return super.getBy(riga->riga.getPrezzo()<=prezzoLimite);
    }

    public List<SimpleRigaCatalogoAttivita> filtraBy(int numeroMaxPostiTotali){
        return super.getBy(riga->riga.getPostiTotali()<=numeroMaxPostiTotali);
    }

    public Optional<SimpleRigaCatalogoAttivita> getRigaBy(String nomeAttivita){
        return super.getBy(riga->riga.getValore().getNome().equals(nomeAttivita)).stream().findFirst();
    }


}

package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RigaCatalogoBarService extends AbstractService<SimpleRigaCatalogoBar, RigaCatalogoBarRepository> {

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        super(repository);
    }

    public List<SimpleRigaCatalogoBar> filtraBy(int quantita){
        return super.getBy(p->p.getQuantita()==quantita);
    }

    public List<SimpleRigaCatalogoBar> filtraBy(double prezzo){
        return super.getBy(p->p.getPrezzo()==prezzo);
    }

    public Optional<SimpleRigaCatalogoBar> getRigaBy(SimpleArticoloBar articoloBar){
        return super.getBy(p->p.getValore().equals(articoloBar)).stream().findFirst();
    }

    public Optional<SimpleRigaCatalogoBar> getRigaBy(String nomeArticolo){
        return super.getBy(riga->riga.getValore().getNome().equals(nomeArticolo)).stream().findFirst();
    }

}

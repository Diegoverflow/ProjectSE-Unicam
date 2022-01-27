package it.unicam.cs.diciottoPolitico.casotto.service;


import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.Ombrellone;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RigaCatalogoOmbrelloneService extends AbstractService<SimpleRigaCatalogoOmbrellone, RigaCatalogoOmbrelloneRepository> {

    @Autowired
    public RigaCatalogoOmbrelloneService(RigaCatalogoOmbrelloneRepository repository) {
        super(repository);
    }

    @Override
    public SimpleRigaCatalogoOmbrellone save(SimpleRigaCatalogoOmbrellone riga){
        if (super.getBy(riga.getId()).isEmpty() && this.getRigaBy(riga.getValore()).isEmpty())
            return super.save(riga);
        return null;
    }

    public SimpleRigaCatalogoOmbrellone update(SimpleRigaCatalogoOmbrellone riga){
        var r = super.getBy(riga.getId());
        if (r.isPresent())
            if(super.getBy(ri-> ri.getValore().equals(riga.getValore()) && !ri.equals(r.get())).isEmpty())
            return super.save(riga);
        return null;
    }

    public Optional<SimpleRigaCatalogoOmbrellone> getRigaBy(Ombrellone ombrellone) {
        return super.getBy(riga->riga.getValore().equals(ombrellone))
                .stream()
                .findFirst();
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(Categoria categoria) {
        return super.getBy(riga -> riga.getValore().getCategoria().equals(categoria));
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(double prezzoLimite) {
        return super.getBy(riga -> riga.getPrezzoOmbrellone() <= prezzoLimite);
    }

    public List<SimpleRigaCatalogoOmbrellone> filterBy(String codiceSpiaggia) {
        return super.getBy(riga -> riga.getValore().getCodiceSpiaggia().equals(codiceSpiaggia));
    }

}

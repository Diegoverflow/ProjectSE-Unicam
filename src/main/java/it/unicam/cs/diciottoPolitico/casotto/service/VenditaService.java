package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VenditaService extends AbstractService<SimpleVendita, VenditaRepository> {

    @Autowired
    public VenditaService(VenditaRepository repository) {
        super(repository);
    }

    public List<SimpleVendita> getVenditeClienteDaPagare(UUID idUtente) {
        return super.getBy(vendita -> vendita.getUtente().getId().equals(idUtente));
    }

    public List<SimpleVendita> filtraBy(double costo) {
        return super.getBy(v -> v.getCosto() == costo);
    }

    public List<SimpleVendita> filtraBy(Date data) {
        return super.getBy(v -> v.getDataAcquisto().equals(data));
    }

    // TODO: Testare after e before per vedere se equals è necessario
    public List<SimpleVendita> filtraDaA(Date inizio, Date fine) {
        return super.getBy(v -> (v.getDataAcquisto().equals(inizio) || v.getDataAcquisto().equals(fine))
                && (v.getDataAcquisto().after(inizio) && v.getDataAcquisto().before(fine)));
    }

}
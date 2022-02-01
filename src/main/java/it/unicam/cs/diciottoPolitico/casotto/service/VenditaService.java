package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleVendita;
import it.unicam.cs.diciottoPolitico.casotto.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Service delle vendite degli acquisti effettuati dai clienti dello chalet.
 * Esso si occupa di gestire le operazioni CRUD riguardanti il {@link SimpleVendita} interagendo con il relativo
 * {@link VenditaRepository}.
 *
 * @see SimpleVendita
 * @see VenditaRepository
 */
@Service
public class VenditaService extends AbstractService<SimpleVendita, VenditaRepository> {

    /**
     * Crea un service per le vendite iniettando il repository delle vendite.
     *
     * @param repository il repository delle vendite da iniettare
     */
    @Autowired
    public VenditaService(VenditaRepository repository) {
        super(repository);
    }

    /**
     * Restituisce la lista di tutte le vendite ancora da pagare per l' utente avente id specificato.
     *
     * @param idUtente l' id dell' utente di cui ricavare tutte le vendite ancora da saldare
     * @return la lista di tutte le vendite ancora da pagare per l' utente avente id specificato
     */
    public List<SimpleVendita> getVenditeClienteDaPagare(UUID idUtente) {
        return super.getBy(vendita -> vendita.getUtente().getId().equals(idUtente));
    }

    public SimpleVendita updateIsPagato(UUID idVendita, boolean isPagato) {
        var v = this.getBy(idVendita);
        if (v.isPresent()){
            v.get().setPagata(isPagato);
            return super.save(v.get());
        }
        return null;
    }

    /**
     * Restituisce la lista di tutte le vendite aventi costo specificato.
     *
     * @param costo delle vendite da filtrare
     * @return la lista di tutte le vendite aventi costo specificato
     */
    public List<SimpleVendita> filtraBy(double costo) {
        return super.getBy(v -> v.getCosto() == costo);
    }

    /**
     * Restituisce la lista di tutte le vendite degli acquisti effettuati nella data specificata.
     *
     * @param data in cui sono stati effettuati acquisti delle vendite da filtrare
     * @return la lista di tutte le vendite degli acquisti effettuati nella data specificata
     */
    public List<SimpleVendita> filtraBy(Date data) {
        return super.getBy(v -> v.getDataAcquisto().equals(data));
    }

    /**
     * Restituisce la lista di tutte le vendite degli acquisti effettuati nella periodo specificata tramite inizio e fine.
     *
     * @param data in cui sono stati effettuati acquisti delle vendite da filtrare
     * @return la lista di tutte le vendite degli acquisti effettuati nella data specificata
     */
    /**
     * Restituisce la lista di tutte le vendite degli acquisti effettuati nella periodo specificata tramite inizio e fine.
     *
     * @param inizio la data di inizio (inclusa) del periodo delle vendite da filtrare
     * @param fine   la data di fine (inclusa) del periodo delle vendite da filtrare
     * @return la lista di tutte le vendite degli acquisti effettuati nel periodo specificato
     */
    /*public List<SimpleVendita> filtraDaA(Date inizio, Date fine) {
        return super.getBy(v -> (v.getDataAcquisto().equals(inizio) || v.getDataAcquisto().equals(fine))
                && (v.getDataAcquisto().after(inizio) && v.getDataAcquisto().before(fine)));
    }*/

}
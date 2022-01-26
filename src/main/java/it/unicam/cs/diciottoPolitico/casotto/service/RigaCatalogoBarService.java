package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleArticoloBar;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoBar;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service del catalogo bar.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleRigaCatalogoBar} interagendo con il relativo
 * {@link RigaCatalogoBarRepository}.
 *
 * @see SimpleRigaCatalogoBar
 * @see RigaCatalogoBarRepository
 */
@Service
public class RigaCatalogoBarService extends AbstractService<SimpleRigaCatalogoBar, RigaCatalogoBarRepository> {

    @Autowired
    public RigaCatalogoBarService(RigaCatalogoBarRepository repository) {
        super(repository);
    }

    /**
     * Restituisce la lista di tutte le righe aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata.
     *
     * @param quantitaLimite la quantit&agrave; limite inclusa
     * @return la lista di tutte le righe aventi quantit&agrave; minore o uguale alla quantit&agrave; specificata
     */
    public List<SimpleRigaCatalogoBar> filtraBy(int quantitaLimite) {
        return super.getBy(p -> p.getQuantita() <= quantitaLimite);
    }

    /**
     * Restituisce la lista di tutte le righe aventi prezzo minore o uguale al prezzo specificato.
     *
     * @param prezzoLimite il prezzo limite inclusa
     * @return la lista di tutte le righe aventi prezzo minore o uguale al prezzo specificato
     */
    public List<SimpleRigaCatalogoBar> filtraBy(double prezzoLimite) {
        return super.getBy(p -> p.getPrezzo() <= prezzoLimite);
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleRigaCatalogoBar} avente come {@link SimpleArticoloBar} l' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga avente l' articolo bar specificato nel database.
     *
     * @param articoloBar l' articolo bar di cui ricavare la riga
     * @return un {@code Optional} che descrive una {@code SimpleRigaCatalogoBar} avente l' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga con l' articolo bar specificato
     */
    public Optional<SimpleRigaCatalogoBar> getRigaBy(SimpleArticoloBar articoloBar) {
        return super.getBy(p -> p.getValore().equals(articoloBar)).stream().findFirst();
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleRigaCatalogoBar} avente come nome del {@link SimpleArticoloBar} il nome specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga avente il nome dell' articolo bar specificato nel database.
     *
     * @param nomeArticolo il nome dell' articolo bar di cui ricavare la riga
     * @return un {@code Optional} che descrive una {@code SimpleRigaCatalogoBar} avente il nome dell' articolo bar specificato
     * oppure un empty {@code Optional} se non viene trovata nessuna riga con il nome dell' articolo bar specificato
     */
    public Optional<SimpleRigaCatalogoBar> getRigaBy(String nomeArticolo) {
        return super.getBy(riga -> riga.getValore().getNome().equals(nomeArticolo)).stream().findFirst();
    }

}

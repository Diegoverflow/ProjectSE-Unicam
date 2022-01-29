package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Categoria;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.utils.QRCode;
import it.unicam.cs.diciottoPolitico.casotto.utils.QRCodeGenerator;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatalogoOmbrellone;
import it.unicam.cs.diciottoPolitico.casotto.repository.RigaCatalogoOmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service delle righe del catalogo degli ombrelloni.
 * Esso si occupa di gestire le operazioni CRUD riguardanti la {@link SimpleRigaCatalogoOmbrellone} interagendo con il relativo
 * {@link RigaCatalogoOmbrelloneRepository}.
 *
 * @see SimpleRigaCatalogoOmbrellone
 * @see RigaCatalogoOmbrelloneRepository
 */
@Service
public class RigaCatalogoOmbrelloneService extends AbstractService<SimpleRigaCatalogoOmbrellone, RigaCatalogoOmbrelloneRepository> {

    private static final String url = "http://localhost:8080/bar/ordinazioni/";

    /**
     * Crea un service per le righe catalogo degli ombrelloni iniettando il {@link RigaCatalogoOmbrelloneRepository} specificato.
     *
     * @param repository il {@code RigaCatalogoOmbrelloneRepository} da iniettare
     */

    @Autowired
    public RigaCatalogoOmbrelloneService(RigaCatalogoOmbrelloneRepository repository) {
        super(repository);
    }

    @Override
    public SimpleRigaCatalogoOmbrellone save(SimpleRigaCatalogoOmbrellone riga) {
        if (this.filterBy(riga.getValore().getCodiceSpiaggia().getNome()).isEmpty() && super.getBy(riga.getId()).isEmpty() && this.getRigaBy(riga.getValore()).isEmpty()) {
            QRCode qrCode = riga.getValore().getCodiceSpiaggia();
            qrCode.setQRCodeImage(QRCodeGenerator.createQRCode(url + qrCode.getNome(), "PNG"));
            return super.save(riga);
        }
        return null;
    }

    /**
     * Aggiorna la {@link SimpleRigaCatalogoOmbrellone} specificata se esiste all' interno del database.
     *
     * @param riga la riga da aggiornare all' interno del database
     * @return la {@code SimpleRigaCatalogoOmbrellone} aggiornata se prima di essere aggiornata esisteva sul database, {@code null} altrimenti
     */
    public SimpleRigaCatalogoOmbrellone update(SimpleRigaCatalogoOmbrellone riga) {
        var r = super.getBy(riga.getId());
        if (r.isPresent())
            if (super.getBy(ri -> ri.getValore().equals(riga.getValore()) && !ri.equals(r.get())).isEmpty())
                return super.save(riga);
        return null;
    }

    /**
     * Restituisce un {@link Optional} che descrive una {@link SimpleRigaCatalogoOmbrellone} che contiene il
     * {@link SimpleOmbrellone} specificato, un empty {@code Optional} altrimenti.
     *
     * @param ombrellone il {@code SimpleOmbrellone} da verificare se &egrave; contenuto all' interno di qualche riga del catalogo ombrelloni nel database
     * @return un {@link Optional} che descrive una {@link SimpleRigaCatalogoOmbrellone} che contiene il
     * {@link SimpleOmbrellone} specificato, un empty {@code Optional} altrimenti
     */
    public Optional<SimpleRigaCatalogoOmbrellone> getRigaBy(SimpleOmbrellone ombrellone) {
        return super.getBy(riga -> riga.getValore().equals(ombrellone))
                .stream()
                .findFirst();
    }

    /**
     * Restituisce la lista di tutte le righe del catalogo ombrelloni che contengono il
     * {@link SimpleOmbrellone} avente la {@link Categoria} specificata.
     *
     * @param categoria la categoria in base a cui filtrare gli ombrelloni
     * @return la lista di tutte le righe del catalogo ombrelloni che contengono il
     * {@link SimpleOmbrellone} avente la {@link Categoria} specificata
     */
    public List<SimpleRigaCatalogoOmbrellone> filterBy(Categoria categoria) {
        return super.getBy(riga -> riga.getValore().getCategoria().equals(categoria));
    }

    /**
     * Restituisce la lista di tutte le righe del catalogo ombrelloni aventi come prezzo un prezzo <= del prezzo specificato.
     *
     * @param prezzoLimite il prezzo limite per filtrare le righe
     * @return la lista di tutte le righe del catalogo ombrelloni aventi come prezzo un prezzo <= del prezzo specificato
     */
    public List<SimpleRigaCatalogoOmbrellone> filterBy(double prezzoLimite) {
        return super.getBy(riga -> riga.getPrezzoOmbrellone() <= prezzoLimite);
    }

    /**
     * Restituisce un {@link Optional} che descrive la {@link SimpleRigaCatalogoOmbrellone} che contiene il
     * {@link SimpleOmbrellone} avente come codice spieggia il codice spiaggia specificato, un empty {@code Optional} altrimenti.
     *
     * @param codiceSpiaggia il codice spiaggia da filtrare
     * @return un {@code Optional} che descrive la {@code SimpleRigaCatalogoOmbrellone} che contiene il
     *      * {@code SimpleOmbrellone} avente come codice spieggia il codice spiaggia specificato, un empty {@code Optional} altrimenti
     */
    public Optional<SimpleRigaCatalogoOmbrellone> filterBy(String codiceSpiaggia) {
        return super.getBy(riga -> riga.getValore().getCodiceSpiaggia().getNome().equals(codiceSpiaggia)).stream().findFirst();
    }

}

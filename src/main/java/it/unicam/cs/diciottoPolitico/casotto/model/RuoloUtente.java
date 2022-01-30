package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Utente;

/**
 * Ruolo che un {@link Utente} ricopre.
 * Un {@code Utente} pu&ograve; ricoprire uno ed un solo ruolo tra i seguenti:
 * <ul>
 *     <li>{@link #GESTORE}<br>
 *          Il gestore dello chalet.
 *     </li>
 *     <li>{@link #CLIENTE}<br>
 *          Il cliente dello chalet.
 *     </li>
 *     <li>{@link #ADDETTO_BAR}<br>
 *          L' addetto bar dello chalet.
 *     </li>
 *     <li>{@link #CASSIERE}<br>
 *          Il cassiere dello chalet.
 *     </li>
 * </ul>
 */
public enum RuoloUtente {

    GESTORE("ROLE_GESTORE"),
    CLIENTE("ROLE_CLIENTE"),
    ADDETTO_BAR("ROLE_ADDETTO_BAR"),
    CASSIERE("ROLE_CASSIERE");

    private final String ruolo;

    RuoloUtente(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return this.ruolo;
    }

}

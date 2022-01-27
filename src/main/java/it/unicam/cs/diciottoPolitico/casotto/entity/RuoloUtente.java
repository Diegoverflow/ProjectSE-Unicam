package it.unicam.cs.diciottoPolitico.casotto.entity;

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
    GESTORE, CLIENTE, ADDETTO_BAR, CASSIERE
}

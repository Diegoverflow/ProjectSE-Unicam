package it.unicam.cs.diciottoPolitico;

/**
 * Una tipologia a cui un utente che ha effettuato l' autenticazione, ovvero un {@link UtenteLoggato} appartiene.
 * Un {@link UtenteLoggato} pu&ograve; essere appartenerein una delle seguenti tipologie:
 * <ul>
 *       <li>{@link #GESTORE}<br>
 *      Un utente che viene considerato a tutti gli effetti un gestore.
 *           </li>
 *      <li>{@link #CASSIERE}<br>
 *      Un utente che &egrave; stato abilitato per essere un cassiere.
 *           </li>
 *       <li>{@link #ADDETTO_BAR}<br>
 *            Un utente che &egrave; stato abilitato per essere un addetto bar.
 *      </li>
 *      <li>{@link #CLIENTE}<br>
 *          Un cliente che &egrave; stato abilitato per essere un cliente dello chalet.
 *      </li>
 *         </ul>
 *  <p>
 *     Un utente pu&ograve; appartenere ad una sola tipologia alla volta // TODO: una o più tipologie?
 * </p>
 */
public enum TipologiaUtente {
    GESTORE, CASSIERE, ADDETTO_BAR, CLIENTE
}

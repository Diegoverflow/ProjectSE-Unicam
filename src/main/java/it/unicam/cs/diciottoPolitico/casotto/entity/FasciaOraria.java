package it.unicam.cs.diciottoPolitico.casotto.entity;

/**
 * Una fascia oraria in cui un {@link Ombrellone} &grave; stato prenotato.
 * Un {@link Ombrellone} pu&ograve; essere prenotato in una delle seguenti fasce orarie:
 * <ul>
 *      <li>{@link #MATTINO}<br>
 *      Un ombrellone che &egrave; stato prenotato dalle 7:00 fino alle 13:00.
 *           </li>
 *      <li>{@link #POMERIGGIO}<br>
 *      Un ombrellone che &egrave; stato prenotato dalle 13:00 alle 20:00.
 *           </li>
 *       <li>{@link #GIORNATA_INTERA}<br>
 *            Un ombrellone che &egrave; stato prenotato dalle 7:00 fino alle 20:00.
 *       </ul>
 *
 * <p>
 *     Un ombrellone pu&ograve; essere prenotato in pi&ugrave; fasce orarie, con l' unico vincolo
 *     di poter essere prenotato nella stessa fascia oraria al pi&ugrave; una sola volta.
 * </p>
 */
public enum FasciaOraria {
    MATTINO, POMERIGGIO, GIORNATA_INTERA
}

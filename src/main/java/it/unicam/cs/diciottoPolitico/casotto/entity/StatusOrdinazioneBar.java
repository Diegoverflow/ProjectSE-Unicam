package it.unicam.cs.diciottoPolitico.casotto.entity;

/**
 * Status in cui un {@link OrdinazioneBar} si pu&ograve; trovare durante il proprio ciclo di vita.
 * Un' {@code OrdinazioneBar} si pu&ograve; trovare in uno ed un solo status tra i seguenti:
 * <ul>
 *      <li>{@link #DA_PRENDERE_IN_CARICO}<br>
 *           L' ordinazione &egrave; stata effettuata dal cliente e deve essere presa in carico da un addetto bar.
 *      </li>
 *      <li>{@link #PRESO_IN_CARICO}<br>
 *           L' ordinazione &egrave; stata presa in carico dall' addetto bar.
 *      </li>
 *      <li>{@link #CONSEGNATO}<br>
 *           L' ordinazione &egrave; stata consegnata dall' addetto bar al cliente.
 *      </li>
 *  </ul>
 */
public enum StatusOrdinazioneBar {
    DA_PRENDERE_IN_CARICO, PRESO_IN_CARICO, CONSEGNATO
}

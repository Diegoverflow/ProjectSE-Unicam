package it.unicam.cs.diciottoPolitico;

/**
 * Rappresenta una generica riga di un catalogo.
 * Una riga non &egrave; altro che una n-upla formata principalmente da un oggetto di tipo <T>
 * ed eventualmente altri dati.
 *
 * @param <T> il tipo parametrico per l' oggetto relativo alla riga.
 */
public interface RigaCatalogo<T> {

    /**
     * Restituisce l' oggetto relativo alla riga.
     *
     * @return l' oggetto relativo alla riga
     */
    T getValore();

}

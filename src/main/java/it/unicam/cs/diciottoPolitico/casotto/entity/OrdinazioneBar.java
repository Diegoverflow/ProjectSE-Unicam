package it.unicam.cs.diciottoPolitico.casotto.entity;


/**
 * Rappresenta un'ordinazione bar.
 *
 * @see ArticoloBar
 */
public interface OrdinazioneBar extends Vendita{

    /**
     * Ritorna l' {@link ArticoloBar} associato all'ordinazione.
     *
     * @return l'articolo bar associato all'ordinazione
     * @see ArticoloBar
     */
    ArticoloBar getArticoloBar();

    /**
     * Ritorna lo stato dell'ordinazione bar.
     *
     * @return lo stato dell'ordinazione bar
     */
    StatusOrdinazioneBar getStatusOrdinazioneBar();

    /**
     * Imposta lo status dell'ordinazione bar.
     *
     * @param statusOrdinazioneBar il nuovo status dell'ordinazione bar
     * @throws NullPointerException se lo status &egrave; nullo
     */
    void setStatusOrdinazioneBar(StatusOrdinazioneBar statusOrdinazioneBar);

}

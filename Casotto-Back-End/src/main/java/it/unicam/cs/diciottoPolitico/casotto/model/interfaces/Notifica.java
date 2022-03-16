package it.unicam.cs.diciottoPolitico.casotto.model.interfaces;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Interfaccia che descrive una notifica
 */
public interface Notifica {

   /**
    * Ottieni l'identificativo della notifica
    * @return l'identificativo della notifica
    */
   UUID getId();

   /**
    * Ottieni il messaggio della notifica
    * @return il messaggio della notifica
    */
   String getMessaggio();

   /**
    * Ritorna la lista di utenti della notifica.
    *
    * @return la lista di utenti della notifica
    */
   List<SimpleUtente> getUtenti();
}

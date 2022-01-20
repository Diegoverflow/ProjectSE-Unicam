package it.unicam.cs.diciottoPolitico.casotto.entity;

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
}

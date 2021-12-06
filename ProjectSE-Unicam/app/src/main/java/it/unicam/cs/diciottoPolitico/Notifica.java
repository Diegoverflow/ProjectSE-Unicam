package it.unicam.cs.diciottoPolitico;

/**
 * Interfaccia che descrive una notifica
 */
public interface Notifica {

   /**
    * Ottieni l'identificativo della notifica
    * @return l'identificativo della notifica
    */
   long getId();

   /**
    * Ottieni il messaggio della notifica
    * @return il messaggio della notifica
    */
   String getMessaggio();
}

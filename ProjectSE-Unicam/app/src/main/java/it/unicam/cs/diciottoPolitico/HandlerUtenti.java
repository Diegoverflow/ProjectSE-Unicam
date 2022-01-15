package it.unicam.cs.diciottoPolitico;

import java.util.List;

public interface HandlerUtenti {

    // TODO: 15/01/22   il vpp ha le liste parametrizzate con CLIENTE CASSIERE ETC
            

    List getClienti();

    List getPersonaleBar();

    List getCassieri();

    List getGestori();

    boolean creaCliente( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    boolean creaPersonaleBar( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    boolean creaCassiere( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    boolean creaGestore( String nome,
                         String cognome,
                         String password,
                         String cellulare,
                         String email);

    boolean eliminaUtente (long codice);

    boolean autenticarsi (String email, String password);
    

}

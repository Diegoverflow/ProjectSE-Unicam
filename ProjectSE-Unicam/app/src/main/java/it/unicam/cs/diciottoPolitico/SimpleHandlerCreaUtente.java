package it.unicam.cs.diciottoPolitico;

import java.util.Objects;
import java.util.Scanner;

/**
 * Implementazione di un semplice gestore per la creazione di un utente.
 * Questo gestore interroga il database nel quale sono memorizzati tutti gli utenti e , se l' utente che si desidera creare non &egrave; gi&agrave; presente nel sistema,
 * lo aggiunge al database.
 *
 * @see DatabaseManager
 */
public class SimpleHandlerCreaUtente implements HandlerCreaUtente {

    private final DatabaseManager dbManager;

    public SimpleHandlerCreaUtente(DatabaseManager databaseManager) {
        this.dbManager = databaseManager;
    }

    @Override
    public boolean creaUtente(TipologiaUtente tipologia, UtenteLoggato utente) {
        Objects.requireNonNull(tipologia, "Tipologia null!");
        Objects.requireNonNull(utente, "Utente null!");
        // TODO: verificaDati non si può fare qui se gli passiamo l' utente...quiundi o gli passiamo tutti i dati singoli o bho
        return this.dbManager.addNuovoCliente(utente);
    }

    @Override
    public TipologiaUtente scegliTipologiaUtente(TipologiaUtente[] tipologie) {
        this.stampaTipologie(tipologie);
        int scelta = this.scegliTipologia(tipologie.length);
        return tipologie[scelta];
    }

    private void stampaTipologie(TipologiaUtente[] tipologie) {
        int i = 1;
        for (TipologiaUtente t : tipologie) {
            System.out.println(i + " " + tipologie[i]);
            i++;
        }
    }

    private int scegliTipologia(int numTipologie) {
        int scelta = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Inserire n. tipologia da selezionare (1-" + numTipologie + ")");
            scelta = scanner.nextInt();
        } while (scelta < 1 || scelta > numTipologie);
        return scelta;
    }


}

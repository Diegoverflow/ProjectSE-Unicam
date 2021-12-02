package it.unicam.cs.diciottoPolitico;

import java.util.LinkedList;
import java.util.List;

public class SimpleCliente implements Cliente{

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private String numero;
    private final List<Prenotazione> prenotazioni;

    public SimpleCliente(String codiceFiscale, String nome, String cognome, String numero) {
        if (codiceFiscale == null || nome == null || cognome == null || numero == null)
            throw new NullPointerException("Inserire dei dati non nulli");
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.prenotazioni = new LinkedList<>();
    }

    public SimpleCliente(String nome, String cognome, String numero) {
        if (nome == null || cognome == null || numero == null)
            throw new NullPointerException("Inserire dei dati non nulli");
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.prenotazioni = new LinkedList<>();
    }

    @Override
    public String getCodiceFiscale() {
        return this.codiceFiscale;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCognome() {
        return this.cognome;
    }

    @Override
    public String getNumero() {
        return this.numero;
    }

    @Override
    public boolean addPrenotazione(Prenotazione prenotazione) {
        return this.prenotazioni.add(prenotazione);
    }

    @Override
    public void setNumero(String numero) {
        if (numero == null)
            throw new NullPointerException("Inserire un numero non nullo");
        this.numero = numero;
    }

    @Override
    public void setCognome(String cognome) {
        if (cognome == null)
            throw new NullPointerException("Inserire un cognome non nullo");
        this.cognome = cognome;
    }

    @Override
    public void setNome(String nome) {
        if (nome == null)
            throw new NullPointerException("Inserire un nome non nullo");
        this.nome = nome;
    }
}

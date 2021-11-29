package it.unicam.cs.diciottoPolitico;

//TODO inserire le API
public interface Cliente {
    String getCodiceFiscale();
    String getNome();
    String getCognome();
    String getNumero();
    void setNome(String nome);
    void setCognome(String cognome);
    void setNumero(String numero);
    boolean addPrenotazione(Prenotazione prenotazione);
}

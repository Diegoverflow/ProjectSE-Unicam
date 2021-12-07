package it.unicam.cs.diciottoPolitico;

import java.util.List;

/**
 * Semplice implementazione dell'interfaccia HandlerVisualizzaPropriAcquisti.
 */
public class SimpleHandlerVisualizzaPropriAcquisti implements HandlerVisualizzaPropriAcquisti {

    @Override
    public String getAcquisti(Cliente cliente) {
        StringBuilder messaggio = new StringBuilder();
        cliente.getPrenotazioniOmbrelloni().stream().sequential().forEach(p -> getAcquisti(p,messaggio));
        cliente.getPrenotazioniAttivita().stream().sequential().forEach(p -> getAcquisti(p,messaggio));
        return messaggio.toString();
    }

    private void getAcquisti(PrenotazioneOmbrellone prenotazioneOmbrellone,StringBuilder messaggio){
        messaggio.append("id prenotazione: ").append(prenotazioneOmbrellone.getId());
        messaggio.append(" ").append("id ombrellone: ").append(prenotazioneOmbrellone.getOmbrellone().getId());
        messaggio.append(" ").append("data acquisto: ").append(prenotazioneOmbrellone.getDataAcquisto().toString());
        messaggio.append(" ").append("data prenotazione: ").append(prenotazioneOmbrellone.getDataPrenotazione().toString()).append(" ");
        messaggio.append(" ").append(prenotazioneOmbrellone.getFasciaOraria());
        messaggio.append(" ").append(prenotazioneOmbrellone.getCosto());
        messaggio.append(" ").append(prenotazioneOmbrellone.getStatoPagamento());
        messaggio.append("\n");
    }
    private void getAcquisti(PrenotazioneAttivita prenotazioneAttivita,StringBuilder messaggio){
        messaggio.append("id prenotazione: ").append(prenotazioneAttivita.getId());
        messaggio.append(" ").append("id attivita': ").append(prenotazioneAttivita.getAttivita().getId());
        messaggio.append(" ").append("data acquisto: ").append(prenotazioneAttivita.getDataAcquisto().toString());
        messaggio.append(" ").append("inizio: ").append(prenotazioneAttivita.getAttivita().getDataOrarioInizio().toString());
        messaggio.append(" ").append("fine: ").append(prenotazioneAttivita.getAttivita().getDataOrarioFine().toString());
        messaggio.append(" ").append("posti occupati: ").append(prenotazioneAttivita.getAttivita().getPostiOccupati());
        messaggio.append(" ").append("posti totali: ").append(prenotazioneAttivita.getAttivita().getPostiTotali());
        messaggio.append(" ").append("descrizione: ").append(prenotazioneAttivita.getAttivita().getDescrizione());
        messaggio.append(" ").append(prenotazioneAttivita.getCosto());
        messaggio.append(" ").append(prenotazioneAttivita.getStatoPagamento());
        messaggio.append("\n");
    }

    /*todo
    private void getAcquisti(List<OrdinazioneBar> ordinazioniBar,StringBuilder messaggio){
        for (PrenotazioneOmbrellone prenotazione: ordinazioniBar) {
            messaggio.append(prenotazione.getOmbrellone().getId());
            messaggio.append(" ").append(prenotazione.getDataPrenotazione().toString());
            messaggio.append(" ").append(prenotazione.getFasciaOraria());
            messaggio.append(" ").append(prenotazione.getCosto());
            messaggio.append(" ").append(prenotazione.getStatoPagamento());
            messaggio.append("\n");
        }
    }*/
}

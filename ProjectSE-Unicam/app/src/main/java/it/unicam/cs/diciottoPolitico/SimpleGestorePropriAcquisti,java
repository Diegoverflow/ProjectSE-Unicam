package it.unicam.cs.diciottoPolitico;

public class SimpleGestorePropriAcquisti implements GestoreVisualizzaPropriAcquisti {

    @Override
    public String getAcquisti(Cliente cliente) {
        StringBuilder prenotazioni = new StringBuilder();
        for (Prenotazione prenotazione: cliente.getPrenotazioni()) {
            prenotazioni.append(prenotazione.getDataPrenotazione().toString());
            prenotazioni.append(" ").append(prenotazione.getFasciaOraria());
            prenotazioni.append(" ").append(prenotazione.getCosto());
            prenotazioni.append(" ").append(prenotazione.getOmbrellone().getId());
        }
        return prenotazioni.toString();
    }
}

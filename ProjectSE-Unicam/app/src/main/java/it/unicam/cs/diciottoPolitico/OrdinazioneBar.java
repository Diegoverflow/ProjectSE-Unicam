package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

public interface OrdinazioneBar {
    long getId();
    GregorianCalendar getDataAcquisto();
    double getCosto();
    boolean isConsegnato();
    boolean isPagato();
    boolean isPresoInCarico();
    void setPagato(boolean b);
    void setConsegnato(boolean b);
    void setPresoInCarico(boolean b);
}

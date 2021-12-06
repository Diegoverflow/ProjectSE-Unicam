package it.unicam.cs.diciottoPolitico;

import java.util.GregorianCalendar;

//todo api
public class SimpleOrdinazioneBar implements OrdinazioneBar{
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public GregorianCalendar getDataAcquisto() {
        return null;
    }

    @Override
    public double getCosto() {
        return 0;
    }

    @Override
    public boolean isConsegnato() {
        return false;
    }

    @Override
    public boolean isPagato() {
        return false;
    }

    @Override
    public boolean isPresoInCarico() {
        return false;
    }

    @Override
    public void setPagato(boolean b) {

    }

    @Override
    public void setConsegnato(boolean b) {

    }

    @Override
    public void setPresoInCarico(boolean b) {

    }
}

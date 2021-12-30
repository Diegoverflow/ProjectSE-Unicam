package it.unicam.cs.diciottoPolitico;

/**
 * Classe Singleton
 */
public class SimpleHandlerNotifica implements HandlerNotifica{

    private static final SimpleHandlerNotifica instance = new SimpleHandlerNotifica();

    private SimpleHandlerNotifica(){}

    public static SimpleHandlerNotifica getInstance() {
        return instance;
    }

    @Override
    public void notifica(Notifica notifica, UtenteLoggato utenteLoggato) {
        utenteLoggato.addNotifica(notifica);
    }
}

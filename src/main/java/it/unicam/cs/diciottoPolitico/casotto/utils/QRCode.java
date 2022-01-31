package it.unicam.cs.diciottoPolitico.casotto.utils;


/**
 * QRCode che rappresenta una stringa.
 * Si occupa di conservare al suo interno la stringa che rappresenta e l' array di byte,
 * ovvero i byte che equivalgono all' immagine del QRCode generato.
 */
public class QRCode {

    private String contenuto;
    private byte[] QRCodeImage;

    /**
     * Crea un {@code QRCode} con il contenuto, ovvero la stringa che questo dovr&agrav; rappresentare e il tipo di formato dell' immagine.
     *
     * @param contenuto la stringa che questo {@code QRCode} rappresenta
     * @param type      il tipo di formato dell' immagine generata
     */
    public QRCode(String contenuto, String type) {
        this.contenuto = contenuto;
        this.QRCodeImage = QRCodeGenerator.createQRCodeImage(this.contenuto, type);
    }

    /**
     * Restituisce la stringa rappresentata da questo {@code QRCode}.
     *
     * @return la stringa che questo {@code QRCode} rappresenta
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * Imposta il contenuto di questo {@code QRCode} con il tipo di formato specificato.
     * Viene rigenerato in automatico l' array di byte rappresentante l' immagine in base al contenuto specificato.
     *
     * @param contenuto la stringa che questo {@code QRCode} rappresenta
     * @param type      il tipo di formato dell' immagine generata
     */
    public void setContenuto(String contenuto, String type) {
        this.contenuto = contenuto;
        this.QRCodeImage = QRCodeGenerator.createQRCodeImage(this.contenuto, type);
    }

    /**
     * Restituisce l' array di byte rappresentante l' immagine del {@code QRCode} generato.
     *
     * @return l' array di byte rappresentante l' immagine del {@code QRCode} generato
     */
    public byte[] getQRCodeImage() {
        return QRCodeImage;
    }

}

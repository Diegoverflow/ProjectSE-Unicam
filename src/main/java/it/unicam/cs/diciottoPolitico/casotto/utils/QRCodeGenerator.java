package it.unicam.cs.diciottoPolitico.casotto.utils;

import com.google.zxing.*;
import com.google.zxing.Reader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Hashtable;


/**
 * Rappresenta un generatore di QRCode.
 * Si occupa generare un QRCode che rappresenta una stringa.
 */
public final class QRCodeGenerator {

    /**
     * Genera il QRCode che rappresenta la stringa specificata e salva il QRCode in un' immagine avente
     * come formato il tipo specificato.
     *
     * @param s         la stringa che il QRCode generate rappresenter&agrave;
     * @param type_file il formato del QRCode generato
     * @return il QRCode generato sotto forma di array di byte se il QRCode viene generato con successo,
     * altrimenti un array di byte vuoto
     */
    public static RenderedImage createQRCode(String s, String type_file) {
        RenderedImage image=null;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            image = setQRCodeSize(s, 500, 500);
            ImageIO.write(image, type_file, bytes);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static RenderedImage setQRCodeSize(String s, int width, int height) throws WriterException {
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(s, BarcodeFormat.QR_CODE, width, height, hintMap);
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < matrixWidth; i++)
            for (int j = 0; j < matrixWidth; j++)
                if (byteMatrix.get(i, j))
                    graphics.fillRect(i, j, 1, 1);
        return image;
    }

    /**
     * Restituisce la stringa rappresentata dal {@link QRCode} specificato.
     *
     * @param qrCode il {@code QRCode} di cui leggerne la stringa che rappresenta
     * @return la stringa rappresentata del {@code QRCode}
     * oppure {@code null} se il {@code QRCode} specificato non rappresenta una stringa valida
     */
   /* public static String readQRCode(QRCode qrCode) {
        Result result = null;
        try {
            ByteArrayInputStream bytes = new ByteArrayInputStream(qrCode.getQRCodeImage());
            BufferedImage QRCodeImage = ImageIO.read(bytes);
            LuminanceSource source = new BufferedImageLuminanceSource(QRCodeImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            result = reader.decode(bitmap);
        } catch (FormatException | NotFoundException | ChecksumException | IOException e) {
            e.printStackTrace();
        }
        return result != null ? result.getText() : null;
    }*/

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BarcodeGenerator {

    public static String generateProductBarcode() throws Exception {
        String query = "SELECT MAX(id) AS last_id FROM product";
        int nextId = 1;

        try (ResultSet rs = MYSQL.executeSearch(query)) {
            if (rs.next()) {
                nextId = rs.getInt("last_id") + 1;
            }
        }

        String prefix = "9";
        int totalLength = 12;

        int paddingLength = totalLength - prefix.length();

        String paddedId = String.format("%0" + paddingLength + "d", nextId);

        return prefix + paddedId;

    }

    public static String generateBarcode(String data) throws IOException {
        String filePath = null;
        try {           
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128, 300, 150);
            
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            
            String directoryPath = "barcodes/";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }           
            filePath = directoryPath + data + ".png";
            File outputFile = new File(filePath);            
            ImageIO.write(image, "png", outputFile);
            
            System.out.println("Barcode generated successfully: " + outputFile.getAbsolutePath());

        } catch (WriterException | IOException e) {
            e.printStackTrace();            
            System.err.println("Error generating barcode: " + e.getMessage());
        }
        
        return filePath;
    }

}

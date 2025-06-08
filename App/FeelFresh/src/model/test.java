
package model;

public class test {

    public static void main(String[] args) {
        try {
            String barcode = BarcodeGenerator.generateProductBarcode();
            System.out.println("Generated barcode: " + barcode);
            System.out.println(BarcodeGenerator.generateBarcode(barcode));
        } catch (Exception e) {
            e.printStackTrace();
        }                      
    }
}

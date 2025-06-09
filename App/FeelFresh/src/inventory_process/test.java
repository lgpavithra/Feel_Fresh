package inventory_process;

import model.dto.GrnDTO;
import model.dto.InvoiceDTO;
import model.dto.ProductDTO;
import inventory_process.inventory.InventoryManager;
import java.util.ArrayList;
import model.dto.DTOGenerator;
import inventory_process.inventory.InvoiceProcessor;

public class test {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(test.class);

    public static void main(String[] args) {
        InventoryManager manager = InventoryManager.getInstance();

        ProductDTO p1 = new ProductDTO();
        p1.setPid(1);
        p1.setSellingPrice(100);
        p1.setBuyingPrice(50);
        p1.setQty(2);
        p1.setExpDate("2025-12-31");

        ProductDTO p2 = new ProductDTO();
        p2.setPid(2);
        p2.setSellingPrice(200);
        p2.setBuyingPrice(100);
        p2.setQty(10);
        p2.setExpDate("2025-12-31");

        ArrayList<ProductDTO> productList = new ArrayList();
        productList.add(p1);
        productList.add(p2);

        DTOGenerator dTOGenerator = DTOGenerator.getInstance();

//      // grn creation
//        GrnDTO grnDTO = dTOGenerator.generateGrnDTO(productList, 1, 1000, 0, 1000, 0, 1);
//        if (grnDTO != null) {            
//            manager.addStocks(grnDTO);
//        } else {
//            System.out.println("Null is returned when creating grnDTO");
//        }
        // invoice creation
//        InvoiceDTO invoiceDTO = dTOGenerator.generateInvoiceDTO(productList, 1800, 1000, 0, "200312568946");
//        if (invoiceDTO != null) {
//            //manager.issueProducts(invoiceDTO);
//            new InvoiceProcessor().process(invoiceDTO);
//        } else {
//            System.out.println("Null is returned when creating invoice DTO");
//        }
//
//        // to load products (format:- product_name , category , brand_name)...
//        for (ProductDTO productDTO : manager.loadProducts()) {
//            System.out.println(productDTO.getPname());
//            System.out.println(productDTO.getCategoryName());
//            System.out.println(productDTO.getBrandName());
//        }       
        try {

            System.out.println(1 / 0);
        } catch (Exception e) {
            logger.error("EXCEPTION",e);
        }

    }
}

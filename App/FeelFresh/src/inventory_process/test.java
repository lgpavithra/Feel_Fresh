package inventory_process;

import inventory_process.dto.GrnDTO;
import inventory_process.dto.InvoiceDTO;
import inventory_process.dto.ProductDTO;
import inventory_process.inventory.InventoryManager;
import java.util.ArrayList;
import inventory_process.dto.DTOGenerator;
import inventory_process.inventory.Inventory;

public class test {

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

//        manager.issueProducts(dTO);
//        GrnDTO dTO = DTOGenerator.generateGrnDTO(productList, 1, 1000, 0, 1000, 0, 1);
//        if(dTO != null){
//            manager.addStocks(dTO);
//        }else{
//            System.out.println("Null is returned");
//        }
//        
//        InvoiceDTO dtO = DTOGenerator.generateInvoiceDTO(productList, 2000, 1000, 0, "08777377");
//        if(dtO != null){
//            manager.issueProducts(dtO);
//        }else{
//            System.out.println("Null is returned");
//        }

        DTOGenerator dTOGenerator = DTOGenerator.getInstance();
        
        //grn creation
        GrnDTO grnDTO = dTOGenerator.generateGrnDTO(productList, 1, 1000, 0, 1000, 0, 1);
        if(grnDTO != null){
            manager.addStocks(grnDTO);
        }else{
            System.out.println("Null is returned when creating grnDTO");
        }
         
        //invoice creation
        InvoiceDTO invoiceDTO = dTOGenerator.generateInvoiceDTO(productList, 1000, 1000, 0, "07855444");
        if(invoiceDTO != null){            
            manager.issueProducts(invoiceDTO);
        }else{
            System.out.println("Null is returned when creating invoice DTO");
        }
        
        System.out.println("this is inventory checking");
        
        //to load products (format:- product_name , category , brand_name)...
        for (ProductDTO productDTO : manager.loadProducts()) {
            System.out.println(productDTO.getPname());
            System.out.println(productDTO.getCategoryName());
            System.out.println(productDTO.getBrandName());            
        }
    }
}

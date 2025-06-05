package inventory_process.dto;

import inventory_process.dto.GrnDTO;
import inventory_process.dto.InvoiceDTO;
import inventory_process.dto.ProductDTO;
import java.util.ArrayList;

public class DTOGenerator {
    
    private DTOGenerator(){}
    
    private static DTOGenerator dTOGenerator;
    
    public static DTOGenerator getInstance(){
        if(dTOGenerator == null){
            dTOGenerator = new DTOGenerator();
        }
        return dTOGenerator;
    }

    public GrnDTO generateGrnDTO(ArrayList<ProductDTO> productList, int po_id, double total, double discount, double paid, double outstanding, int supplier_id) {
        if (total == 0) {
            System.out.println("Please enter a valid amount for total");
            return null;
        } else if (productList.isEmpty()) {
            System.out.println("add Products");
            return null;
        } else if (paid == 0) {
            System.out.println("Please enter a valid paid amount");
            return null;
        } else {
            GrnDTO dTO = new GrnDTO();
            dTO.setProductList(productList);
            dTO.setPo_id(po_id);
            dTO.setTotal(total);
            dTO.setDiscount(discount);
            dTO.setPaid(paid);
            dTO.setOutstanding(outstanding);
            dTO.setSupplier_id(supplier_id);
            return dTO;
        }
    }

    public InvoiceDTO generateInvoiceDTO(ArrayList<ProductDTO> productList, double total, double paid, double discount, String mobile) {
        //productList,total,paid,discount,mobile
        if (productList.isEmpty()) {
            System.out.println("Please add products");
            return null;
        } else if (total == 0) {
            System.out.println("Please enter a valid total amount");
            return null;
        } else if (paid == 0) {
            System.out.println("Please enter a valid amount to the paid value");
            return null;
        } else if (mobile.isBlank()) {
            System.out.println("Please enter a mobile number");
            return null;
        } else {
            InvoiceDTO dTO = new InvoiceDTO();
            dTO.setMobile(mobile);
            dTO.setTotal(total);
            dTO.setDiscount(discount);
            dTO.setPaid(paid);
            dTO.setProductList(productList);
            return dTO;
        }
    }
}

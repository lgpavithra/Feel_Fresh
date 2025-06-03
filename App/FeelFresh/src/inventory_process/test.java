package inventory_process;

import inventory_process.dto.GrnDTO;
import inventory_process.dto.InvoiceDTO;
import inventory_process.dto.ProductDTO;
import inventory_process.inventory.InventoryManager;
import java.util.ArrayList;

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
        
        InvoiceDTO dTO = new InvoiceDTO();
        dTO.setMobile("0784544285");
        dTO.setTotal(1000);
        dTO.setDiscount(100);
        dTO.setPaid(200);
        dTO.setProductList(productList);
        
        manager.issueProducts(dTO);
        
    }
}

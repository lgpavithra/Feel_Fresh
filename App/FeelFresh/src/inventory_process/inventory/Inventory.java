package inventory_process.inventory;

import java.util.ArrayList;
import model.dto.ProductDTO;
import java.sql.ResultSet;
import model.MYSQL;

public class Inventory {

    private Inventory(){
        productList = new ArrayList();
    }
    
    private static Inventory inventory;
    private ArrayList<ProductDTO> productList = new ArrayList();

    public static Inventory getInstance() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    public ArrayList<ProductDTO> getProductList() {
        return productList;
    }            
}

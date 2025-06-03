package inventory_process.inventory;

import java.util.ArrayList;
import inventory_process.dto.ProductDTO;

public class Inventory {

    private static Inventory inventory;
    private static ArrayList<ProductDTO> productList;
       
    public static Inventory getInstance(){
        if(inventory == null){
           inventory = new Inventory();
        }
        return inventory;
    }
    
    public void loadProducts() {
        
    }
    
    public void updateStockLevels() {
        
    }
    
}

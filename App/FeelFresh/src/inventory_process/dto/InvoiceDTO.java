package inventory_process.dto;

import java.util.ArrayList;

public class InvoiceDTO {
    private ArrayList<ProductDTO> productList;
    private String mobile;
    private double total;    
    private double discount;    
    private double paid;    
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public double getPaid() {
        return paid;
    }
   
    public void setPaid(double paid) {
        this.paid = paid;
    }
  
    public ArrayList<ProductDTO> getProductList() {
        return productList;
    }
    
    public void setProductList(ArrayList<ProductDTO> productList) {
        this.productList = productList;
    }
}

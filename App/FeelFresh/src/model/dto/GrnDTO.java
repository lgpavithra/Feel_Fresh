package model.dto;

import java.util.ArrayList;

public class GrnDTO {

    private ArrayList<ProductDTO> productList;
    
    private int po_id;
    private double total;
    private double discount;
    private double outstanding;
    private double paid;
    private int supplier_id;

    public ArrayList<ProductDTO> getProductList() {
        return productList;
    }
   
    public void setProductList(ArrayList<ProductDTO> productList) {
        this.productList = productList;
    }
    
    public int getPo_id() {
        return po_id;
    }

    public void setPo_id(int po_id) {
        this.po_id = po_id;
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
    
    public double getOutstanding() {
        return outstanding;
    }
    
    public void setOutstanding(double outstanding) {
        this.outstanding = outstanding;
    }
   
    public double getPaid() {
        return paid;
    }
    
    public void setPaid(double paid) {
        this.paid = paid;
    }
    
    public int getSupplier_id() {
        return supplier_id;
    }
    
    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
        
}

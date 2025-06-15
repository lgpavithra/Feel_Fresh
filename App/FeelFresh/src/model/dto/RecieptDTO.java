package model.dto;

import java.util.ArrayList;

public class RecieptDTO {

    private ArrayList<ProductDTO> productList;
    private String nic;
    private double total;
    private double discount;
    private double paid;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

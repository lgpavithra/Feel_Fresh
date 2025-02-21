/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author senad
 */
public class GRNProduct {
    private String productName;
    private int quantity;
    private double buyingPrice;
    private double sellingPrice;
    private double subtotal;

    public GRNProduct(String productName, int quantity, double buyingPrice, double sellingPrice, double subtotal) {
        this.productName = productName;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.subtotal = subtotal;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }
}


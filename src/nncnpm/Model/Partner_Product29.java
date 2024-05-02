package nncnpm.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Partner_Product29 {
    private int id;
    private int partnerId; // Đối tác ID
    private int productId; // Sản phẩm ID
    private float interestRate; // Lãi suất

    // Constructors, getters, and setters
    public Partner_Product29(int id, int partnerId, int productId, float interestRate) {
        this.id = id;
        this.partnerId = partnerId;
        this.productId = productId;
        this.interestRate = interestRate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nncnpm.Model;

/**
 *
 * @author hoang
 */
public class Contract_Partner_Product29 {
    private int id;
    private int quantity;
    private int contractId;
    private int partnerProductId;
    private float productPrice;

    // Constructor
    public Contract_Partner_Product29(int id, int quantity, int contractId, int partnerProductId, float productPrice) {
        this.id = id;
        this.quantity = quantity;
        this.contractId = contractId;
        this.partnerProductId = partnerProductId;
        this.productPrice = productPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getPartnerProductId() {
        return partnerProductId;
    }

    public void setPartnerProductId(int partnerProductId) {
        this.partnerProductId = partnerProductId;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}


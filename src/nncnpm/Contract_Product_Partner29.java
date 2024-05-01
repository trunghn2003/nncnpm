package nncnpm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Contract_Product_Partner29 {
    private int id;
    private int quantity;
    private float productPrice;
    private Partner_Product29 partnerProduct; // Thay vì danh sách, giờ là một đối tượng duy nhất
    private boolean contractStatus;

    // Constructors
    public Contract_Product_Partner29(int id, int quantity, float productPrice, Partner_Product29 partnerProduct, boolean contractStatus) {
        this.id = id;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.partnerProduct = partnerProduct;
        this.contractStatus = contractStatus;
    }

    // Getters and setters
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

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public Partner_Product29 getPartnerProduct() {
        return partnerProduct;
    }

    public void setPartnerProduct(Partner_Product29 partnerProduct) {
        this.partnerProduct = partnerProduct;
    }

    public boolean isContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(boolean contractStatus) {
        this.contractStatus = contractStatus;
    }
}

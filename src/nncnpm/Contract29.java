/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nncnpm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class Contract29 {
    private int contractId;
    private String name;
    private float totalPrice;
    private int totalQuantity;
    private String signingDate;  // Consider using LocalDate or Date
    private int loanPeriod;
    private List<Contract_Product_Partner29> contractProductPartners;

    // Constructors, getters, and setters
    public Contract29() {}

    public Contract29(int contractId, String name, float totalPrice, int totalQuantity, String signingDate, int loanPeriod) {
        this.contractId = contractId;
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.signingDate = signingDate;
        this.loanPeriod = loanPeriod;
        this.contractProductPartners = new ArrayList<>();
    }

    // Getters and setters
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(String signingDate) {
        this.signingDate = signingDate;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public List<Contract_Product_Partner29> getContractProductPartners() {
        return contractProductPartners;
    }

    public void setContractProductPartners(List<Contract_Product_Partner29> contractProductPartners) {
        this.contractProductPartners = contractProductPartners;
    }
}


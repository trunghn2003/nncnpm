package nncnpm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Invoice_Customer29 {
    private int id;
    private int contractId;
    private boolean status;
    private String paymentDate;  // Consider using LocalDate or Date
    private float totalPayment;
    private float totalOutstanding;

    // Constructors
    public Invoice_Customer29(int id, int contractId, boolean status, String paymentDate, float totalPayment, float totalOutstanding) {
        this.id = id;
        this.contractId = contractId;
        this.status = status;
        this.paymentDate = paymentDate;
        this.totalPayment = totalPayment;
        this.totalOutstanding = totalOutstanding;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }

    public float getTotalOutstanding() {
        return totalOutstanding;
    }

    public void setTotalOutstanding(float totalOutstanding) {
        this.totalOutstanding = totalOutstanding;
    }
}


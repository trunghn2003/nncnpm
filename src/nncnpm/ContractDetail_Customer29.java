package nncnpm;

import java.util.List;

public class ContractDetail_Customer29 extends Contract29 {
    private String customerName;  // Customer name associated with the contract
    private String partnerName;   // Partner name associated with the contract
    private List<ProductDetail> productDetails;  // List of products linked via partners
    private List<Invoice_Customer29> invoices;
     public ContractDetail_Customer29(int contractId, String name, float totalPrice, int totalQuantity,
                                     String signingDate, int loanPeriod, String customerName, String partnerName,
                                     List<ProductDetail> productDetails, List<Invoice_Customer29> invoices) {
        super(contractId, name, totalPrice, totalQuantity, signingDate, loanPeriod);
        this.customerName = customerName;
        this.partnerName = partnerName;
        this.productDetails = productDetails;
        this.invoices = invoices;
    }
    // Getters and Setters for the new properties
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public List<Invoice_Customer29> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice_Customer29> invoices) {
        this.invoices = invoices;
    }
    

    
}

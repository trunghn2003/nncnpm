package nncnpm;

/**
 * Class representing detailed information about a customer's contract.
 */
public class ContractDetail_Customer29 {
    private int contractId;
    private String name;
    private float totalPrice;
    private int totalQuantity;
    private String signingDate;
    private int loanPeriod;

    // Constructor
    public ContractDetail_Customer29(int contractId, String name, float totalPrice, int totalQuantity,
                                     String signingDate, int loanPeriod) {
        this.contractId = contractId;
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.signingDate = signingDate;
        this.loanPeriod = loanPeriod;
    }

    // Getters
    public int getContractId() {
        return contractId;
    }

    public String getName() {
        return name;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public String getSigningDate() {
        return signingDate;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    // Setters
    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setSigningDate(String signingDate) {
        this.signingDate = signingDate;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
}

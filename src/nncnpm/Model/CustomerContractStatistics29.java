package nncnpm.Model;

/**
 * Extends Contract29 to include financial details specific to customer views.
 */
public class CustomerContractStatistics29 extends Contract29 {
    private float totalOverdueDebt;
    private float totalOutstanding;

    /**
     * Constructs a CustomerContractStatistics29 with detailed financial information.
     *
     * @param contractId The unique identifier of the contract.
     * @param name The name of the contract.
     * @param totalPrice The total price associated with the contract.
     * @param totalQuantity The total quantity of items or services under the contract.
     * @param signingDate The date the contract was signed.
     * @param loanPeriod The period over which the loan or contract is spread, in months.
     * @param totalOutstanding The total outstanding debt associated with the contract.
     * @param totalOverdueDebt The total overdue debt associated with the contract.
     */
    public CustomerContractStatistics29(int contractId, String name, float totalPrice, int totalQuantity, String signingDate, int loanPeriod, float totalOutstanding, float totalOverdueDebt) {
        super(contractId, name, totalPrice, totalQuantity, signingDate, loanPeriod);
        this.totalOutstanding = totalOutstanding;
        this.totalOverdueDebt = totalOverdueDebt;
    }

    // Getters and Setters for the additional fields
    public float getTotalOutstanding() {
        return totalOutstanding;
    }

    public void setTotalOutstanding(float totalOutstanding) {
        this.totalOutstanding = totalOutstanding;
    }

    public float getTotalOverdueDebt() {
        return totalOverdueDebt;
    }

    public void setTotalOverdueDebt(float totalOverdueDebt) {
        this.totalOverdueDebt = totalOverdueDebt;
    }
}

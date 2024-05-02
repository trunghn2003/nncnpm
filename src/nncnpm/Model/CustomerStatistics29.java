/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nncnpm.Model;

/**
 *
 * @author hoang
 */
public class CustomerStatistics29 extends Customer29 {
    private float totalOutstandingDebt;
    private float totalOverdueDebt;

    public CustomerStatistics29(int customerId, String customerName, String address, String phoneNumber, float totalOutstandingDebt, float totalOverdueDebt) {
        super(customerId, customerName, address, phoneNumber);
        this.totalOutstandingDebt = totalOutstandingDebt;
        this.totalOverdueDebt = totalOverdueDebt;
    }

    // Getters and Setters
    public float getTotalOutstandingDebt() {
        return totalOutstandingDebt;
    }

    public void setTotalOutstandingDebt(float totalOutstandingDebt) {
        this.totalOutstandingDebt = totalOutstandingDebt;
    }

    public float getTotalOverdueDebt() {
        return totalOverdueDebt;
    }

    public void setTotalOverdueDebt(float totalOverdueDebt) {
        this.totalOverdueDebt = totalOverdueDebt;
    }
}


package nncnpm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 * JFrame to display customer contract statistics in a table.
 */
public class CustomerContractsFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private StatisticsDAO29 statisticsDAO;  //
    /**
     * Initializes the frame for displaying customer contract statistics.
     *
     * @param contracts A list of CustomerContractStatistics29 representing contract details.
     */
    public CustomerContractsFrame(List<CustomerContractStatistics29> contracts, StatisticsDAO29 statisticsDAO) {
        this.statisticsDAO = statisticsDAO; 
    setTitle("Customer Contracts");
    setSize(800, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout());

    initializeTable();
    populateTable(contracts);
    add(new JScrollPane(table), BorderLayout.CENTER);

    // Tạo nút "View Details"
    JButton btnViewDetails = new JButton("View Details");
    btnViewDetails.addActionListener(e -> viewDetails());
    add(btnViewDetails, BorderLayout.SOUTH);
}


    /**
     * Initializes the table with predefined column names.
     */
    private void initializeTable() {
        String[] columnNames = {
            "Contract ID", "Signing Date", "Total Loan", "Total Payments",
            "Total Outstanding", "Total Overdue"
        };
        tableModel = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make table cells non-editable
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);  // Enable automatic sorting.
    }
    

    /**
     * Populates the table with contract data.
     *
     * @param contracts A list of CustomerContractStatistics29 objects to be displayed.
     */
    private void populateTable(List<CustomerContractStatistics29> contracts) {
        for (CustomerContractStatistics29 contract : contracts) {
            Object[] rowData = {
                contract.getContractId(),
                contract.getSigningDate(),
                contract.getTotalPrice(),  // Represents the total loan amount.
                contract.getTotalQuantity(),  // Represents the total number of payments made.
                contract.getTotalOutstanding(),
                contract.getTotalOverdueDebt()  // Represents the total amount overdue.
            };
            tableModel.addRow(rowData);
        }
    }
    private void viewDetails() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int contractId = (int) tableModel.getValueAt(selectedRow, 0);
            ContractDetail_Customer29 contractDetail = statisticsDAO.getDetailContract(contractId);
            if (contractDetail != null) {
                JFrame detailsFrame = new ContractDetailsFrame(contractDetail);
                detailsFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No details available for the selected contract.", "Detail Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contract to view details.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }
}

//private ContractDetail_Customer29 fetchContractDetails(int contractId) {
//    // Code để lấy chi tiết hợp đồng từ cơ sở dữ liệu hoặc một nguồn khác
//    return new ContractDetail_Customer29(); // Trả
//
//}

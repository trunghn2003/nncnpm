package nncnpm.View;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nncnpm.DAO.DatabaseConnector;
import nncnpm.DAO.StatisticsDAO29;
import nncnpm.Model.*;


public class GDCustomerStatistics29 extends JFrame {
    private StatisticsDAO29 statisticsDAO;
    private JTable table;
    private DefaultTableModel tableModel;

    private void viewCustomerDetails() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow >= 0) {
        int customerId = (int) tableModel.getValueAt(selectedRow, 0);
        Customer29 customer = new Customer29(customerId, "", "", "");  // Giả định cấu trúc của Customer29
        List<CustomerContractStatistics29> contracts = statisticsDAO.getListContract(customer);

        if(contracts == null) {
                   JOptionPane.showMessageDialog(this, "khách hàng không có hợp đồng nào", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        }
        EventQueue.invokeLater(() -> {
            GDCustomerContractStatistics29 contractsFrame = new GDCustomerContractStatistics29(contracts, statisticsDAO );
            contractsFrame.setVisible(true);
        });
    }
}

    public GDCustomerStatistics29(StatisticsDAO29 statisticsDAO) {
        this.statisticsDAO = statisticsDAO;
        initializeUI();
    }
    

    private void initializeUI() {
        setTitle("Thống Kê Khách Hàng Theo Dư nợ");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();
       tableModel.setColumnIdentifiers(new String[]{
    "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Tổng Nợ Còn Lại", "Tổng Nợ Quá Hạn"
});

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Load data
        loadData();

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnDetails = new JButton("Xem Chi Tiết");
        btnDetails.addActionListener(e -> viewCustomerDetails());
        add(btnDetails, BorderLayout.SOUTH);
    }

    private void loadData() {
    List<CustomerStatistics29> customerStats = statisticsDAO.getListCustomer();
//    List<CustomerStatistics29> customerStats = new ArrayList<>();

     if (customerStats.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không có khách hàng nào", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
    double totalOutstandingDebt = 0.0;
    double totalOverdueDebt = 0.0;

    for (CustomerStatistics29 stats : customerStats) {
        double outstandingDebt = stats.getTotalOutstandingDebt();
        double overdueDebt = stats.getTotalOverdueDebt();
        totalOutstandingDebt += outstandingDebt;
        totalOverdueDebt += overdueDebt;

        tableModel.addRow(new Object[]{
            stats.getCustomerId(),
            stats.getCustomerName(),
            stats.getPhoneNumber(),  // Thêm số điện thoại vào bảng
            outstandingDebt,
            overdueDebt
        });
    }

    // Adding a summary row
    tableModel.addRow(new Object[]{
        "", // Empty for customer id
        "Tổng", // 'Total' text in the name column
        "", // Empty for phone number
        totalOutstandingDebt,
        totalOverdueDebt
    });
}



    

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseConnector.getConnection(); // Initialize your database connection here
        } catch (SQLException ex) {
            Logger.getLogger(GDCustomerStatistics29.class.getName()).log(Level.SEVERE, null, ex);
        }
        StatisticsDAO29 dao = new StatisticsDAO29(connection);
        EventQueue.invokeLater(() -> {
            GDCustomerStatistics29 frame = new GDCustomerStatistics29(dao);
            frame.setVisible(true);
        });
    }
}

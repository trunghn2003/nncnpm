package nncnpm;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDebtStatisticsFrame extends JFrame {
    private StatisticsDAO29 statisticsDAO;
    private JTable table;
    private DefaultTableModel tableModel;

    private void viewCustomerDetails() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow >= 0) {
        int customerId = (int) tableModel.getValueAt(selectedRow, 0);
        Customer29 customer = new Customer29(customerId, "", "", "");  // Giả định cấu trúc của Customer29
        List<CustomerContractStatistics29> contracts = statisticsDAO.getListContract(customer);

        EventQueue.invokeLater(() -> {
            CustomerContractsFrame contractsFrame = new CustomerContractsFrame(contracts, statisticsDAO );
            contractsFrame.setVisible(true);
        });
    }
}

    public CustomerDebtStatisticsFrame(StatisticsDAO29 statisticsDAO) {
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
    for (CustomerStatistics29 stats : customerStats) {
        tableModel.addRow(new Object[]{
            stats.getCustomerId(),
            stats.getCustomerName(),
            stats.getPhoneNumber(),  // Thêm số điện thoại vào bảng
            stats.getTotalOutstandingDebt(),
            stats.getTotalOverdueDebt()
        });
    }
}


    

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseConnector.getConnection(); // Initialize your database connection here
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDebtStatisticsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        StatisticsDAO29 dao = new StatisticsDAO29(connection);
         System.out.println("d");
        EventQueue.invokeLater(() -> {
            CustomerDebtStatisticsFrame frame = new CustomerDebtStatisticsFrame(dao);
            frame.setVisible(true);
            System.out.println("d");
        });
    }
}

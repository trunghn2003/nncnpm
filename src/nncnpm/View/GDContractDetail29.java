package nncnpm.View;
import java.awt.*;
import javax.swing.*;
import nncnpm.Model.ContractDetail_Customer29;
import nncnpm.Model.Contract_Partner_Product29;

public class GDContractDetail29 extends JFrame {

    public GDContractDetail29(ContractDetail_Customer29 contractDetail) {
        // Setting up the frame
        setTitle("Chi Tiết Hợp Đồng ID: " + contractDetail.getContractId());
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Header label
        JLabel headerLabel = new JLabel("<html><b>Xem Chi Tiết Hợp Đồng ID:</b> " + contractDetail.getContractId() + "</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel, gbc);

        // Add contract and partner details
        addComponent("Tên Hợp Đồng:", contractDetail.getName(), gbc);
        addComponent("Tổng Giá:", String.format("$%.2f", contractDetail.getTotalPrice()), gbc);
        addComponent("Tổng Số Lượng:", String.valueOf(contractDetail.getTotalQuantity()), gbc);
        addComponent("Ngày Ký:", contractDetail.getSigningDate(), gbc);
        addComponent("Thời Hạn Vay (tháng):", String.valueOf(contractDetail.getLoanPeriod()), gbc);
        addLabelComponent("Tên Khách Hàng:", contractDetail.getCustomerName(), "Tên Đối Tác:", contractDetail.getPartnerName(), gbc);

        // Product Section
        JLabel productsLabel = new JLabel("Danh Sách Sản Phẩm:");
        productsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(productsLabel, gbc);

        double totalProductPrice = 0.0;
        int totalProductQuantity = 0;
        for (Contract_Partner_Product29 product : contractDetail.getContractPartnerProducts()) {
            addProductComponent("Sản phẩm:", "ID: " + product.getId() + ", Số lượng: " + product.getQuantity() + ", Giá: $" + product.getProductPrice(), gbc);
            totalProductPrice += product.getProductPrice();
            totalProductQuantity += product.getQuantity();
        }

        // Summary row for products
        JLabel productSummaryLabel = new JLabel(String.format("<html><b>Tổng Số Lượng:</b> %d, <b>Tổng Giá Trị Sản Phẩm:</b> $%.2f</html>", totalProductQuantity, totalProductPrice));
        productSummaryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(productSummaryLabel, gbc);

        // Payment Section
        JLabel paymentLabel = new JLabel("Danh Sách Giao Dịch Thanh Toán:");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(paymentLabel, gbc);

        double totalPaid = 0.0;
        double totalOutstanding = 0.0;
        for (var invoice : contractDetail.getInvoices()) {
            addInvoiceComponent("Ngày Thanh Toán:", invoice.getPaymentDate() + " - " + invoice.getTotalPayment() + " paid, " + invoice.getTotalOutstanding() + " outstanding", invoice.isStatus(), gbc);
            totalPaid += invoice.getTotalPayment();
            totalOutstanding += invoice.getTotalOutstanding();
        }

        // Summary row for payments
        JLabel paymentSummaryLabel = new JLabel(String.format("<html><b>Tổng Thanh Toán:</b> $%.2f, <b>Tổng Nợ Còn Lại:</b> $%.2f</html>", totalPaid, totalOutstanding));
        paymentSummaryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(paymentSummaryLabel, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponent(String label, String value, GridBagConstraints gbc) {
        gbc.gridwidth = 1;
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setForeground(new Color(25, 25, 112));
        add(valueLabel, gbc);
    }

    private void addLabelComponent(String label1, String value1, String label2, String value2, GridBagConstraints gbc) {
        gbc.gridwidth = 1;
        JLabel jLabel1 = new JLabel(label1);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel1, gbc);

        JLabel valueLabel1 = new JLabel(value1);
        valueLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel1.setForeground(new Color(25, 25, 112));
        add(valueLabel1, gbc);

        JLabel jLabel2 = new JLabel(label2);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel2, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel valueLabel2 = new JLabel(value2);
        valueLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel2.setForeground(new Color(25, 25, 112));
        add(valueLabel2, gbc);
    }

    private void addProductComponent(String label, String value, GridBagConstraints gbc) {
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel productLabel = new JLabel(label + " " + value);
        productLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        productLabel.setForeground(new Color(112, 128, 144));
        add(productLabel, gbc);
    }

    private void addInvoiceComponent(String label, String value, boolean status, GridBagConstraints gbc) {
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel invoiceLabel = new JLabel(label + " " + value + (status ? " (Hoàn thành)" : " (Đang chờ)"));
        invoiceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        invoiceLabel.setForeground(status ? new Color(0, 128, 0) : new Color(255, 69, 0)); 
        add(invoiceLabel, gbc);
    }
}

package nncnpm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ContractDetailsFrame extends JFrame {
    public ContractDetailsFrame(ContractDetail_Customer29 contractDetail) {
        setTitle("Chi Tiết Hợp Đồng ID: " + contractDetail.getContractId());
        setSize(600, 700);  // Adjusted height to accommodate product list
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel headerLabel = new JLabel("<html><b>Xem Chi Tiết Hợp Đồng ID:</b> " + contractDetail.getContractId() + "</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel, gbc);

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

        // List each product
        for (ProductDetail product : contractDetail.getProductDetails()) {
            addProductComponent("Sản phẩm:", product.getProductName() + " - " + product.getQuantity() + " pcs @ $" + product.getUnitPrice(), gbc);
        }

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

        gbc.gridwidth = 1;
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
        productLabel.setForeground(new Color(112, 128, 144));  // Slate gray color for product details
        add(productLabel, gbc);
    }
}

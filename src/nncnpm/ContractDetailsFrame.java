package nncnpm;

import javax.swing.*;
import java.awt.*;

public class ContractDetailsFrame extends JFrame {
    public ContractDetailsFrame(ContractDetail_Customer29 contractDetail) {
        setTitle("Chi Tiết Hợp Đồng ID: " + contractDetail.getContractId());
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel headerLabel = new JLabel("<html><b>Xem Chi Tiết Hợp Đồng ID:</b> " + contractDetail.getContractId() + "</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(headerLabel, gbc);

        gbc.gridwidth = 1;
        addComponent("Tên Hợp Đồng:", contractDetail.getName(), gbc);
        addComponent("Tổng Giá:", String.format("$%.2f", contractDetail.getTotalPrice()), gbc);
        addComponent("Tổng Số Lượng:", String.valueOf(contractDetail.getTotalQuantity()), gbc);
        addComponent("Ngày Ký:", contractDetail.getSigningDate(), gbc);
        addComponent("Thời Hạn Vay (tháng):", String.valueOf(contractDetail.getLoanPeriod()), gbc);
        addLabelComponent("Tên Khách Hàng:", contractDetail.getCustomerName(), "Tên Đối Tác:", contractDetail.getPartnerName(), gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponent(String label, String value, GridBagConstraints gbc) {
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

        JLabel valueLabel2 = new JLabel(value2);
        valueLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel2.setForeground(new Color(25, 25, 112));
        add(valueLabel2, gbc);
    }
}

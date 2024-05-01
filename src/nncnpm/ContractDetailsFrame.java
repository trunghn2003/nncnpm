package nncnpm;

import javax.swing.*;
import java.awt.*;

public class ContractDetailsFrame extends JFrame {
    public ContractDetailsFrame(ContractDetail_Customer29 contractDetail) {
        setTitle("Contract Details for Contract ID: " + contractDetail.getContractId());
        setSize(600, 500);  // Adjusted for better fit
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;  // Adjust to allow multiple components in the same row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Header with custom font and border
        JLabel headerLabel = new JLabel("<html><b>Detail View for Contract ID:</b> " + contractDetail.getContractId() + "</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        gbc.gridwidth = GridBagConstraints.REMAINDER;  // Make the header take the full row
        add(headerLabel, gbc);

        gbc.gridwidth = 1;  // Reset to default for following rows

        // Adding components with enhanced style
        addComponent("Contract Name:", contractDetail.getName(), gbc);
        addComponent("Total Price:", String.format("$%.2f", contractDetail.getTotalPrice()), gbc);
        addComponent("Total Quantity:", String.valueOf(contractDetail.getTotalQuantity()), gbc);
        addComponent("Signing Date:", contractDetail.getSigningDate(), gbc);
        addComponent("Loan Period (months):", String.valueOf(contractDetail.getLoanPeriod()), gbc);
        addLabelComponent("Customer Name:", contractDetail.getCustomerName(), "Partner Name:", contractDetail.getPartnerName(), gbc);

        pack();  // Pack to respect preferred sizes
        setLocationRelativeTo(null);  // Center the frame
        setVisible(true);
    }

    private void addComponent(String label, String value, GridBagConstraints gbc) {
        gbc.gridwidth = 1;  // Maintain one column width for labels
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;  // Expand the value to take the rest of the line
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setForeground(new Color(25, 25, 112));  // Dark blue color
        add(valueLabel, gbc);
    }

    private void addLabelComponent(String label1, String value1, String label2, String value2, GridBagConstraints gbc) {
        gbc.gridwidth = 1;  // Label column
        JLabel jLabel1 = new JLabel(label1);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel1, gbc);

        gbc.gridwidth = 1;  // Value column
        JLabel valueLabel1 = new JLabel(value1);
        valueLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel1.setForeground(new Color(25, 25, 112));  // Dark blue color
        add(valueLabel1, gbc);

        gbc.gridwidth = 1;  // Second label column
        JLabel jLabel2 = new JLabel(label2);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel2, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;  // Last value takes the rest of the line
        JLabel valueLabel2 = new JLabel(value2);
        valueLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel2.setForeground(new Color(25, 25, 112));
        add(valueLabel2, gbc);
    }
}

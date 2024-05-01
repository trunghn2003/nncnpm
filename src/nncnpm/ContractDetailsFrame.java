package nncnpm;

import javax.swing.*;
import java.awt.*;

public class ContractDetailsFrame extends JFrame {
    public ContractDetailsFrame(ContractDetail_Customer29 contractDetail) {
        setTitle("Contract Details for Contract ID: " + contractDetail.getContractId());
        setSize(500, 600);  // Adjusted size for better element spacing
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());  // Switching to GridBagLayout for more control

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding

        // Header with custom font and border
        JLabel headerLabel = new JLabel("<html><b>Detail View for Contract ID:</b> " + contractDetail.getContractId() + "</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(headerLabel, gbc);

        // Adding components with enhanced style
        addComponent("Contract Name:", contractDetail.getName(), gbc);
        addComponent("Total Price:", String.format("$%.2f", contractDetail.getTotalPrice()), gbc);
        addComponent("Total Quantity:", String.valueOf(contractDetail.getTotalQuantity()), gbc);
        addComponent("Signing Date:", contractDetail.getSigningDate(), gbc);
        addComponent("Loan Period (months):", String.valueOf(contractDetail.getLoanPeriod()), gbc);

        pack();  // Pack to respect preferred sizes
        setLocationRelativeTo(null);  // Center the frame
        setVisible(true);
    }

    private void addComponent(String label, String value, GridBagConstraints gbc) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jLabel, gbc);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setForeground(new Color(25, 25, 112));  // Dark blue color
        add(valueLabel, gbc);
    }
}

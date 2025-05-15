import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StationeryPurchaseSystem extends JFrame implements ActionListener {
    JCheckBox notebookCB, penCB, pencilCB;
    JTextField notebookQty, penQty, pencilQty;
    JButton orderButton;

    public StationeryPurchaseSystem() {
        setTitle("Stationery Purchase System");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3, 5, 5));

        // Notebook
        notebookCB = new JCheckBox("Notebook @ ₹50");
        notebookQty = new JTextField("0", 5);
        add(notebookCB);
        add(new JLabel("Quantity:"));
        add(notebookQty);

        // Pen
        penCB = new JCheckBox("Pen @ ₹30");
        penQty = new JTextField("0", 5);
        add(penCB);
        add(new JLabel("Quantity:"));
        add(penQty);

        // Pencil
        pencilCB = new JCheckBox("Pencil @ ₹10");
        pencilQty = new JTextField("0", 5);
        add(pencilCB);
        add(new JLabel("Quantity:"));
        add(pencilQty);

        // Empty cells
        add(new JLabel(""));
        orderButton = new JButton("Place Order");
        add(orderButton);
        add(new JLabel(""));

        orderButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int totalQty = 0;
        int totalPrice = 0;
        StringBuilder message = new StringBuilder();

        try {
            if (notebookCB.isSelected()) {
                int qty = Integer.parseInt(notebookQty.getText());
                int price = qty * 50;
                message.append("Notebook: ").append(qty).append(" x ₹50 = ₹").append(price).append("\n");
                totalQty += qty;
                totalPrice += price;
            }

            if (penCB.isSelected()) {
                int qty = Integer.parseInt(penQty.getText());
                int price = qty * 30;
                message.append("Pen: ").append(qty).append(" x ₹30 = ₹").append(price).append("\n");
                totalQty += qty;
                totalPrice += price;
            }

            if (pencilCB.isSelected()) {
                int qty = Integer.parseInt(pencilQty.getText());
                int price = qty * 10;
                message.append("Pencil: ").append(qty).append(" x ₹10 = ₹").append(price).append("\n");
                totalQty += qty;
                totalPrice += price;
            }

            if (message.length() == 0) {
                JOptionPane.showMessageDialog(this, "Please select at least one item.");
                return;
            }

            message.append("\nTotal Quantity: ").append(totalQty);
            message.append("\nTotal Price: ₹").append(totalPrice);

            JOptionPane.showMessageDialog(this, message.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully ordered!", "Confirmation", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StationeryPurchaseSystem().setVisible(true);
        });
    }
}

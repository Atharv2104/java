import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumberGUI extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JButton reverseButton;

    public ReverseNumberGUI() {
        setTitle("Reverse Number Finder");
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Label and input field
        add(new JLabel("Enter a Number:"));
        inputField = new JTextField(15);
        add(inputField);

        // Reverse Button
        reverseButton = new JButton("Find Reverse");
        add(reverseButton);

        // Output field
        add(new JLabel("Reversed Number:"));
        outputField = new JTextField(15);
        outputField.setEditable(false);
        add(outputField);

        // Action Listener for button
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int number = Integer.parseInt(input);
                    int reversed = reverseNumber(number);
                    outputField.setText(String.valueOf(reversed));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer!");
                }
            }
        });
    }

    // Method to reverse the number
    private int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReverseNumberGUI gui = new ReverseNumberGUI();
            gui.setVisible(true);
        });
    }
}

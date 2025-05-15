import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StandardCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";

    public StandardCalculator() {
        setTitle("Standard Calculator");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "%", "x²", "√", "x³"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9\\.]")) {
            display.setText(display.getText() + cmd);
        } else if (cmd.matches("[\\+\\-\\*/%]")) {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num2 != 0 ? num1 / num2 : Double.NaN; break;
                    case "%": result = num1 % num2; break;
                }
                display.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (cmd.equals("x²")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(val * val));
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("√")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(val)));
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("x³")) {
            try {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(val * val * val));
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StandardCalculator().setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutConverter extends JFrame {

    private JTextField inputField, resultField;
    private JButton binaryBtn, octalBtn, hexBtn;

    public BorderLayoutConverter() {
        // Frame settings
        setTitle("Number Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // North Panel - Input
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Enter the number:"));
        inputField = new JTextField(10);
        northPanel.add(inputField);
        add(northPanel, BorderLayout.NORTH);

        // Center Panel - Buttons
        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        binaryBtn = new JButton("Binary");
        octalBtn = new JButton("Octal");
        hexBtn = new JButton("Hex");

        centerPanel.add(binaryBtn);
        centerPanel.add(octalBtn);
        centerPanel.add(hexBtn);
        add(centerPanel, BorderLayout.CENTER);

        // South Panel - Result
        JPanel southPanel = new JPanel();
        southPanel.add(new JLabel("Result:"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        southPanel.add(resultField);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        binaryBtn.addActionListener(e -> convert("binary"));
        octalBtn.addActionListener(e -> convert("octal"));
        hexBtn.addActionListener(e -> convert("hex"));

        // Make the frame visible
        setVisible(true);
    }

    private void convert(String type) {
        try {
            int number = Integer.parseInt(inputField.getText().trim());

            switch (type) {
                case "binary":
                    resultField.setText(Integer.toBinaryString(number));
                    break;
                case "octal":
                    resultField.setText(Integer.toOctalString(number));
                    break;
                case "hex":
                    resultField.setText(Integer.toHexString(number).toUpperCase());
                    break;
            }

        } catch (NumberFormatException e) {
            resultField.setText("Invalid number");
        }
    }

    public static void main(String[] args) {
        new BorderLayoutConverter();
    }
}


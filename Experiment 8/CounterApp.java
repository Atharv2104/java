import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApp extends JFrame {
    private int count = 0;
    private JTextField counterField;
    private JButton countUpButton, countDownButton, resetButton;

    public CounterApp() {
        setTitle("Counter Application");
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Counter display
        counterField = new JTextField(String.valueOf(count), 10);
        counterField.setEditable(false);
        counterField.setHorizontalAlignment(JTextField.CENTER);

        // Buttons
        countUpButton = new JButton("Count Up");
        countDownButton = new JButton("Count Down");
        resetButton = new JButton("Reset");

        // Button actions
        countUpButton.addActionListener(e -> {
            count++;
            counterField.setText(String.valueOf(count));
        });

        countDownButton.addActionListener(e -> {
            count--;
            counterField.setText(String.valueOf(count));
        });

        resetButton.addActionListener(e -> {
            count = 0;
            counterField.setText(String.valueOf(count));
        });

        // Add components to frame
        add(new JLabel("Counter:"));
        add(counterField);
        add(countUpButton);
        add(countDownButton);
        add(resetButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CounterApp app = new CounterApp();
            app.setVisible(true);
        });
    }
}

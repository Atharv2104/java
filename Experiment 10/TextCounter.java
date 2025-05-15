import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextCounter extends JFrame {

    private JTextArea textArea;
    private JLabel statusLabel;

    public TextCounter() {
        setTitle("Live Text Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        statusLabel = new JLabel("Characters: 0 | Words: 0");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(statusLabel, BorderLayout.SOUTH);

        // KeyListener to track changes
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCounts();
            }
        });

        setVisible(true);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int charCount = text.length();

        // Split by whitespace and filter out empty strings
        String[] words = text.trim().split("\\s+");
        int wordCount = text.trim().isEmpty() ? 0 : words.length;

        statusLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextCounter::new);
    }
}

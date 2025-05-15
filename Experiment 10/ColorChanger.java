import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChanger extends JFrame {

    private JComboBox<String> colorComboBox;
    private JPanel mainPanel;

    // Color names and their corresponding Color objects
    private final String[] colorNames = { "White", "Red", "Green", "Blue", "Yellow", "Orange", "Gray", "Cyan" };

    public ColorChanger() {
        setTitle("Background Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel to change background color
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        // Combo box for color selection
        colorComboBox = new JComboBox<>(colorNames);
        mainPanel.add(new JLabel("Select a color:"));
        mainPanel.add(colorComboBox);

        // Item listener to change background color
        colorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedColor = (String) colorComboBox.getSelectedItem();
                    mainPanel.setBackground(getColorByName(selectedColor));
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    // Utility method to convert color name to Color object
    private Color getColorByName(String name) {
        return switch (name) {
            case "Red" -> Color.RED;
            case "Green" -> Color.GREEN;
            case "Blue" -> Color.BLUE;
            case "Yellow" -> Color.YELLOW;
            case "Orange" -> Color.ORANGE;
            case "Gray" -> Color.GRAY;
            case "Cyan" -> Color.CYAN;
            default -> Color.WHITE;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorChanger::new);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSelector extends JFrame {

    private JComboBox<String> imageComboBox;
    private JLabel imageLabel;

    // List of image names (assumes images are in the same directory or classpath)
    private String[] imageNames = { "cat.jpeg", "dog.jpeg", "bird.jpeg" };

    public ImageSelector() {
        setTitle("Image Selector");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageComboBox = new JComboBox<>(imageNames);
        imageLabel = new JLabel("", SwingConstants.CENTER);

        // Add ItemListener to ComboBox
        imageComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedImage = (String) imageComboBox.getSelectedItem();
                    ImageIcon icon = new ImageIcon(selectedImage);
                    Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(img));
                }
            }
        });

        add(imageComboBox, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageSelector::new);
    }
}

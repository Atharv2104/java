import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {
        // Set title and frame size
        setTitle("FlowLayout Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set FlowLayout aligned left with horizontal gap 10px and vertical gap 20px
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // Create checkboxes
        JCheckBox javaCheckbox = new JCheckBox("Java");
        JCheckBox pythonCheckbox = new JCheckBox("Python");
        JCheckBox cppCheckbox = new JCheckBox("C++");

        // Add checkboxes to the frame
        add(javaCheckbox);
        add(pythonCheckbox);
        add(cppCheckbox);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}


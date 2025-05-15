import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseCoordinates extends JFrame {

    private JLabel label;

    public MouseCoordinates() {
        setTitle("Mouse Coordinates");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        label = new JLabel("Move the mouse inside the window");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label, BorderLayout.SOUTH);

        // Add mouse motion listener to the content pane
        getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse Coordinates: X = " + e.getX() + ", Y = " + e.getY());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseCoordinates::new);
    }
}

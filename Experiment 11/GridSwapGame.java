import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridSwapGame extends JFrame {
    private JButton[] buttons = new JButton[6];
    private JButton firstSelected = null;

    public GridSwapGame() {
        setTitle("GridLayout Swap Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(e -> handleSwap((JButton) e.getSource()));
            add(buttons[i]);
        }

        setVisible(true);
    }

    private void handleSwap(JButton clicked) {
        if (firstSelected == null) {
            firstSelected = clicked;
            firstSelected.setBackground(Color.YELLOW); // Highlight selected
        } else {
            // Swap numbers
            String temp = firstSelected.getText();
            firstSelected.setText(clicked.getText());
            clicked.setText(temp);
            firstSelected.setBackground(null);
            firstSelected = null;
        }
    }

    public static void main(String[] args) {
        new GridSwapGame();
    }
}


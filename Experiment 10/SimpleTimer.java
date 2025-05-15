import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTimer extends JFrame {

    private JLabel timerLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int seconds = 0;

    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timerLabel = new JLabel("Time: 0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(timerLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        add(startButton);
        add(stopButton);

        // Timer that updates every 1 second (1000 ms)
        timer = new Timer(1000, e -> {
            seconds++;
            timerLabel.setText("Time: " + seconds + " seconds");
        });

        // Start button action
        startButton.addActionListener(e -> {
            if (!timer.isRunning()) {
                timer.start();
            }
        });

        // Stop button action
        stopButton.addActionListener(e -> {
            if (timer.isRunning()) {
                timer.stop();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleTimer::new);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JPanel implements MouseListener, Runnable {
    private int ballX = 100, ballY = 100;
    private final int ballDiameter = 30;
    private int ballVelocityX = 3, ballVelocityY = 3;
    private boolean ballMoving = false;

    public BouncingBall() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void run() {
        while (ballMoving) {
            ballX += ballVelocityX;
            ballY += ballVelocityY;

            // Check collision with walls
            if (ballX <= 0 || ballX >= getWidth() - ballDiameter) {
                ballVelocityX = -ballVelocityX;
            }
            if (ballY <= 0 || ballY >= getHeight() - ballDiameter) {
                ballVelocityY = -ballVelocityY;
            }

            repaint();

            try {
                Thread.sleep(10); // Delay to slow down movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // MouseListener methods
    @Override
    public void mousePressed(MouseEvent e) {
        if (!ballMoving) {
            ballMoving = true;
            new Thread(this).start(); // Start movement on mouse press
        }
    }

    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    // Main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall bouncingBall = new BouncingBall();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bouncingBall);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


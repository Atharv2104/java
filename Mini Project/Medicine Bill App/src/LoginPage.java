import javax.swing.*;

public class LoginPage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().createLoginUI());
    }

    public void createLoginUI() {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 90, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            if (username.equals("dypcet") && password.equals("dypcet")) {
                JOptionPane.showMessageDialog(panel, "Login successful!");
                ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose(); // Close login window
                MedicineBillApp.launch(); // Call MedicineBillApp
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

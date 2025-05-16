import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage {
    JFrame frame = new JFrame("Pokemon Match Cards - Welcome");
    JTextField nameField = new JTextField(20);
    JButton startButton = new JButton("Start Game");
    JButton leaderboardButton = new JButton("Leaderboard");
    JLabel backgroundLabel;

    public FrontPage() {
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute layout for background layering

        // Load background image
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("./img/frontpage.jpg"));
        Image img = bgIcon.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(img));
        backgroundLabel.setBounds(0, 0, 700, 500);

        // Username input
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(240, 150, 200, 30);
        nameField.setBounds(240, 190, 220, 30);

        // Start Game button
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBounds(240, 240, 220, 40);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText().trim();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name.");
                } else {
                    frame.dispose(); // close front page
                    new MatchCard(username); // pass name
                }
            }
        });

        // Leaderboard button
        leaderboardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        leaderboardButton.setBounds(240, 290, 220, 35);
        leaderboardButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Leaderboard feature coming soon!");
        });

        // Add components in order (text, then background last for layering)
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(startButton);
        frame.add(leaderboardButton);
        frame.add(backgroundLabel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}


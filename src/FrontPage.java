import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage {
    JFrame frame;
    JTextField nameField;
    JButton startButton, exitButton;

public FrontPage() {
    int frontWidth = 5 * 90;  // 450
    int frontHeight = 4 * 128; // 512

    frame = new JFrame("Welcome to Pokémon Match Cards");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(frontWidth, frontHeight);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);

    JLabel titleLabel = new JLabel("Pokémon Match Cards", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    frame.add(titleLabel, BorderLayout.NORTH);

    // Use a BoxLayout panel to center components vertically and horizontally, compact size
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80)); // padding

    nameField = new JTextField();
    nameField.setFont(new Font("Arial", Font.PLAIN, 16));
    nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // compact height, full width allowed
    nameField.setHorizontalAlignment(JTextField.CENTER);
    nameField.setBorder(BorderFactory.createTitledBorder("Enter Player Name"));
    centerPanel.add(nameField);

    centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // vertical spacing

    startButton = new JButton("Enter Game");
    startButton.setFont(new Font("Arial", Font.PLAIN, 16));
    startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
    startButton.setMaximumSize(new Dimension(200, 40)); // compact button size
    startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String playerName = nameField.getText().trim();
            if (playerName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your name.");
                return;
            }
            frame.dispose();
            App.launchGame();
        }
    });
    centerPanel.add(startButton);

    centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // vertical spacing

    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
    exitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // center horizontally
    exitButton.setMaximumSize(new Dimension(200, 40)); // compact button size
    exitButton.addActionListener(e -> System.exit(0));
    centerPanel.add(exitButton);

    frame.add(centerPanel, BorderLayout.CENTER);

    frame.setVisible(true);
}

}

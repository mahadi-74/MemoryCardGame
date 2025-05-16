import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage {
    JFrame frame;
    JTextField nameField;
    JButton startButton, exitButton;

    int boardWidth = 450;  // match MatchCards width (columns * cardWidth)
    int boardHeight = 512; // match MatchCards height (rows * cardHeight)

    public FrontPage() {
        frame = new JFrame("Welcome to Pokémon Match Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(boardWidth, boardHeight);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Pokémon Match Cards", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Use BoxLayout for vertical alignment and center components compactly
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // increased height
        nameField.setBorder(BorderFactory.createTitledBorder("Enter Player Name"));
        centerPanel.add(nameField);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // spacing

        startButton = new JButton("Enter Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(new Dimension(200, 40));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText().trim();
                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name.");
                    return;
                }
                frame.dispose();
                new MatchCards(playerName);  // pass player name here
            }
        });
        centerPanel.add(startButton);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setMaximumSize(new Dimension(200, 40));
        exitButton.addActionListener(e -> System.exit(0));
        centerPanel.add(exitButton);

        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // To test this FrontPage independently, add a main method:
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrontPage());
    }
}

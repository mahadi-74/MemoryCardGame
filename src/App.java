public class App {
    private static String playerName;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new FrontPage());
    }

    // Called from FrontPage, pass the player name here
    public static void launchGame(String name) {
        playerName = name;
        javax.swing.SwingUtilities.invokeLater(() -> new MatchCards(playerName));
    }
}

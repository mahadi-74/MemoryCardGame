public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new FrontPage());
    }

    public static void launchGame() {
        javax.swing.SwingUtilities.invokeLater(() -> new MatchCards());
    }
}

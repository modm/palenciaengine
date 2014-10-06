package palenciaEngine;

/**
 * Created by modm on 06/10/2014.
 */
import java.awt.*;
import javax.swing.JFrame;

public class GameLauncher {

    public static void main(String[] args) {
            Game game = new Game();
            JFrame f = new JFrame();
            f.add(game);
            f.setVisible(true);
            f.setSize(1024,600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("PortalScape");
            game.setBackground(Color.GREEN);
    }
}

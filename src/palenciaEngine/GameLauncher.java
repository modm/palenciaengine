package palenciaEngine;

/**
 * Created by modm on 06/10/2014.
 */
import java.awt.*;
import javax.swing.*;

public class GameLauncher {

    public static void main(String[] args) {
            //Game game = new Game();
            GameUI gameUI = new GameUI();
            JFrame f = new JFrame();

            //f.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
            //game.setPreferredSize(new Dimension(1024, 500));
            //game.setLayout(new FlowLayout());
            f.add(gameUI);
            //f.add(gameUI);
            f.setSize(1024, 700);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("PortalScape");
            f.setLocationRelativeTo(null); //Centrar aplicacion
            gameUI.setBackground(Color.BLUE);
            //gameUI.setBackground(Color.BLUE);
            f.setVisible(true);
    }
}

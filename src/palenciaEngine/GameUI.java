/**
 * Created by modm on 07/10/2014.
 */

package palenciaEngine;
import palenciaEngine.input.InputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JPanel implements ActionListener {

    /* DEBUG VARIABLES */
    float debugX = 0;
    float debugY = 0;
    private JLabel lblDebugPos;
    Game game;
    Timer t = new Timer(125, this);

    public GameUI()
    {
        t.start();
        game = new Game();
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(new Dimension(1024, 200));
        game.setPreferredSize(new Dimension(1024, 500));
        game.setLayout(new FlowLayout());
        game.setBackground(Color.GREEN);
        add(game);

        lblDebugPos = new JLabel();
        lblDebugPos.setForeground(Color.WHITE);
        lblDebugPos.setText("posx: 1");
        add(lblDebugPos);
        /* DEBUG POSITION */
        /*if(physics.getmX() != debugX || physics.getmY() != debugY) {
            System.out.println("pos X: " + physics.getmX() + " | pos Y: " + physics.getmY());
            debugX = physics.getmX();
            debugY = physics.getmY();
        }*/
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* DEBUG POSITION */
        if(game.physics.getmX() != debugX || game.physics.getmY() != debugY) {
            lblDebugPos.setText("pos X: " + game.physics.getmX() + " | pos Y: " + game.physics.getmY());
            debugX = game.physics.getmX();
            debugY = game.physics.getmY();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

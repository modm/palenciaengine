/**
 * Created by modm on 06/10/2014.
 */

package palenciaEngine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

import palenciaEngine.entities.Player;
import palenciaEngine.graphics.GraphicsHandler;
import palenciaEngine.input.InputHandler;
import palenciaEngine.physics.PhysicsHandler;

public class Game extends JPanel implements InputHandler, ActionListener {

    public InputHandler input;
    public GraphicsHandler gfx;
    public PhysicsHandler physics;
    public Player player;
    private BufferedImage[] spritesMain = new BufferedImage[8];
    Timer t = new Timer(125, this);
    public int totalSprites = 8; //Numero total de imagenes en la carpeta de imagenes

    public Game()
    {
        t.start();
        addKeyListener(this);
        setFocusable(true); //Focusear el panel para que funcione las teclas
        setFocusTraversalKeysEnabled(false); //Para que no te puedas ir a otro control y seguir con el focus
        physics = new PhysicsHandler();
        physics.setmX(100);
        physics.setmY(100);
        physics.setmVX(0);
        physics.setmVY(0);
        gfx = new GraphicsHandler(totalSprites);
        player = new Player();
        spritesMain = gfx.spriteLoader("megaman", "characters");
    }

    /*************************************************************************
     ** Aqui esta el render que se va actualizando
     ** Toma la posicion y la direccion del sprite y la pinta en la pantalla
     *************************************************************************/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gfx.animate.setNspr(gfx.animate.playAnimation(physics.getmVX(), physics.getmVY(), physics.getDir())); //Tomar posicion y direccion del sprite
        g.drawImage(spritesMain[gfx.animate.getNspr()], (int)physics.getmX(), (int)physics.getmY(), this); //pintar sprite
    }

    /******************************************************************
     ** Pone los limites en la pantalla para que no se salga el mono
     ** Aqui tambien va lo de los portales
     ******************************************************************/
    public void actionPerformed(ActionEvent e) {
        if(physics.getmX() < 0) {
            physics.setmVX(0);
            physics.setmVX(0);
        }
        if(physics.getmX() > 1180) {
            physics.setmVX(0);
            physics.setmVX(1180);
        }
        if(physics.getmY() < 0) {
            physics.setmVY(0);
            physics.setmVY(0);
        }
        if(physics.getmY() > 690) {
            physics.setmVY(0);
            physics.setmVY(690);
        }
        physics.setmX(physics.getmX() + (float) physics.getmVX());
        physics.setmY(physics.getmY() + (float) physics.getmVY());
        repaint();
    }

    /******************************************************************
     ** Metodos para movimiento de sprite
     ** UP, DOWN, LEFT, RIGHT, JUMP
     ******************************************************************/

    public void up() {
        physics.setmVX(0);
        physics.setmVY(-40);
    }
    public void down() {
        physics.setmVX(0);
        physics.setmVY(40);
    }

    public void left() {
        physics.setmVX(-40);
        physics.setmVY(0);
    }

    public void right() {
        physics.setmVX(40);
        physics.setmVY(0);
    }

    public void jump() {

    }

    /******************************************************************************
     ** Cuando una tecla esta siendo pulsada (esta llama a los metodos de arriba)
     ** up(), down(), left(), right(), jump()
     ******************************************************************************/
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                up();
                break;
            case KeyEvent.VK_DOWN:
                down();
                break;
            case KeyEvent.VK_LEFT:
                if(physics.getDir() == 0) physics.setDir(1);
                if(gfx.animate.getNspr() == 0) gfx.animate.setNspr(4);
                left();
                break;
            case KeyEvent.VK_RIGHT:
                if(physics.getDir() == 1) physics.setDir(0);
                if(gfx.animate.getNspr() == 4) gfx.animate.setNspr(0);
                right();
                break;
            case KeyEvent.VK_SPACE:
                //jump();
                break;
        }
    }

    public void keyTyped(KeyEvent e) {}

    /******************************************************************
     ** Cuando una tecla se deja de pulsar
     ** UP, DOWN, LEFT, RIGHT, SPACE
     ******************************************************************/
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                physics.setmVX(0);
                physics.setmVY(0);
                break;
            case KeyEvent.VK_SPACE:
                physics.setmVX(0);
                physics.setmVY(0);
                break;
        }
    }
}

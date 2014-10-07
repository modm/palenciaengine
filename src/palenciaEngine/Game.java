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

import palenciaEngine.entities.Plank;
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
    public boolean jumping = false;
    /* DEBUG VARIABLES */
    float debugX = 0;
    float debugY = 0;

    boolean falling = false;

    GameUI gameUI;

    public Game() {
        t.start();
        addKeyListener(this);
        setFocusable(true); //Focusear el panel para que funcione las teclas
        setFocusTraversalKeysEnabled(false); //Para que no te puedas ir a otro control y seguir con el focus
        physics = new PhysicsHandler();
        physics.setmX(0);
        physics.setmY(387);
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

        Plank plank = new Plank();

        //Figura1
        g.setColor(Color.DARK_GRAY);
		/*Declaras los Int vx,vy :: Del objeto New_Figura en la variable Vx[] llamas a la funcion
		 * setVx(Vx0(donde quieras que este el primer punto de X, arriba a la izquierda),
		 * 		Vy0(donde quieras que este el primer punto de y, arriba a la izquierda),
		 * 		Width(que tan ancho quieres que este la barra),
		 * 		Height(el alto de la barra));
		 */
        int[] Vx1 = plank.setVx(350,550,320,30);
        int[] Vy1 = plank.setVy(350,550,320,30);
        g.fillPolygon(Vx1,Vy1,Vx1.length);

        //Figura2
        int[] Vx2 = plank.setVx(850,350,174,30);
        int[] Vy2 = plank.setVy(850,350,174,30);
        g.fillPolygon(Vx2,Vy2,Vx2.length);

        //Figura3
        int[] Vx3 = plank.setVx(0,350,174,30);
        int[] Vy3 = plank.setVy(0,350,174,30);
        g.fillPolygon(Vx3,Vy3,Vx3.length);


        //Figura4
        int[] Vx4 = plank.setVx(350,250,320,30);
        int[] Vy4 = plank.setVy(350,250,320,30);
        g.fillPolygon(Vx4,Vy4,Vx4.length);

        gfx.animate.setNspr(gfx.animate.playAnimation(physics.getmVX(), physics.getmVY(), physics.getDir())); //Tomar posicion y direccion del sprite
        g.drawImage(spritesMain[gfx.animate.getNspr()], (int) physics.getmX(), (int) physics.getmY(), this); //pintar sprite

        /* DEBUG POSITION */
        if(physics.getmX() != debugX || physics.getmY() != debugY) {
            System.out.println("pos X: " + physics.getmX() + " | pos Y: " + physics.getmY());
            debugX = physics.getmX();
            debugY = physics.getmY();
        }
    }

    /******************************************************************
     ** Pone los limites en la pantalla para que no se salga el mono
     ** Aqui tambien va lo de los portales
     ******************************************************************/
    public void actionPerformed(ActionEvent e) {

        if(falling == true) {
            physics.setmVY(physics.getmVY()+60);
            falling = false;
            physics.setJumping(false);
        }

        if(physics.isJumping()) {
            physics.setmVY(physics.getmVY()-60);
            falling = true;
        }

        if(physics.getmX() < 0) {
            physics.setmVX(0);
            physics.setmX(0);
        }
        if(physics.getmX() > 924) {
            physics.setmVX(0);
            physics.setmX(924);
        }
        if(physics.getmY() < 0) {
            physics.setmVY(0);
            physics.setmY(0);
        }
        if(physics.getmY() > 387) {
            physics.setmVY(0);
            physics.setmY(387);
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
        if(!physics.isJumping()) {
            physics.setmVX(0);
            physics.setmVY(-40);
        }
    }
    public void down() {
        if(!physics.isJumping()) {
            physics.setmVX(0);
            physics.setmVY(40);
        } else {
            physics.setJumping(false);
        }
    }

    public void left() {
        if(!physics.isJumping()) {
            physics.setmVX(-40);
            physics.setmVY(0);
        }
    }

    public void right() {
        if(!physics.isJumping()) {
            physics.setmVX(40);
            physics.setmVY(0);
        }
    }

    public void jump() {
        physics.setmVX(0);
        physics.setmVY(0);
        physics.setJumping(true);
    }

    /******************************************************************************
     ** Cuando una tecla esta siendo pulsada (esta llama a los metodos de arriba)
     ** up(), down(), left(), right(), jump()
     ******************************************************************************/
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                //up();
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
                jump();
                System.out.println("JUMP");
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


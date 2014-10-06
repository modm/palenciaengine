package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

public class Animation extends JPanel implements ActionListener, KeyListener {

	Timer t = new Timer(125, this);
	int x = 100;
	int y = 300;
	double velX = 0;
	double velY = 0;
	private BufferedImage[] sprites = new BufferedImage[8];
	private URL[] resource = new URL[8]; 
	private BufferedImage image;
	int nspr = 0;
	int back = 0;
	boolean moving = false;
	boolean jumping = false;
	boolean jumpingUp = false;
	boolean jumpingDown = false;
	boolean jumpingDone = true;
	int KP;
	int jumpForce = 0;
	int dir = 0;
	
	public Animation() {
		this.setBackground(Color.GREEN);
		t.start();
		moving = true;
		addKeyListener(this);
		setFocusable(true); //Focusear el panel para que funcione las teclas
		setFocusTraversalKeysEnabled(false); //Para que no te puedas ir a otro control y seguir con el focus
		for(int i = 0; i < resource.length; i++) {
			resource[i] = getClass().getResource("megaman"+(i+1)+".png");
		}
        try {
        	for(int i = 0; i < sprites.length; i++)
        		sprites[i] = ImageIO.read(resource[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circulo = new Ellipse2D.Double(x, y, 60, 60);
		g2.fill(circulo);
		*/
		/*if(jumping) {
			if(jumpingDown) {
				velY = 50;
				jumpingUp = false;
				jumpingDown = false;
				jumpingDone = true;
			} else {
				velY = -50;
				jumpingDown = true;
			}
		}*/
		if(dir == 0) {
			if(nspr == 0) nspr = 1;
			else if(nspr == 1) nspr = 2;
			else if(nspr == 2) nspr = 3;
			else if(nspr == 3) nspr = 1;
		if(velX == 0 && velY == 0) nspr = 0;
		} else {
			if(nspr == 4) nspr = 5;
			else if(nspr == 5) nspr = 6;
			else if(nspr == 6) nspr = 7;
			else if(nspr == 7) nspr = 5;
		if(velX == 0 && velY == 0) nspr = 4;			
		}
		g.drawImage(sprites[nspr], x, y, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(x < 0) {
			velX = 0;
			x = 0;	
		}
		if(x > 1180) {
			velX = 0;
			x = 1180;	
		}
		if(y < 0) {
			velY = 0;
			y = 0;	
		}
		if(y > 690) {
			velY = 0;
			y = 690;
		}
		
		x += velX;
		y += velY;
		repaint();
	}
	
	public void up() {
		velX = 0;
		velY = -40;
	}
	public void down() {
		velX = 0;
		velY = 40;
	}
	
	public void left() {
		velX = -40;
		velY = 0;
	}
	
	public void right() {
		velX = 40;
		velY = 0;
	}
	
	public void jump() {
		jumping = true;
	}
	//1, 2, 4, 8
	//UP, RIGHT, DOWN, LEFT
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
	        	if(dir == 0) dir = 1;
	        	if(nspr == 0) nspr = 4;
	            left();
	            break;
	        case KeyEvent.VK_RIGHT:
	        	if(dir == 1) dir = 0;
	        	if(nspr == 4) nspr = 0;
	            right();
	            break;
	        case KeyEvent.VK_SPACE:
	            jump();
	            break;
	     }
	} 
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_RIGHT:
	        	velX = 0;
	    		velY = 0;
	            break;
	        case KeyEvent.VK_SPACE:
	        	velX = 0;
	    		velY = 0;
	            break;
	     }
	}
	
}

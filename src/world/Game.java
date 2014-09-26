package world;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import animation.Animation;
import input.Input;
import graphics.GraphicsPalencia;

public class Game implements World, Input{

	int posx;
	int posy;
	int size;
	int color;
	Animation animation;
	
	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsPalencia graphic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		MegamanPalencia megaman = new MegamanPalencia(posx, posy, size, color, animation);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			System.out.println("Corre");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			System.out.println("Regresate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			System.out.println("Baja por los chescos");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
			System.out.println("Salta");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
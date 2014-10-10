/**
 * Created by modm on 06/10/2014.
 */

package palenciaEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import palenciaEngine.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class InputHandler implements KeyListener, MouseListener{
	
	public InputHandler(){
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {	
	}
	
	public void keyPressed(KeyEvent e){
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
			System.out.println("Brinca");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			System.out.println("Regresate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			System.out.println("Baja por los chescos");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			System.out.println("Corre");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("P")){
			System.out.println("Pausate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("SpaceBar")){
			System.out.println("La Barra del Espacio");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("1")){
			System.out.println("huan");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("2")){
			System.out.println("tu");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("3")){
			System.out.println("tri");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("4")){
			System.out.println("for");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("5")){
			System.out.println("faiv");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("6")){
			System.out.println("six");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("7")){
			System.out.println("seben");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("8")){
			System.out.println("eit");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("9")){
			System.out.println("nain");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("0")){
			System.out.println("sero");
		}
		
	}

	public void keyReleased(KeyEvent e){
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
			System.out.println("Brinca");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			System.out.println("Regresate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			System.out.println("Baja por los chescos");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			System.out.println("Corre");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("P")){
			System.out.println("Pausate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("SpaceBar")){
			System.out.println("La Barra del Espacio");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("1")){
			System.out.println("huan");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("2")){
			System.out.println("tu");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("3")){
			System.out.println("tri");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("4")){
			System.out.println("for");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("5")){
			System.out.println("faiv");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("6")){
			System.out.println("six");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("7")){
			System.out.println("seben");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("8")){
			System.out.println("eit");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("9")){
			System.out.println("nain");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("0")){
			System.out.println("sero");
		}
	}

	public void keyTyped(KeyEvent e){
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
			System.out.println("Brinca");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
			System.out.println("Regresate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")){
			System.out.println("Baja por los chescos");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
			System.out.println("Corre");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("P")){
			System.out.println("Pausate");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("SpaceBar")){
			System.out.println("La Barra del Espacio");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("1")){
			System.out.println("huan");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("2")){
			System.out.println("tu");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("3")){
			System.out.println("tri");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("4")){
			System.out.println("for");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("5")){
			System.out.println("faiv");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("6")){
			System.out.println("six");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("7")){
			System.out.println("seben");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("8")){
			System.out.println("eit");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("9")){
			System.out.println("nain");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("0")){
			System.out.println("sero");
		}
	}
}


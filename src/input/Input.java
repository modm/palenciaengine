package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Input extends KeyListener{

	/*	
	public Input() {
		KeyListener listener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

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

			public void keyReleased(KeyEvent e) {
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
					System.out.println("Salta");
				}
				
				
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
*/
	
	public void keyPressed(KeyEvent e);

	public void keyReleased(KeyEvent e);

	public void keyTyped(KeyEvent e);
}
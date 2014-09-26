import java.awt.Color;

import javax.swing.*;

public class MainInit {

	public static void main(String args[]) {
		Animation a = new Animation();
		JFrame f = new JFrame();
		f.add(a);
		f.setVisible(true);
		f.setSize(1280,800);
		f.setBackground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Motor de Animacion");
	}
	
}

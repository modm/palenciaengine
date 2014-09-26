package graphics;

import input.Input;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class GraphicsPalencia extends JFrame{

	private JPanel contentPane;
	private JButton Figura1, Figura2, Figura3, arriba, abajo, izq, der;
	private JTextField txt1;

	// Figura1
	public int[] vx1 = { 0, 0, 0 };
	public int[] vy1 = { 0, 0, 0 };
	// Figura2
	public int[] vx2 = { 0, 0, 0, 0 };
	public int[] vy2 = { 120, 120, 220, 220 };

	// Figura3 Circulo
	// Centro
	public int vx3 = 0;
	public int vy3 = 0;
	public int ancho = 0;

	// Radio

	public int numFigura = 0;
	public int escalar;
	public int grados = 0;
	public int x, y, xT, yT, xS, yS, xC, yC;

	/*
	 * public int getGrados (){ return grados; }
	 * 
	 * public void setGrados (int grados){ this.grados = grados; }
	 */

	public GraphicsPalencia() {

		
		contentPane.setLayout(null);


		Figura1 = new JButton("Triangulo");
		Figura1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numFigura = 1;
				x = 0;
				y = 0;
				repaint();
			}
		});
		Figura1.setBounds(10, 10, 165, 23);

		Figura2 = new JButton("Cuadrado");
		Figura2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numFigura = 2;
				x = 0;
				y = 0;
				repaint();
			}
		});
		Figura2.setBounds(10, 37, 165, 23);

		Figura3 = new JButton("Circulo");
		Figura3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numFigura = 3;
				x = 0;
				y = 0;
				repaint();
			}
		});
		Figura3.setBounds(10, 65, 165, 23);

		txt1 = new JTextField(5);
		txt1.setBounds(10, 200, 100, 30);
		txt1.setText("0");

		// Metodo Escalar Escalar
		// --------------------------------------------------------------------
		final JLabel porc = new JLabel("Tamaño: 0 %");
		porc.setBounds(30, 95, 165, 20);

		final JSlider js = new JSlider(0, 100);
		js.setBounds(10, 117, 165, 20);
		js.setValue(0);
		js.addChangeListener(new javax.swing.event.ChangeListener() {

			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (numFigura != 0) {
					escalar = (js.getValue());
					porc.setText("Tamaño: " + String.valueOf(escalar) + " %");
					repaint();
				}
			}
		});

		final JLabel porc2 = new JLabel("Grados: 0°");
		porc2.setBounds(30, 138, 165, 20);

		final JSlider js2 = new JSlider(0, 360);
		js2.setBounds(10, 157, 165, 20);
		js2.setValue(0);
		js2.addChangeListener(new javax.swing.event.ChangeListener() {

			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (numFigura != 0) {
					grados = (js2.getValue());
					porc2.setText("Grados: " + String.valueOf(grados) + " %");
					repaint();
				}
			}
		});

		// -------- Translado
		// ---------------------------------------------------

		arriba = new JButton("");
		arriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnUp();
			}
		});
		arriba.setBounds(80, 190, 20, 20);

		abajo = new JButton("");
		abajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnDown();
			}
		});
		abajo.setBounds(80, 230, 20, 20);

		izq = new JButton("");
		izq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnLeft();
			}
		});
		izq.setBounds(55, 210, 20, 20);

		der = new JButton("");
		der.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnRight();
			}
		});
		der.setBounds(105, 210, 20, 20);

		contentPane.add(Figura1);
		contentPane.add(Figura2);
		contentPane.add(Figura3);
		contentPane.add(js);
		contentPane.add(js2);
		contentPane.add(porc);
		contentPane.add(porc2);
		contentPane.add(arriba);
		contentPane.add(abajo);
		contentPane.add(izq);
		contentPane.add(der);

		// contentPane.add(txt1);
		
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
		
		contentPane.add(listener);
	}
	
	

	public void paint(Graphics g) {
		super.paint(g);

		double r = Math.toRadians(grados);

		g.drawLine(220, 0, 220, 400);
		// Dibujo Triangulo

		if (numFigura == 1) {

			vx1[0] = 500 + x;
			vx1[1] = 550 + (escalar * 2) + x;
			vx1[2] = 450 - (escalar * 2) + x;

			vy1[0] = 220 - (escalar * 2) + y;
			vy1[1] = 320 + (escalar * 2) + y;
			vy1[2] = 320 + (escalar * 2) + y;

			g.setColor(Color.blue);

			double Tx = (vx1[0] + vx1[1] + vx1[2]) / 3;
			double Ty = (vy1[0] + vy1[1] + vy1[2]) / 3;

			AffineTransform rotar = new AffineTransform();
			rotar.rotate(r, Tx, Ty);
			((Graphics2D) g).setTransform(rotar);

			g.drawPolygon(vx1, vy1, 3);
		}

		// Dibujo Cuadrado
		if (numFigura == 2) {
			int xT = x;
			int yT = y;

			vx2[0] = 350 - (escalar * 2) + x;
			vx2[1] = 450 + (escalar * 2) + x;
			vx2[2] = 450 + (escalar * 2) + x;
			vx2[3] = 350 - (escalar * 2) + x;
			g.setColor(Color.red);
			/*
			 * vx1 [0]= 0; vx1 [1]= 0; vx1 [2]= 0;
			 */
			vy2[0] = 120 - (escalar * 2) + y;
			vy2[1] = 120 - (escalar * 2) + y;
			vy2[2] = 220 + (escalar * 2) + y;
			vy2[3] = 220 + (escalar * 2) + y;

			double Cx = (vx2[0] + vx2[1] + vx2[2] + vx2[3]) / 4;
			double Cy = (vy2[0] + vy2[1] + vy2[2] + vy2[3]) / 4;

			AffineTransform rotar = new AffineTransform();
			rotar.rotate(r, Cx, Cy);
			((Graphics2D) g).setTransform(rotar);

			g.drawPolygon(vx2, vy2, 4);

		}

		if (numFigura == 3) {
			vx3 = 550 - (escalar) + x;
			vy3 = 100 - (escalar) + y;
			ancho = Integer.parseInt(txt1.getText());
			ancho = 100 + (escalar * 2);

			g.setColor(Color.GREEN);
			g.drawOval(vx3, vy3, ancho, ancho);
		}
	}

	// ----------------------------------------------------------------------------//
	/**
	 * Launch the application.
	 */
	

	public void pintar(int[] posicion[]) {
		vx1[0] = 200;
		vy2[1] = 500;

	}

	public void BtnLeft() {
		x = x - 10;

	}

	public void BtnRight() {
		x = x + 10;

	}

	public void BtnUp() {
		y = y - 10;

	}

	public void BtnDown() {
		y = y + 10;

	}

	public void actionPerformed(java.awt.event.ActionEvent e) {

	}

	public void degrees(int degrees) {
		grados = (degrees);
	}

	public void size(int size) {
		escalar = (size);
	}

	public void figura(int x) {
		numFigura = x;
	}
}
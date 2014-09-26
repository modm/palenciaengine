package world;

import physics.Physics;
import graphics.GraphicsPalencia;
import animation.Animation;

public class MegamanPalencia extends Palencia{

	int size;
	int color;
	Animation animation;
	GraphicsPalencia g;
	Physics physics;
	public MegamanPalencia(int posx, int posy, int size, int color, Animation animation) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		this.size = size;
		this.color = color;
		this.animation = animation;
		physics.setmX(posx);
		physics.setmY(posy);
	}
	
	public void paint(){
		g.repaint();
	}
}
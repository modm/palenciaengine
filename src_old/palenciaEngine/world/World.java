package world;
import graphics.GraphicsPalencia;


public interface World{
	
	public void update(int delta);
	
	public void render(GraphicsPalencia graphic);
	
	public void init();
	
}

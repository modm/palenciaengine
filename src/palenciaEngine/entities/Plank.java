package palenciaEngine.entities;

/**
 * Created by modm on 07/10/2014.
 */
public class Plank {
    public Plank(){

    }


    public int[] setVx(int x, int y, int width, int height){
        int[] Vx = new int[4];

        Vx[0] = x;
        Vx[1] = x+width;
        Vx[2] = x+width;
        Vx[3] = x;

        return Vx;
    }

    public int[] setVy(int x, int y, int width, int height){
        int[] Vy = new int[4];

        Vy[0] = y;
        Vy[1] = y;
        Vy[2] = y+height;
        Vy[3] = y+height;

        return Vy;
    }
}

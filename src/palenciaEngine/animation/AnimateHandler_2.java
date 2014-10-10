/**
 * Modified by Edgar, Vicente and Hector on 06/10/2014.
 */

package palenciaEngine.animation;

import palenciaEngine.Game;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class AnimateHandler {

    private BufferedImage[] animationSprites;
    private URL[] animationResource;
    int nspr = 0;
    int index = 0;

    public AnimateHandler(BufferedImage[] sprites, URL[] resource)
    {
        animationSprites = new BufferedImage[sprites.length];
        animationResource = new URL[resource.length];
    }

    public void gotoFrameIndex(int i) {
        index = i;
    }
    public int playAnimation(int horizontalflag, int verticalflag, int webon ){
    	if(webon == 1 )
    	{
    		if(horizontalflag == 1)
    			 nspr = 0;
    		else
    			nspr = 4;    		
    	}
    	else
    	{
    		if(horizontalflag==1){
    			nspr++;
    			if(nspr == 4)
    				nspr = 1;
    		}
    		else
    		{
    			nspr++;
    			if(nspr == 8)
    				nspr = 5;
    		}
    		if(verticalflag == 1){
    			if(nspr > -1 && nspr < 4)
    			{
    				nspr = 2;
    			}
    			else
    				nspr = 5;
    		}
    	
    	}
    	return nspr;
    	
    }
   /* public int playAnimation(double velX, double velY, int dir) {
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

        return nspr;
    }

    public int playJumping(double velX, double velY, int dir) {
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

        return nspr;
    }*/

    public int getNspr() {
        return nspr;
    }

    public void setNspr(int nspr) {
        this.nspr = nspr;
    }

    public void stop() {

    }
}

/**
 * Created by modm on 06/10/2014.
 */
package palenciaEngine.graphics;

import palenciaEngine.animation.AnimateHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GraphicsHandler {
    private BufferedImage[] sprites;
    private URL[] resource;
    public AnimateHandler animate;

    public GraphicsHandler(int totalSprites) {
        sprites = new BufferedImage[totalSprites];
        resource = new URL[totalSprites];
        animate = new AnimateHandler(sprites, resource);
    }

    public BufferedImage[] spriteLoader(String sprName, String sprType) {
        for(int i = 0; i < resource.length; i++) {
            resource[i] = getClass().getResource("../animation/"+sprType+"/"+sprName+(i+1)+".png");
        }
        try {
            for(int i = 0; i < sprites.length; i++)
                sprites[i] = ImageIO.read(resource[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprites;

    }
}

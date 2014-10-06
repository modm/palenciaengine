/**
 * Created by modm on 06/10/2014.
 */

package palenciaEngine.entities;

import palenciaEngine.Game;
import palenciaEngine.input.InputHandler;
import palenciaEngine.physics.PhysicsHandler;

public class Player extends Portal {

    private InputHandler input;

    public Player() {

    }

    public boolean hasCollided(int x, int y)
    {
        return false;
    }

}
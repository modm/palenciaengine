/**
 * Created by modm on 06/10/2014.
 */

package palenciaEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import palenciaEngine.Game;

public interface InputHandler extends KeyListener {

    public void keyPressed(KeyEvent e);

    public void keyReleased(KeyEvent e);

    public void keyTyped(KeyEvent e);
}


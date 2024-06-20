package Inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Main.GameState;

public class KeyInputs implements KeyListener{

    private GamePanel panel;

    /*
     * Method Name: KeyInputs
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 7, 2024
     * @Description: Constructor for the KeyInputs class.
     * @Parameters: panel - the GamePanel instance to be controlled by the key inputs.
     * @Returns: n/a
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public KeyInputs(GamePanel panel) {
        this.panel = panel;
    } 

    /*
     * Method Name: keyPressed
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 8, 2024
     * @Description: Handles the event when a key is pressed.
     * @Parameters: e - the KeyEvent triggered by the key press.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void keyPressed(KeyEvent e) {
        switch(GameState.currentState) {
            case PLAYING:
                panel.getGame().getPlaying().keyPressed(e);
            default:
                break;
        }
    }

    /*
     * Method Name: keyReleased
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 7, 2024
     * @Description: Handles the event when a key is released.
     * @Parameters: e - the KeyEvent triggered by the key release.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /*
     * Method Name: keyTyped
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 8, 2024
     * @Description: Handles the event when a key is typed.
     * @Parameters: e - the KeyEvent triggered by the key typed.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

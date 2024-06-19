package Inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Main.GameState;

public class KeyInputs implements KeyListener{

    private GamePanel panel;

    public KeyInputs(GamePanel panel) {
        this.panel = panel;
    } 


    @Override
    public void keyPressed(KeyEvent e) {
        switch(GameState.currentState) {
            case PLAYING:
                panel.getGame().getPlaying().keyPressed(e);
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

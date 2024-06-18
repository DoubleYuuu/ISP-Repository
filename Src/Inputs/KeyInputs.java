package Inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class KeyInputs implements KeyListener{

    private GamePanel panel;

    public KeyInputs(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        panel.getGame().getPlaying().getPlayer().keyPressed(e); 
        System.out.println("ASD");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

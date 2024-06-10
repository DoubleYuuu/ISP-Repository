package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Main.GamePanel;

public class KeyInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        switch (e.getKeyCode()) {
            case (KeyEvent.VK_W):
                gamePanel.changeYSpeed(-5);
                break;
            case (KeyEvent.VK_A):
                gamePanel.changeXSpeed(-5);
                break;
            case (KeyEvent.VK_S):
                gamePanel.changeYSpeed(5);
                break;
            case (KeyEvent.VK_D):
                gamePanel.changeXSpeed(5);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
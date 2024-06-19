package Inputs;

import Main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {

    private GamePanel gamePanel;

    public boolean wPressed = false;
    public boolean aPressed = false;
    public boolean sPressed = false;
    public boolean dPressed = false;
    public boolean shiftPressed = false;

    public boolean leftFacing = false;
    public boolean rightFacing = true;

    public KeyInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        wPressed = false;
        aPressed = false;
        sPressed = false;
        System.out.println("I did this");
        dPressed = false;
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
                wPressed = true;
                break;
            case (KeyEvent.VK_A):
                aPressed = true;
                leftFacing = true;
                rightFacing = false;
                break;
            case (KeyEvent.VK_S):
                sPressed = true;
                break;
            case (KeyEvent.VK_D):
                dPressed = true;
                leftFacing = false;
                rightFacing = true;
                break;
            case (KeyEvent.VK_SHIFT):
                shiftPressed = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case (KeyEvent.VK_W):
                wPressed = false;
                break;
            case (KeyEvent.VK_A):
                aPressed = false;
                break;
            case (KeyEvent.VK_S):
                sPressed = false;
                break;
            case (KeyEvent.VK_D):
                dPressed = false;
                break;
            case (KeyEvent.VK_SHIFT):
                shiftPressed = false;
                break;
        }

    }

}

package Main;

import javax.swing.JFrame;

public class GameWindow {
    
    private JFrame jframe;

    /*
     * Method Name: GameWindow
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June, 14, 2024
     * @Description: Constructor for the GameWindow class. Initializes the JFrame and adds the game panel.
     * @Parameters: panel - the GamePanel to add to the JFrame.
     * @Returns: n/a
     * Dependencies: JFrame, GamePanel classes.
     * Throws/Exceptions: n/a
     */

    public GameWindow(GamePanel panel){

        jframe = new JFrame();
        jframe.setSize(800, 800);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel); 
        jframe.setVisible(true);        
    }
}

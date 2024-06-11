package Main;

import javax.swing.JFrame;

public class GameWindow {
    
    private JFrame jframe;

    public GameWindow(GamePanel panel){

        jframe = new JFrame();
        jframe.setSize(800, 800);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel); 
        jframe.setVisible(true);        
    }
}

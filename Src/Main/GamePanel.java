package Main;

import javax.swing.JPanel;
import Player.Player;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    
    Player player; 
    Game game; 
    
    public GamePanel(Game game){
        this.game = game; 
        setFocusable(true);
        player = new Player(); 
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.render(g);
    }

}



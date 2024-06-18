package Main;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import Inputs.MouseInputs;
import Player.Player;

public class GamePanel extends JPanel {
    private Game game; 

    public GamePanel(Game game) {
        this.game = game;
        setFocusable(true);
        addMouseListener(new MouseInputs(this));
    }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            game.draw(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Game getGame() {
        return game; 
    }

}

package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import Inputs.KeyInputs;
import Inputs.MouseInputs;
import Player.Player;



public class GamePanel extends JPanel {
    private Game game; 
    public JButton damage = new JButton("Damage");
    public JButton heal = new JButton("Heal"); 
    public JButton easy = new JButton("Difficult: Easy");
    public JButton normal = new JButton("Difficult: Normal");  
    public JButton hard = new JButton("Difficult: Hard"); 

    /*
     * Method Name: GamePanel
     * @Author:  Devadath Pillai
     * @Date: June 6, 2024
     * @Modified: June 8, 2024
     * @Description: Constructor for the GamePanel class. Sets up the panel, buttons, and input listeners.
     * @Parameters: game - the Game instance associated with this panel.
     * @Returns: n/a
     * Dependencies: Game, MouseInputs, KeyInputs classes.
     * Throws/Exceptions: n/a
     */

    public GamePanel(Game game) {
        this.game = game;
        setFocusable(true);

        damage.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
              buttonClicked(e);
            } 
          } );

        heal.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            buttonClicked(e);
        } 
        });
        
        easy.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                buttonClicked(e);
            } 
        });

        normal.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                buttonClicked(e);
            } 
        });

        hard.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                buttonClicked(e);
            } 
        });

        add(heal);
        add(damage);
        add(easy); 
        add(normal);
        add(hard); 
        addMouseListener(new MouseInputs(this));
        addKeyListener(new KeyInputs(this));
    }

    /*
     * Method Name: paintComponent
     * @Author:  Devadath Pillai
     * @Date: June 6, 2024
     * @Modified: June 6, 2024
     * @Description: Overrides the paintComponent method to draw the game state.
     * @Parameters: g - the Graphics context where the game will be drawn.
     * @Returns: void
     * Dependencies: Game class.
     * Throws/Exceptions: n/a
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            game.draw(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Method Name: buttonClicked
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 9, 2024
     * @Description: Handles button click events and performs corresponding actions.
     * @Parameters: e - the ActionEvent triggered by a button click.
     * @Returns: void
     * Dependencies: Game, Playing, DifficultyManager classes.
     * Throws/Exceptions: n/a
     */

    public void buttonClicked(ActionEvent e) { 
        if(e.getActionCommand() == "Damage") { 
            game.getPlaying().getPlayer().changeHealth(-10);
        }
        if(e.getActionCommand() == "Heal") { 
            game.getPlaying().getPlayer().changeHealth(10);
        }
        if(e.getActionCommand() == "Difficult: Easy") { 
            game.getPlaying().getDifficultyManager().setEasyMode(); 
        }
        if(e.getActionCommand() == "Difficult: Normal") { 
            game.getPlaying().getDifficultyManager().setNormalMode(); 
        }
        if(e.getActionCommand() == "Difficult: Hard") { 
            game.getPlaying().getDifficultyManager().setHardMode(); 
        }
        requestFocus(); 
    }

    /*
     * Method Name: getGame
     * @Author:  Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 8, 2024
     * @Description: Returns the Game instance associated with this panel.
     * @Parameters: n/a
     * @Returns: Game - the Game instance.
     * Dependencies: Game class.
     * Throws/Exceptions: n/a
     */

    public Game getGame() {
        return game; 
    }

}

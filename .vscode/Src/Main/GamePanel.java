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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            game.draw(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



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

    public Game getGame() {
        return game; 
    }

}

package Main;

import java.awt.Graphics;

import javax.swing.JPanel;

import Player.Player;

public class GamePanel extends JPanel {
    private Player player;
    // private Boss boss;
    // private DifficultyManager difficultyManager;

    public GamePanel() {
        player = new Player();
        update();
        // boss = new Boss();
        // difficultyManager = new DifficultyManager(boss, player);
    }

    public void update() {
        System.out.println("UPDATE");
        player.update();
        System.out.println("ASD");
        // Update game components here
    }

    public void draw(Graphics g) {
        // player.render(g);
        // Draw game components here
    }

    // public void setEasyMode() {
    //     difficultyManager.setEasyMode();
    // }

    // public void setHardMode() {
    //     difficultyManager.setHardMode();
    // }

    // public void setNormalMode() {
    //     difficultyManager.setNormalMode();
    // }
}

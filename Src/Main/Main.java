package Main;

import java.awt.Graphics;

import Boss.Boss;
import Player.Player;

public class GamePanel {
    private Player player;
    private Boss boss;
    private DifficultyManager difficultyManager;

    public GamePanel() {
        player = new Player(this);
        boss = new Boss();
        difficultyManager = new DifficultyManager(boss, player);
    }

    public void update() {
        player.update();
        // Update game components here
    }

    public void draw(Graphics g) {
        player.draw(g);
        // Draw game components here
    }

    public void setEasyMode() {
        difficultyManager.setEasyMode();
    }

    public void setHardMode() {
        difficultyManager.setHardMode();
    }

    public void setNormalMode() {
        difficultyManager.setNormalMode();
    }
}

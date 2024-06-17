package Main;

import java.awt.Graphics;

import Enemy.Enemy;
import Player.Player;

public class GamePanel {
    private Player player;
    private Enemy enemy;
    private DifficultyManager difficultyManager;

    public GamePanel() {
        player = new Player(this);
        enemy = new Enemy(100); // Example instantiation with base damage
        difficultyManager = new DifficultyManager(enemy, player);
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

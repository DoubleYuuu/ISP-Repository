package Player;

import Entity.Enemy;

public class DifficultyManager {
    private static final double EASY_PLAYER_HEALTH_MULTIPLIER = 1.5;
    private static final double HARD_PLAYER_HEALTH_MULTIPLIER = 0.5;

    private boolean easy;
    private boolean hard;
    private Enemy enemy;
    private Player player;

    public DifficultyManager(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    public void setEasyMode() {
        easy = true;
        hard = false;
        applyDifficultySettings();
    }

    public void setHardMode() {
        easy = false;
        hard = true;
        applyDifficultySettings();
    }

    public void setNormalMode() {
        easy = false;
        hard = false;
        applyDifficultySettings();
    }

    private void applyDifficultySettings() {
        if (easy) {
            player.setMaxHealth((int) (player.getMaxHealth() * EASY_PLAYER_HEALTH_MULTIPLIER));
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        } else if (hard) {
            player.setMaxHealth((int) (player.getMaxHealth() * HARD_PLAYER_HEALTH_MULTIPLIER));
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        } else {
            player.setMaxHealth(Player.DEFAULT_MAX_HEALTH); // Reset to default max health
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        }
    }

}

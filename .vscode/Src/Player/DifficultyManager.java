package Player;

import Entity.Enemy;

public class DifficultyManager {
    private static final double EASY_PLAYER_HEALTH_MULTIPLIER = 1.5;
    private static final double HARD_PLAYER_HEALTH_MULTIPLIER = 0.5;
    private int easyHealth = 200; 
    private int normalHealth = 100; 
    private int hardHealth = 50; 

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
        System.out.println("==================== DIFFICULTY CHANGED =======================");
        System.out.print("Player Health " + player.getMaxHealth() + " -----> ");
        if (easy) {
            player.setMaxHealth(easyHealth);
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        } else if (hard) {
            player.setMaxHealth(hardHealth);
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        } else {
            player.setMaxHealth(normalHealth); // Reset to default max health
            player.setCurrentHealth(player.getMaxHealth()); // Reset health to full on difficulty change
        }
        System.out.println(player.getMaxHealth());

    }

}

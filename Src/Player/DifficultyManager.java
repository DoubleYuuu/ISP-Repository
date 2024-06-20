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

    /*
     * Method Name: DifficultyManager
     * @Author: Devadath Pillai
     * @Date: June 6, 2024
     * @Modified: June 6, 2024
     * @Description: Constructor for the DifficultyManager class.
     * @Parameters: enemy - the Enemy instance for difficulty calculations.
     *              player - the Player instance for health adjustments.
     * @Returns: n/a
     * Dependencies: Enemy, Player classes.
     * Throws/Exceptions: n/a
     */

    public DifficultyManager(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }

    /*
     * Method Name: setEasyMode
     * @Author: Devadath Pillai
     * @Date: June 6, 2024
     * @Modified: June 6, 2024
     * @Description: Sets the game difficulty to Easy mode.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void setEasyMode() {
        easy = true;
        hard = false;
        applyDifficultySettings();
    }

    /*
     * Method Name: setHardMode
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 7, 2024
     * @Description: Sets the game difficulty to Hard mode.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void setHardMode() {
        easy = false;
        hard = true;
        applyDifficultySettings();
    }

    /*
     * Method Name: setNormalMode
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 7, 2024
     * @Description: Sets the game difficulty to Normal mode.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void setNormalMode() {
        easy = false;
        hard = false;
        applyDifficultySettings();
    }

    /*
     * Method Name: applyDifficultySettings
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 10, 2024
     * @Description: Applies the selected difficulty settings to the player.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Player class.
     * Throws/Exceptions: n/a
     */

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

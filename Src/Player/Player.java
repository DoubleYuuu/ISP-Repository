package Player; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import util.LoadSave; 


public class Player {

    private BufferedImage statusBarImg;
    private BufferedImage playerImg; 
    public static int DEFAULT_MAX_HEALTH = 100; 
    private int statusBarWidth = (int) (815/4);
    private int statusBarHeight = (int) (230/4);
    private int statusBarX = (int) (10);
    private int statusBarY = (int) (50);



    private int healthBarWidth = (int) (140);
    private int healthBarHeight = (int) (17);
    private int healthBarXStart = (int) (57);
    private int healthBarYStart = (int) (18);

    private int healthWidth = healthBarWidth;
    private int playerX = 100; 


    private int maxHealth = 100;
    private int currentHealth = maxHealth;

    /*
     * Method Name: Player
     * @Author: Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: n/a
     * @Description: Constructor for the Player class.
     * @Parameters: n/a
     * @Returns: n/a
     * Dependencies: LoadSave class.
     * Throws/Exceptions: n/a
     */

    public Player() { 
        loadAnimations();
    }

    /*
     * Method Name: update
     * @Author: Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: n/a
     * @Description: Updates player state and animations.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    
    public void update(){
        updateHealthBar();
        updatePOS();
        updateAnimationTick();
        setAnimation();

    }

    /*
     * Method Name: updateHealthBar
     * @Author: Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: n/a
     * @Description: Updates the player's health bar based on current health.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    private void updateHealthBar(){
        healthWidth = (int)((currentHealth / (float)maxHealth) * healthBarWidth);

    }

     /*
     * Method Name: render
     * @Author: Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: n/a
     * @Description: Renders the player UI on screen.
     * @Parameters: g - the Graphics object to render on.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void render(Graphics g) {
        drawUI(g);
    }

    /*
     * Method Name: drawUI
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: n/a
     * @Description: Draws the player's UI components on screen.
     * @Parameters: g - the Graphics object to draw on.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    private void drawUI(Graphics g) {
        g.drawImage(statusBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
        g.drawImage(playerImg, playerX, 500, null);
        g.setColor(Color.red);
        g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, healthWidth, healthBarHeight);
        update();
    }

     /*
     * Method Name: changeHealth
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 7, 2024
     * @Description: Changes the player's current health.
     * @Parameters: value - the amount to change the health by (positive or negative).
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void changeHealth(int value) {

        currentHealth += value;
        if(currentHealth <= 0) {
            currentHealth = 0;
        } else if (currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
    }

    /*
     * Method Name: loadAnimations
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 8, 2024
     * @Description: Loads animations and images for the player.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: LoadSave class.
     * Throws/Exceptions: n/a
     */

    private void loadAnimations() {

        statusBarImg = LoadSave.GetSpriteAtlas(LoadSave.HEALTH_BAR);
        playerImg = LoadSave.GetSpriteAtlas(LoadSave.PLAYER);

    }

    //these are placeholders for now, until Imad does player:

    private void updatePOS() { //POS being like position

    }

    private void updateAnimationTick() { //updates aniamtion tick

    }

    private void setAnimation() { //setting the anims

    }

    public void setMaxHealth(int health) { 
        this.maxHealth = health; 
    }

    public int getMaxHealth() { 
        return maxHealth; 
    }

    public int getCurrentHealth() { 
        return currentHealth; 
    }

    public void setCurrentHealth(int health) { 
        this.currentHealth = health;
    }

    /*
     * Method Name: keyPressed
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 9, 2024
     * @Description: Handles key press events for player movement.
     * @Parameters: e - the KeyEvent instance representing the key press event.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void keyPressed(KeyEvent e) { 
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                playerX -= 3;
                break;
            case KeyEvent.VK_D:
                playerX += 3;
            break;

        }
    }

    public int getPlayerX() { 
        return playerX;
    }
    
    
}

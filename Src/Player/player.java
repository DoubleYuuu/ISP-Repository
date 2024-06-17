package Player; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.LoadSave; 


public class Player {



    private BufferedImage statusBarImg;
    public static int DEFAULT_MAX_HEALTH = 100; 
    private int statusBarWidth = (int) (815/4);
    private int statusBarHeight = (int) (230/4);
    private int statusBarX = (int) (10);
    private int statusBarY = (int) (10);

    private int maxHealth = 100;
    private int currentHealth = maxHealth;

    private int healthBarWidth = (int) (280);
    private int healthBarHeight = (int) (17);
    private int healthBarXStart = (int) (57);
    private int healthBarYStart = (int) (18);

    private int healthWidth = healthBarWidth;

    public Player() { 
        loadAnimations();
    }
    
    public void update(){
        updateHealthBar();
        updatePOS();
        updateAnimationTick();
        setAnimation();

    }

    private void updateHealthBar(){
        System.out.println(currentHealth);
        healthWidth = (int)((currentHealth / (float)maxHealth) * healthBarWidth);

    }

    public void render(Graphics g) {
        // drawUI(g);
    }

    // private void drawUI(Graphics g) {

    //     g.drawImage(statusBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
    //     g.setColor(Color.red);
    //     g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, 100, 400);
    //     update();
    // }

    public void changeHealth(int value) {

        currentHealth += value;
        if(currentHealth <= 0) {
            currentHealth = 0;
        } else if (currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
    }

    private void loadAnimations() {

        statusBarImg = LoadSave.getSpriteAtlas(LoadSave.HEALTH_BAR);

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

    public void setCurrentHealth(int health) { 
        this.currentHealth = health;
    }
}

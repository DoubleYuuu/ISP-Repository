package Player; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.LoadSave; 


public class Player {



    private BufferedImage statusBarImg;

    private int statusBarWidth = (int) (815/4);
    private int statusBarHeight = (int) (230/4);
    private int statusBarX = (int) (10);
    private int statusBarY = (int) (10);

    private int maxHealth = 100;
    private int currentHealth = maxHealth;

    private int healthBarWidth = (int) (140);
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

        healthWidth = (int)((currentHealth / (float)maxHealth) * healthBarWidth);

    }

    public void render(Graphics g) {
        drawUI(g);
    }

    private void drawUI(Graphics g) {

        g.drawImage(statusBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
        g.setColor(Color.red);
        g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, healthWidth, healthBarHeight);
        update();
    }

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
}

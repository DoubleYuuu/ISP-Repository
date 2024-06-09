package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import util.LoadSave;

public class player {



    private BufferedImage statusBarImg;

    private int statusBarWidth = (int) (815 * Game.SCALE);
    private int statusBarHeight = (int) (230 * Game.SCALE);
    private int statusBarX = (int) (10 * Game.SCALE);
    private int statusBarY = (int) (10 * Game.SCALE);

    private int maxHealth = 100;
    private int currentHealth = maxHealth;

    private int healthBarWidth = (int) (553 * Game.SCALE);
    private int healthBarHeight = (int) (67 * Game.SCALE);
    private int healthBarXStart = (int) (10 * Game.SCALE);
    private int healthBarYStart = (int) (10 * Game.SCALE);

    private int healthWidth = healthBarWidth;

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

        statusBarImg = LoadSave.GetSpriteAtlas(LoadSave.STATUS_BAR);

    }

    //these are placeholders for now, until Imad does player:

    private void updatePOS() { //POS being like position

    }

    private void updateAnimationTick() { //updates aniamtion tick

    }

    private void setAnimation() { //setting the anims

    }

}

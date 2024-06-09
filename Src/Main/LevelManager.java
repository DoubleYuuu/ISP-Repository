package Main;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import util.LoadSave;

/**
 * The level manager class is responsible for managing the levels of the game
 * It handles loading level resources, drawing the level on the screen, 
 * and transitioning between levels
 */
public class LevelManager {

    // constructor
    private Game game;
    private BufferedImage levelSprite;
    private int currentLevel;

    public LevelManager(Game game){
        this.game = game;
        this.currentLevel = 1;
        loadLevel(currentLevel);
    }

    /**
     * Loads the specifies level's resources 
     * */ 
    private void loadLevel(int level){
        // update levelSprite based on current level
        levelSprite = LoadSave.getSprite("level" + level + ".png");
        if (levelSprite == null){
            System.out.println(" Error: Level " + " could not be loaded.");
        }
    }

    /**
     * Draws the current level by incrementing the current level and loading 
     * its resources. 
     * @param g
     */
    public void draw(Graphics g) {
        if (levelSprite != null){
            g.drawImage(levelSprite, 0, 0, null);
        } 
    }

    /**
     * Advance to the next level by incrementing the current level and resources
     */
    public void nextLevel(){
        currentLevel++;
        loadLevel(currentLevel);
    }

    /**
     * Moves to the previous level if current level is greater than 1
     * by decrementing the current level and loaidng its resources
     */
    public void previousLevel() {
        if (currentLevel > 1){
            currentLevel--;
            loadLevel(currentLevel);
        }
    }
/*
 * Returns the current level number 
 */
    public int getCurrentLevel() {
        return currentLevel;
    }
}


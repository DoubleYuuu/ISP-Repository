// Parnia YazdanParast

package main;

import java.awt.Grapics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import util.LoadSave;

/*
 * This class represents the levels in the game
 * Levels including: Forest Level, Desert Level, Volacno Level
 * This class manages the loading, drawingn and updating the levels
 */

 public class Level {
    private BufferedImage background; // background image of the level
    private List<Entity> entitiesl; // List of entities
    private BufferedImage[] levelTiles; // array of tiles for the level

    // constructor
    public Level (String backgrounfPath) {
        this.background = LoadSave.getSprite(backgroundPath);
        this.entities = new ArrayList<>();
        loadLeve();
    }

    /*
     * This method loads the level resources
     * it should be customized for each specific level
     */

     public void loadLevel(){
        // load level's tiles 
        levelTiles  new BufferedImage[4];
        levelTiles[0] = LoadSave.getSprite("forest_tile1.png");
        levelTiles[1] = LoadSave.getSprite("forest_tile1.png");
        levelTiles[2] = LoadSave.getSprite("forest_tile1.png");
        levelTiles[3] = LoadSave.getSprite("forest_tile1.png");
     }
 }
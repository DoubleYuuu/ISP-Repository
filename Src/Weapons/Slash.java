package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import Main.Playing;
import util.LoadSave;

public class Slash { //slashes from a sword
    private BufferedImage slashSprite;
    int x = 100;
    int y = 100;
    int update = 0;
    private int initialPos = 0; 
    private boolean e = false; 
    private Entity entity;
    private Playing playing; 

    /*
     * Method Name: Slash
     * @Author: Devadath Pillai
     * @Date: June 1, 2024
     * @Modified: June 9, 2024
     * @Description: Constructor for the Slash class. Initializes the slash sprite,
     *               entity, and playing instance variables.
     * @Parameters: entity - the Entity instance representing the target entity.
     *              playing - the Playing instance representing the current game state.
     * @Returns: n/a
     * Dependencies: LoadSave.GetSpriteAtlas
     * Throws/Exceptions: n/a
     */

    public Slash(Entity entity, Playing playing) {
        slashSprite = LoadSave.GetSpriteAtlas("slash.png"); 
        this.entity = entity;
        this.playing = playing; 
    }

    /*
     * Method Name: draw
     * @Author: Devadath Pillai
     * @Date:  June 1, 2024
     * @Modified: June 9, 2024
     * @Description: Draws the slash on the screen and updates its position.
     *               Also, checks if the slash has traveled a certain distance
     *               to reduce the entity's health.
     * @Parameters: g - the Graphics instance used for drawing the slash.
     * @Returns: void
     * Dependencies: playing.getPlayer().getPlayerX(), update()
     * Throws/Exceptions: n/a
     */


    public void draw(Graphics g) {
        if(!e) { 
            initialPos = playing.getPlayer().getPlayerX() + 50;
            x = initialPos;
            e = true; 
        }

        if (x < initialPos + 100) {
            g.drawImage(slashSprite, x, 470, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    /*
     * Method Name: update
     * @Author: Devadath Pillai
     * @Date:  June 1, 2024
     * @Modified: June 9, 2024
     * @Description: Updates the position of the slash.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void update() {
        x++;
    }
}

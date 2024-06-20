package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import Main.Playing;
import util.LoadSave;

public class Arrow {
    private BufferedImage arrowSprite;
    int x = 100;
    int y = 100;
    private Entity entity;
    private Playing playing; 
    private boolean e = false; 
    private int initialPos = 0; 

     /*
     * Method Name: Arrow
     * @Author: Devadath Pillai
     * @Date: June 2, 2024
     * @Modified: June 9, 2024
     * @Description: Constructor for the Arrow class. Initializes the arrow sprite, 
     *               entity, and playing instance variables.
     * @Parameters: entity - the Entity instance representing the target entity.
     *              playing - the Playing instance representing the current game state.
     * @Returns: n/a
     * Dependencies: LoadSave.GetSpriteAtlas
     * Throws/Exceptions: n/a
     */

    public Arrow(Entity entity, Playing playing) {
        arrowSprite = LoadSave.GetSpriteAtlas("arrow.png");
        this.entity = entity;
        this.playing = playing;
    }

    /*
     * Method Name: draw
     * @Author: Devadath Pillai
     * @Date: June 2, 2024
     * @Modified: June 9, 2024
     * @Description: Draws the arrow on the screen and updates its position.
     *               Also, checks if the arrow has traveled a certain distance
     *               to reduce the entity's health.
     * @Parameters: g - the Graphics instance used for drawing the arrow.
     * @Returns: void
     * Dependencies: playing.getPlayer().getPlayerX(), update()
     * Throws/Exceptions: n/a
     */

    public void draw(Graphics g) {
        if(!e) { 
            initialPos = playing.getPlayer().getPlayerX() + 100;
            x = initialPos;
            e = true; 
        }

        if (x < initialPos + 500) {
            g.drawImage(arrowSprite, x, 590, 100, 25, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    /*
     * Method Name: update
     * @Author: Devadath Pillai
     * @Date: June 2, 2024
     * @Modified: June 9, 2024
     * @Description: Updates the position of the arrow.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void update() {
        x++;
    }
}

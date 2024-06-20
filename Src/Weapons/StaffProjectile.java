package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import Main.Playing;
import util.LoadSave;

public class StaffProjectile { // a magic ball like thing sent from staff/wand use
    private BufferedImage staffProjectileSprite;
    int x = 200;
    int y = 100;
    private Entity entity;
    private Playing playing; 
    private boolean e = false;
    private int initialPos = 0; 

     /*
     * Method Name: StaffProjectile
     * @Author: Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 9, 2024
     * @Description: Constructor for the StaffProjectile class. Initializes the projectile sprite,
     *               entity, and playing instance variables. Sets the initial x position based on
     *               the player's position.
     * @Parameters: entity - the Entity instance representing the target entity.
     *              playing - the Playing instance representing the current game state.
     * @Returns: n/a
     * Dependencies: LoadSave.GetSpriteAtlas
     * Throws/Exceptions: n/a
     */

    public StaffProjectile(Entity entity, Playing playing) {
        staffProjectileSprite = LoadSave.GetSpriteAtlas("staff_projectile.png"); 
        this.entity = entity;
        this.playing = playing; 
        x = playing.getPlayer().getPlayerX();

    }

    /*
     * Method Name: draw
     * @Author: Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 9, 2024
     * @Description: Draws the staff projectile on the screen and updates its position.
     *               Also, checks if the projectile has traveled a certain distance
     *               to reduce the entity's health.
     * @Parameters: g - the Graphics instance used for drawing the staff projectile.
     * @Returns: void
     * Dependencies: playing.getPlayer().getPlayerX(), update()
     * Throws/Exceptions: n/a
     */

    public void draw(Graphics g) {
        if(!e) { 
            initialPos = playing.getPlayer().getPlayerX();
            x = initialPos+300;
            e = true; 
        }

        if (x < initialPos + 700) {
            g.drawImage(staffProjectileSprite, x, 500, -200, 200, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    /*
     * Method Name: update
     * @Author: Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 9, 2024
     * @Description: Updates the position of the staff projectile.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */


    public void update() {
        x++;
    }
}

package Weapons;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;
import Main.GamePanel;
import Main.Playing;

public class WeaponManager {
    private List<Arrow> arrows;
    private List<Slash> slashes;
    private List<StaffProjectile> staffProjectiles;
    private Entity entity;
    private Playing playing; 

    /*
     * Method Name: WeaponManager
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Constructor for the WeaponManager class. Initializes lists for each type of weapon
     *               and sets the entity and playing instance variables.
     * @Parameters: entity - the Entity instance representing the target entity.
     *              playing - the Playing instance representing the current game state.
     * @Returns: n/a
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public WeaponManager(Entity entity, Playing playing) {
        this.entity = entity;
        arrows = new ArrayList<>();
        slashes = new ArrayList<>();
        staffProjectiles = new ArrayList<>();
        this.playing = playing; 
    }

    /*
     * Method Name: addArrow
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Adds a new Arrow instance to the list of arrows.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Arrow
     * Throws/Exceptions: n/a
     */

    public void addArrow() {
        arrows.add(new Arrow(entity,playing));
    }

    /*
     * Method Name: addSlash
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Adds a new Slash instance to the list of slashes.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Slash
     * Throws/Exceptions: n/a
     */

    public void addSlash() {
        slashes.add(new Slash(entity,playing));
    }

    /*
     * Method Name: addStaffProjectile
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Adds a new StaffProjectile instance to the list of staff projectiles.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: StaffProjectile
     * Throws/Exceptions: n/a
     */


    public void addStaffProjectile() {
        staffProjectiles.add(new StaffProjectile(entity,playing));
    }

    /*
     * Method Name: drawAll
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Draws all weapons on the screen.
     * @Parameters: g - the Graphics instance used for drawing the weapons.
     * @Returns: void
     * Dependencies: Arrow.draw, Slash.draw, StaffProjectile.draw
     * Throws/Exceptions: n/a
     */

    public void drawAll(Graphics g) {
        for (Arrow arrow : arrows) {
            arrow.draw(g);
        }
        for (Slash slash : slashes) {
            slash.draw(g);
        }
        for (StaffProjectile staffProjectile : staffProjectiles) {
            staffProjectile.draw(g);
        }
    }

    /*
     * Method Name: updateAll
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified: June 13, 2024
     * @Description: Updates the positions of all weapons.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Arrow.update, Slash.update, StaffProjectile.update
     * Throws/Exceptions: n/a
     */


    public void updateAll() { 
        for (Arrow arrow : arrows) {
            arrow.update(); 
        }
        for (Slash slash : slashes) {
            slash.update();
        }
        for (StaffProjectile staffProjectile : staffProjectiles) {
            staffProjectile.update();
        }
    }
}

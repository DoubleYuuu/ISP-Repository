package Entity;

import java.awt.Graphics;

public class Enemy {
    private double baseDamage;
    private double damage;

    /*
     * Method Name: Enemy
     * @Author: Devadath Pillai
     * @Date: 5th June, 2024
     * @Modified: 5th June, 2024
     * @Description: Constructor for the Enemy class.
     * @Parameters: baseDamage - the initial damage value for the enemy.
     * @Returns: n/a
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public Enemy(double baseDamage) {
        this.baseDamage = baseDamage;
        this.damage = baseDamage;
    }

    /*
     * Method Name: getBaseDamage
     * @Author:  Devadath Pillai
     * @Date: 8th June, 2024
     * @Modified: 8th June, 2024
     * @Description: Retrieves the base damage value of the enemy.
     * @Parameters: n/a
     * @Returns: double - the base damage value.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public double getBaseDamage() {
        return baseDamage;
    }

    /*
     * Method Name: getDamage
     * @Author:  Devadath Pillai
     * @Date: 8th June, 2024
     * @Modified: 8th June, 2024
     * @Description: Retrieves the current damage value of the enemy.
     * @Parameters: n/a
     * @Returns: double - the current damage value.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public double getDamage() {
        return damage;
    }

    /*
     * Method Name: setDamage
     * @Author:  Devadath Pillai
     * @Date: 8th June, 2024
     * @Modified: 8th June, 2024
     * @Description: Sets the current damage value of the enemy.
     * @Parameters: damage - the new damage value to be set.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void setDamage(double damage) {
        this.damage = damage;
    }

    
}

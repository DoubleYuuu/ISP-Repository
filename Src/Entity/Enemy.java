package Entity;

import java.awt.Graphics;

public class Enemy {
    private double baseDamage;
    private double damage;

    public Enemy(double baseDamage) {
        this.baseDamage = baseDamage;
        this.damage = baseDamage;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    
}

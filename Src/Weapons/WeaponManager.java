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

    public WeaponManager(Entity entity, Playing playing) {
        this.entity = entity;
        arrows = new ArrayList<>();
        slashes = new ArrayList<>();
        staffProjectiles = new ArrayList<>();
        this.playing = playing; 
    }

    public void addArrow() {
        arrows.add(new Arrow(entity,playing));
    }

    public void addSlash() {
        slashes.add(new Slash(entity,playing));
    }

    public void addStaffProjectile() {
        staffProjectiles.add(new StaffProjectile(entity,playing));
    }

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

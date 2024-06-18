package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import util.LoadSave;

public class StaffProjectile { // a magic ball like thing sent from staff/wand use
    private BufferedImage staffProjectileSprite;
    int x = 100;
    int y = 100;
    private Entity entity;

    public StaffProjectile(Entity entity) {
        staffProjectileSprite = LoadSave.GetSpriteAtlas("staff_projectile.png"); 
        this.entity = entity;
    }

    public void draw(Graphics g) {
        System.out.println(x);
        if (x < 600) {
            g.drawImage(staffProjectileSprite, x, y, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    public void update() {
        x++;
    }
}

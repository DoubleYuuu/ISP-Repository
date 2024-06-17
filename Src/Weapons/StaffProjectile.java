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
    private GamePanel gamePanel;
    private Entity entity;

    public StaffProjectile(GamePanel gamePanel, Entity entity) {
        staffProjectileSprite = LoadSave.getSpriteAtlas("staff_projectile.png"); 
        this.gamePanel = gamePanel;
        this.entity = entity;
    }

    public void draw(Graphics g) {
        if (x < 600) {
            g.drawImage(staffProjectileSprite, x, y, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    private void update() {
        x++;
    }
}

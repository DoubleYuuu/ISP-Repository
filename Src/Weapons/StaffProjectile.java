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

    public StaffProjectile(Entity entity, Playing playing) {
        staffProjectileSprite = LoadSave.GetSpriteAtlas("staff_projectile.png"); 
        this.entity = entity;
        this.playing = playing; 
        x = playing.getPlayer().getPlayerX();

    }

    public void draw(Graphics g) {
        if(!e) { 
            initialPos = playing.getPlayer().getPlayerX();
            x = initialPos+300;
            e = true; 
        }

        if (x < initialPos + 500) {
            g.drawImage(staffProjectileSprite, x, 500, -200, 200, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    public void update() {
        x++;
    }
}

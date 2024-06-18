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

    public Slash(Entity entity, Playing playing) {
        slashSprite = LoadSave.GetSpriteAtlas("slash.png"); 
        this.entity = entity;
        this.playing = playing; 
    }

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

    public void update() {
        x++;
    }
}

package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import util.LoadSave;

public class Slash { //slashes from a sword
    private BufferedImage slashSprite;
    int x = 100;
    int y = 100;
    private Entity entity;

    public Slash(Entity entity) {
        slashSprite = LoadSave.GetSpriteAtlas("slash.png"); 
        this.entity = entity;
    }

    public void draw(Graphics g) {
        if (x < 600) {
            g.drawImage(slashSprite, x, y, null);
        } else {
            entity.hp -= 10;
        }
    }

    public void update() {
        x++;
    }
}

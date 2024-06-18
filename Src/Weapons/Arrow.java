package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import Main.Playing;
import util.LoadSave;

public class Arrow {
    private BufferedImage arrowSprite;
    int x = 100;
    int y = 100;
    private Entity entity;
    private Playing playing; 

    public Arrow(Entity entity, Playing playing) {
        arrowSprite = LoadSave.GetSpriteAtlas("arrow.png");
        this.entity = entity;
        this.playing = playing;
    }

    public void draw(Graphics g) {
        x = playing.getPlayer().getPlayerX(); 
        if (x < playing.getPlayer().getPlayerX()+100) {
            g.drawImage(arrowSprite, x, 500, null);
        } else {
            entity.hp -= 10;
        }
    }

    public void update() {
        x++;
    }
}

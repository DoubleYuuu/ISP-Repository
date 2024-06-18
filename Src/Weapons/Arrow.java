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
    private boolean e = false; 
    private int initialPos = 0; 

    public Arrow(Entity entity, Playing playing) {
        arrowSprite = LoadSave.GetSpriteAtlas("arrow.png");
        this.entity = entity;
        this.playing = playing;
    }

    public void draw(Graphics g) {
        if(!e) { 
            initialPos = playing.getPlayer().getPlayerX() + 100;
            x = initialPos;
            e = true; 
        }

        if (x < initialPos + 500) {
            g.drawImage(arrowSprite, x, 590, 100, 25, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    public void update() {
        x++;
    }
}

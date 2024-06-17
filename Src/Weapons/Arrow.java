package Weapons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import util.LoadSave;

public class Arrow {
    private BufferedImage arrowSprite;
    int x = 100;
    int y = 100;
    private GamePanel gamePanel;
    private Entity entity;

    public Arrow(GamePanel gamePanel, Entity entity) {
        arrowSprite = LoadSave.getSpriteAtlas("arrow.png");
        this.gamePanel = gamePanel;
        this.entity = entity;
    }

    public void draw(Graphics g) {
        if (x < 600) {
            g.drawImage(arrowSprite, x, y, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    private void update() {
        x++;
    }
}

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
    private GamePanel gamePanel;
    private Entity entity;

    public Slash(GamePanel gamePanel, Entity entity) {
        slashSprite = LoadSave.getSpriteAtlas("slash.png"); 
        this.gamePanel = gamePanel;
        this.entity = entity;
    }

    public void draw(Graphics g) {
        if (x < 600) {
            g.drawImage(slashSprite, x, y, null);
        } else {
            entity.hp -= 10;
        }
        update();
    }

    private void update() {
        x++;
    }
}

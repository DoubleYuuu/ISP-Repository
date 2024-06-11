import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Main.GamePanel;
import util.LoadSave;

public class Test 
{
    private BufferedImage arrowSprite;
    int x = 100;
    int y = 100;
    private GamePanel gamePanel;
    private Entity entity;

    public Test(GamePanel gamePanel, Entity entity)
    {
        arrowSprite = LoadSave.getSpriteAtlas("arrow.png");
        this.gamePanel = gamePanel;
        this.entity = entity;
    }

    public void draw(Graphics g)
    {
        if (x < 600) g.drawImage(arrowSprite, x, y, null);
        else entity.hp -= 10;
        update();
    }

    private void update()
    {
        x++;
    }
}

if (easy) 
{
    boss.damage *= 0.5;
    player.damage *= 2;
}

else if (hard)
{
    boss.damage *= 2;
    player.damage *= 0.5;
}
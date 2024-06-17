package Entity;

import Main.GamePanel;

public abstract class Entity {
    protected GamePanel gamePanel;
    public int hp = 100; 

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public abstract void update();

    public abstract void draw();
}

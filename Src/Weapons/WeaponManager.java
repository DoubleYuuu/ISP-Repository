import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Entity.Entity;
import Main.GamePanel;

public class WeaponManager {
    private List<Arrow> arrows;
    private List<Slash> slashes;
    private List<StaffProjectile> staffProjectiles;
    private GamePanel gamePanel;
    private Entity entity;

    public WeaponManager(GamePanel gamePanel, Entity entity) {
        this.gamePanel = gamePanel;
        this.entity = entity;
        arrows = new ArrayList<>();
        slashes = new ArrayList<>();
        staffProjectiles = new ArrayList<>();
    }

    public void addArrow() {
        arrows.add(new Arrow(gamePanel, entity));
    }

    public void addSlash() {
        slashes.add(new Slash(gamePanel, entity));
    }

    public void addStaffProjectile() {
        staffProjectiles.add(new StaffProjectile(gamePanel, entity));
    }

    public void drawAll(Graphics g) {
        for (Arrow arrow : arrows) {
            arrow.draw(g);
        }
        for (Slash slash : slashes) {
            slash.draw(g);
        }
        for (StaffProjectile staffProjectile : staffProjectiles) {
            staffProjectile.draw(g);
        }
    }
}

package Main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Entity.Enemy;
import Entity.Entity;
import Player.DifficultyManager;
import Player.Player;
import Weapons.Slash;
import Weapons.StaffProjectile;
import Weapons.WeaponManager;
import util.LoadSave;

public class Playing {

    private Player player; 
    private Slash slash; 
    private StaffProjectile staffProjectile; 
    private WeaponManager weaponManager; 
    private Entity entity; 
    private Game game; 
    private DifficultyManager difficultyManager; 
    private BufferedImage background; 

    public Playing(Game game) { 
        this.player = new Player();
        this.entity = new Entity();
        this.weaponManager = new WeaponManager(entity,this);
        this.difficultyManager = new DifficultyManager(new Enemy(200), player);
        this.game = game;
        background = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND); 
    }

    public void update() { 
        player.update();
        weaponManager.updateAll();
    }

    public void draw(Graphics g) { 
        g.drawImage(background, 0, 0, 800, 800, null);
        player.render(g);
        weaponManager.drawAll(g);
    }

    public void mouseClicked(MouseEvent e) { 
        if(e.getButton() == 1)
        weaponManager.addSlash();
        else if(e.getButton() == 3)
        weaponManager.addStaffProjectile();
    }


    public void keyPressed(KeyEvent e) { 
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F:
            weaponManager.addArrow();
            break;

        }
    }

    
    public Player getPlayer() { 
        return player;
    }

    public DifficultyManager getDifficultyManager() { 
        return difficultyManager; 
    }
    
}

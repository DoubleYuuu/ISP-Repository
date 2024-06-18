package Main;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import Entity.Enemy;
import Entity.Entity;
import Player.DifficultyManager;
import Player.Player;
import Weapons.Slash;
import Weapons.StaffProjectile;
import Weapons.WeaponManager;

public class Playing {

    private Player player; 
    private Slash slash; 
    private StaffProjectile staffProjectile; 
    private WeaponManager weaponManager; 
    private Entity entity; 
    private Game game; 
    private DifficultyManager difficultyManager; 

    public Playing(Game game) { 
        this.player = new Player();
        this.entity = new Entity();
        this.weaponManager = new WeaponManager(entity,this);
        this.difficultyManager = new DifficultyManager(new Enemy(200), player);
        this.game = game;
    }

    public void update() { 
        player.update();
        weaponManager.updateAll();
    }

    public void draw(Graphics g) { 
        player.render(g);
        weaponManager.drawAll(g);
    }

    public void mouseClicked(MouseEvent e) { 
        if(e.getButton() == 1)
        weaponManager.addSlash();
        else if(e.getButton() == 3)
        weaponManager.addStaffProjectile();
    }

    public Player getPlayer() { 
        return player;
    }

    public DifficultyManager getDifficultyManager() { 
        return difficultyManager; 
    }
    
}

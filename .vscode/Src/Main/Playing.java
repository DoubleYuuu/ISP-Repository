package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Entity.Enemy;
import Entity.Entity;
import Level.LevelManager;
import Player.DifficultyManager;
import Player.Inventory;
import Player.Player;
import Weapons.Slash;
import Weapons.StaffProjectile;
import Weapons.WeaponManager;
import util.LoadSave;

public class Playing extends State {

    private Inventory inventory; 
    private Player player; 
    private Slash slash; 
    private StaffProjectile staffProjectile; 
    private WeaponManager weaponManager; 
    private Entity entity; 
    private Game game; 
    private LevelManager levelManager; 
    private DifficultyManager difficultyManager; 
    private BufferedImage background; 
    private boolean runOnce = false; 
    public static boolean inventoryState = false; // Player states where they should not be moving

    public Playing(Game game) { 
        super(game);
        this.player = new Player();
        this.entity = new Entity();
        this.weaponManager = new WeaponManager(entity,this);
        this.difficultyManager = new DifficultyManager(new Enemy(200), player);
        this.game = game;
        this.inventory = new Inventory();
        this.levelManager = new LevelManager(this); 
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
        levelManager.draw(g);
        if(inventoryState) { 
            inventory.updateGraphics(g);
            inventory.drawInventory(player);
            inventory.characterScreen(player);
        }
    }

    public void mouseClicked(MouseEvent e) { 
        if(e.getButton() == 1)
        weaponManager.addSlash();
        else if(e.getButton() == 3)
        weaponManager.addStaffProjectile();
    }


    public void keyPressed(KeyEvent e) { 
        if(!inventoryState)
        player.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F:
                if(!inventoryState)
                    weaponManager.addArrow();
            break;

            case KeyEvent.VK_E: 
                if(!inventoryState)
                    inventoryState = true; 
            break; 

            case KeyEvent.VK_ESCAPE:
                if(inventoryState)
                    inventoryState = false;
            break; 

            case KeyEvent.VK_W: 
                if(inventoryState && inventory.slotRow != 0)
                    inventory.slotRow--; 
            break; 

            case KeyEvent.VK_A: 
                if(inventoryState && inventory.slotCol != 0)
                    inventory.slotCol--; 
            break; 

            case KeyEvent.VK_S: 
                if(inventoryState && inventory.slotRow != 3)
                    inventory.slotRow++; 
            break;
                case KeyEvent.VK_D: 
                if(inventoryState && inventory.slotCol != 8)
                    inventory.slotCol++; 
            break; 
        }
    }

    
    public Player getPlayer() { 
        return player;
    }

    public Inventory getInventory() { 
        return inventory;
    }

    public DifficultyManager getDifficultyManager() { 
        return difficultyManager; 
    }
    
}

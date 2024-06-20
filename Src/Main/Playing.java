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

     /*
     * Method Name: Playing
     * @Authors:  Devadath Pillai, Parnia Yazdanparast
     * @Date: June 6th
     * @Modified: June 17th, 2024
     * @Description: Constructor for the Playing class. Initializes game components and managers.
     * @Parameters: game - the Game instance associated with this state.
     * @Returns: n/a
     * Dependencies: Player, Entity, WeaponManager, DifficultyManager, Inventory, LevelManager, Game classes.
     * Throws/Exceptions: n/a
     */

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

    /*
     * Method Name: update
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Updates the game state logic.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Player, WeaponManager classes.
     * Throws/Exceptions: n/a
     */

    public void update() { 
        player.update();
        weaponManager.updateAll();
    }

    /*
     * Method Name: draw
     * @Author: Devadath Pillai, Parnia Yazdanparast
     * @Date: June 8, 2024
     * @Modified: June 17th, 2024
     * @Description: Draws the game state.
     * @Parameters: g - the Graphics context to draw on.
     * @Returns: void
     * Dependencies: Player, WeaponManager, LevelManager, Inventory classes.
     * Throws/Exceptions: n/a
     */

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

    /*
     * Method Name: mouseClicked
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 8, 2024
     * @Description: Handles mouse click events.
     * @Parameters: e - the MouseEvent that occurred.
     * @Returns: void
     * Dependencies: WeaponManager class.
     * Throws/Exceptions: n/a
     */

    public void mouseClicked(MouseEvent e) { 
        if(e.getButton() == 1)
        weaponManager.addSlash();
        else if(e.getButton() == 3)
        weaponManager.addStaffProjectile();
    }

    /*
     * Method Name: keyPressed
     * @Author: Parnia Yazdanparast
     * @Date: June 14, 2024
     * @Modified: June 17, 2024
     * @Description: Handles key press events.
     * @Parameters: e - the KeyEvent that occurred.
     * @Returns: void
     * Dependencies: Player, Inventory, DifficultyManager, WeaponManager classes.
     * Throws/Exceptions: n/a
     */

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

    /*
     * Method Name: getPlayer
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 8, 2024
     * @Description: Returns the Player instance associated with this game state.
     * @Parameters: n/a
     * @Returns: Player - the Player instance.
     * Dependencies: Player class.
     * Throws/Exceptions: n/a
     */
    
    public Player getPlayer() { 
        return player;
    }

    /*
     * Method Name: getInventory
     * @Author: Parnia Yazdanparast
     * @Date: June 15, 2025
     * @Modified: June 15, 2025
     * @Description: Returns the Inventory instance associated with this game state.
     * @Parameters: n/a
     * @Returns: Inventory - the Inventory instance.
     * Dependencies: Inventory class.
     * Throws/Exceptions: n/a
     */

    public Inventory getInventory() { 
        return inventory;
    }

    /*
     * Method Name: getDifficultyManager
     * @Author: Devadath Pillai
     * @Date: June 8, 2024
     * @Modified: June 9, 2024
     * @Description: Returns the DifficultyManager instance associated with this game state.
     * @Parameters: n/a
     * @Returns: DifficultyManager - the DifficultyManager instance.
     * Dependencies: DifficultyManager class.
     * Throws/Exceptions: n/a
     */

    public DifficultyManager getDifficultyManager() { 
        return difficultyManager; 
    }
    
}

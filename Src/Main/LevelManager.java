// Parnia Yazdanparast
// Start: June 3 7th
// End: June
// ISP Project - Boss Bush
package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utilz.LoadSave;

public class LevelManager {
    private Game game;
    private BufferedImage levelSprite;

    public LevelManager(Game game){
        this.game = game;
        levelSprite = LoadSave.getSprite(LoadSave.LEVEL_PL);
    }

    public void draw (Graphics g){
        g.drawImage(levelSprite, 0, 0, null);

    }

    public void update(){
        
    }
}


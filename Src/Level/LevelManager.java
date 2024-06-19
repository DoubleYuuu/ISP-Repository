package Level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Main.Playing;
import util.LoadSave;

public class LevelManager {

    private BufferedImage[] levels;
    private Level level;  

    private Playing playing; 

    public LevelManager(Playing playing) { 
        this.playing = playing; 
        this.level = new Level(LoadSave.GetSpriteAtlas(LoadSave.LEVEL1), playing); 
        loadImg();
    }

    public void loadImg() { 
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.DESERT);
		levels = new BufferedImage[9];
		for (int j = 0; j < 3; j++)
			for (int i = 0; i < 3; i++) {
				int index = j * 3 + i;
				levels[index] = img.getSubimage(i * 128, j * 128, 128, 128);
			}
    }

    public void draw(Graphics g) {
		for (int j = 0; j < level.getLevelData().length; j++)
			for (int i = 0; i < level.getLevelData()[0].length; i++) { 
                int index = level.getSpriteIndex(i, j);
                int x = 32 * i;
				int y = 32 * j;
                if(index != 11)
					g.drawImage(levels[index], x, y, 32, 32, null);
			}
	}

    
}

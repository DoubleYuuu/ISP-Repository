package Level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Entity.Boss;
import Main.Playing;
import Player.Player;



public class Level {

	private BufferedImage img;
	public int[][] lvlData;


	//private ArrayList<EntityType> entityname = new ArrayList<>();

	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;
	private Playing playing;
	private Player player;

	/*
     * Method Name: Level
     * @Author: Parnia Yazdanparast
     * @Date: June 2, 2024
     * @Modified: June 2, 2024
     * @Description: Constructor for the Level class, initializing with an image and a Playing instance.
     * @Parameters: img - the BufferedImage representing the level's layout.
     *              playing - the Playing instance associated with the level.
     * @Returns: n/a
     * Dependencies: n/a
     * Throws/Exceptions: (Some of the code was taken from elsewhere, This would count to the 30% of outside code that you are allowed to use.)
     */

	public Level(BufferedImage img, Playing playing) {
		this.playing = playing; 
		this.img = img; 
		lvlData = new int[img.getHeight()][img.getWidth()]; 
		loadLevel();
	}

	/*
     * Method Name: loadLevel
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 12, 2024
     * @Description: Loads the level data from the image, converting pixel colors to level data.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

	private void loadLevel() {
		for (int y = 0; y < img.getHeight(); y++)
			for (int x = 0; x < img.getWidth(); x++) {
				Color c = new Color(img.getRGB(x, y));
				int red = c.getRed();
				loadLevelData(red, x, y);
			}
	}

	/*
     * Method Name: loadLevelData
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 12, 2024
     * @Description: Loads the level data for a specific tile based on the red value of its color.
     * @Parameters: redValue - the red component of the pixel color.
     *              x - the x-coordinate of the tile.
     *              y - the y-coordinate of the tile.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

	private void loadLevelData(int redValue, int x, int y) {
		if (redValue >= 12)
			lvlData[y][x] = 8;
		else	
			lvlData[y][x] = redValue;
		switch (redValue) {
		}
	}

	/*
     * Method Name: getSpriteIndex
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 12, 2024
     * @Description: Retrieves the sprite index for a given tile coordinate.
     * @Parameters: x - the x-coordinate of the tile.
     *              y - the y-coordinate of the tile.
     * @Returns: int - the sprite index for the specified tile.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
	
	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	 /*
     * Method Name: getLevelData
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 12, 2024
     * @Description: Retrieves the level data array.
     * @Parameters: n/a
     * @Returns: int[][] - the level data array.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

	public int[][] getLevelData() {
		return lvlData;
	}

	/*
     * Method Name: getLvlOffset
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 12, 2024
     * @Description: Retrieves the maximum level offset.
     * @Parameters: n/a
     * @Returns: int - the maximum level offset.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

	public int getLvlOffset() {
		return maxLvlOffsetX;
	}
}
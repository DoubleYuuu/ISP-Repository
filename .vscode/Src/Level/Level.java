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
	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;
	private Playing playing;
	private Player player;


	public Level(BufferedImage img, Playing playing) {
		this.playing = playing; 
		this.img = img; 
		lvlData = new int[img.getHeight()][img.getWidth()]; 
		loadLevel();
	}

	private void loadLevel() {
		for (int y = 0; y < img.getHeight(); y++)
			for (int x = 0; x < img.getWidth(); x++) {
				Color c = new Color(img.getRGB(x, y));
				int red = c.getRed();
				loadLevelData(red, x, y);
			}
	}

	private void loadLevelData(int redValue, int x, int y) {
		if (redValue >= 12)
			lvlData[y][x] = 8;
		else	
			lvlData[y][x] = redValue;
		switch (redValue) {
		}
	}

	
	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	public int[][] getLevelData() {
		return lvlData;
	}

	public int getLvlOffset() {
		return maxLvlOffsetX;
	}
}
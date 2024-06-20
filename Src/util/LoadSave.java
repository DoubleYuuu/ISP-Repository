package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

    public static final String STATUS_BAR = " .png";
    public static final String HEALTH_BAR = "health_bar.png";
	public static final String PLAYER = "player.png";
	public static final String BACKGROUND = "background.png"; 
	public static final String STAFF = "staff.png";
	public static final String SWORD = "sword.png"; 
	public static final String BOW = "bow.png";
	public static final String DESERT = "desert.png"; 
	public static final String LEVEL1 = "1.png"; 

	 /*
     * Method Name: GetSpriteAtlas
     * @Author: Devadath Pillai, Parnia Yazdanparast
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Loads a BufferedImage from the specified file name.
     * @Parameters: fileName - the name of the image file to load.
     * @Returns: BufferedImage - the loaded image.
     * Dependencies: n/a
     * Throws/Exceptions: IOException - if there's an error reading the image file.
     */

    public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}


}

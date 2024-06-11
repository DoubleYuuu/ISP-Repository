package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/*
 * The LoadSave class provides methods to load game resources
 * such as images form th efile system
 */
public class LoadSave {
    public static final String LEVEL_ATLAS = "level_atlas.png";
    
    /*
     * Loads a sprite form the specifies file name.
     */
    public static BufferedImage getSprite(String fileName){
        try (InputStream is = LoadSave.class.getResourceAsStream("/" + fileName)){
            if (is == null){
                throw new IOException("Resource not found: " + fileName);
            }
            return ImageIO.read(is);
        } catch(IOException e){
            System.out.println("error loading the image: " + fileName);
            e.printStackTrace();
            return null;
        }
    }
}

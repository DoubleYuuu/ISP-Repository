// Parnia Yazdanparast
// Start: June 3 7th
// End: June
// ISP Project - Boss Bush

package Main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
 
public class LoadSave {
    public static final String PLAYER = "player_sprites.png";
    public static final String LEVEL_PL = "level_sprites.png";

    public static BufferedImage getSprite (String fileName) {
        // making sure InputStream is cloed automaticallly at the end (using try)
        try(InputStream is = LoadSave.class.getResourceAsStream("/" + fileName)) {
            // if resource was not found, return null
            if (is == null) {
                throw new IOException("Resource not found: " + fileName);
            }
            return ImageIO.read(is);
        } catch (IOException e){
            // using system.err to identify the errors
            System.err.println("Error loading the image: " + fileName);
            e.printStackTrace();
            return null;
        }
        }
    }


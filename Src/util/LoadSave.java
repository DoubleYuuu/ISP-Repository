package util;

// import java.awt.color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

    public static final String STATUS_BAR = " .png";
    public static final String HEALTH_BAR = "health_bar.png";

    public static BufferedImage getSpriteAtlas(String filename) { 
        BufferedImage img = null; 
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename); 
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

package Player;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import util.LoadSave;


public class Inventory {
    
    private Graphics g; 
    public int slotCol = 0; 
    public int slotRow = 0; 
    private ArrayList<BufferedImage> inventory = new ArrayList<>();
    private BufferedImage bow, sword, staff; 
    int inventorySize = 20;

    /*
     * Method Name: Inventory
     * @Author: Parnia Yazdanparast
     * @Date: June 1, 2024
     * @Modified: June 1, 2024
     * @Description: Constructor for the Inventory class.
     * @Parameters: n/a
     * @Returns: n/a
     * Dependencies: LoadSave class.
     * Throws/Exceptions: n/a
     */

    public Inventory() { 
        readImgs();
    }

    /*
     * Method Name: readImgs
     * @Author: Parnia Yazdanparast
     * @Date: June 11, 2024
     * @Modified: June 11, 2024
     * @Description: Loads images for items in the inventory.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: LoadSave class.
     * Throws/Exceptions: n/a
     */

    public void readImgs() { 
        staff = (LoadSave.GetSpriteAtlas(LoadSave.STAFF)); 
        sword = (LoadSave.GetSpriteAtlas(LoadSave.SWORD)); 
        bow =  (LoadSave.GetSpriteAtlas(LoadSave.BOW)); 
    }

    /*
     * Method Name: updateGraphics
     * @Author: Parnia Yazdanparast
     * @Date: June 11, 2024
     * @Modified:  June 11, 2024
     * @Description: Updates the graphics context for drawing.
     * @Parameters: g - the Graphics object to update.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void updateGraphics(Graphics g) { 
        this.g = g; 
    }

    /*
     * Method Name: characterScreen
     * @Author: Parnia Yazdanparast
     * @Date: June 12, 2024
     * @Modified: June 14, 2024
     * @Description: Displays character information on screen.
     * @Parameters: player - the Player instance to display information for.
     * @Returns: void
     * Dependencies: Player class.
     * Throws/Exceptions: n/a
     */

    public void characterScreen(Player player) { 
        int x = 25; 
        int y = 220; 
        int width = 250; 
        int height = 170; 
        drawSubWindow(x, y, width, height, g);

        Graphics2D g2 = (Graphics2D) g; 

        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(22F));

        int textX = x + 20; 
        int textY = y + 40; 
        int lineHeight = 50; 

        g2.drawString("Level", textX, textY);
        textY += lineHeight; 
        g2.drawString("Max Health", textX, textY);
        textY += lineHeight; 
        g2.drawString("Current Health", textX, textY);
        textY += lineHeight; 

        int tailX = (x + width) - 70; 
        textY = y + 40;
        String value; 

        value = String.valueOf(1);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, tailX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getMaxHealth()); 
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, tailX, textY);
        textY += lineHeight;

        value = String.valueOf(player.getCurrentHealth()); 
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, tailX, textY);
        textY += lineHeight;

    }

    /*
     * Method Name: drawInventory
     * @Author: Parnia Yazdanparast
     * @Date: June 13, 2024
     * @Modified: June 15, 2024
     * @Description: Draws the inventory UI on screen.
     * @Parameters: player - the Player instance whose inventory is being displayed.
     * @Returns: void
     * Dependencies: Player class.
     * Throws/Exceptions: n/a
     */

    public void drawInventory(Player player) { 
        int x = 380; 
        int y = 220; 
        int width = 380; 
        int height = 200; 
        drawSubWindow(x, y, width, height, g);

        int slotXStart = x + 20; 
        int slotYStart = y + 20; 
        int slotX = slotXStart; 
        int slotY = slotYStart; 

        g.drawImage(sword, slotX, slotY, 35, 40, null);
        slotX += 40;
        g.drawImage(staff, slotX-4, slotY-2, 37, 43, null);
        slotX += 40;
        g.drawImage(bow, slotX+13, slotY, 10, 40, null);


        int cursorX = slotXStart + (38 * slotCol); 
        int cursorY = slotYStart + (40 * slotRow); 
        int cursorWidth = 40; 
        int cursorHeight = 40; 

        Graphics2D g2 = (Graphics2D) g; 

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 5, 10);
        


    }

    /*
     * Method Name: drawSubWindow
     * @Author: Parnia Yazdanparast
     * @Date: June 16, 2024
     * @Modified: June 16, 2024
     * @Description: Draws a sub-window with rounded corners on screen.
     * @Parameters: x - the x-coordinate of the window.
     *              y - the y-coordinate of the window.
     *              width - the width of the window.
     *              height - the height of the window.
     *              g2 - the Graphics object to draw on.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void drawSubWindow(int x, int y, int width, int height, Graphics g2) { 
        this.g = g2;
        Graphics2D g = (Graphics2D) g2; 
        Color c = new Color(0,0,0, 210); 
        g.setColor(c);
        g.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255); 
        g.setColor(c);
        g.setStroke(new BasicStroke(5));
        g.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

     /*
     * Method Name: getXforAlignToRightText
     * @Author: Parnia Yazdanparast
     * @Date: June 16, 2024
     * @Modified: June 17, 2024
     * @Description: Calculates the x-coordinate for aligning text to the right.
     * @Parameters: text - the text to be aligned.
     *              tailX - the x-coordinate of the right edge.
     * @Returns: int - the x-coordinate for the aligned text.
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public int getXforAlignToRightText(String text, int tailX) { 
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth(); 
        int x = tailX - length; 
        return x; 
    }

    /*
     * Method Name: keyPressed
     * @Author: Parnia Yazdanparast
     * @Date: June 16, 2024
     * @Modified: June 16, 2024
     * @Description: Handles key press events for inventory management.
     * @Parameters: e - the KeyEvent instance representing the key press event.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    
    public void keyPressed(KeyEvent e) { 
        
    }

}

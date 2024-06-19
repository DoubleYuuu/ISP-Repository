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

    public Inventory() { 
        readImgs();
    }

    public void readImgs() { 
        staff = (LoadSave.GetSpriteAtlas(LoadSave.STAFF)); 
        sword = (LoadSave.GetSpriteAtlas(LoadSave.SWORD)); 
        bow =  (LoadSave.GetSpriteAtlas(LoadSave.BOW)); 
    }

    public void updateGraphics(Graphics g) { 
        this.g = g; 
    }

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

    public int getXforAlignToRightText(String text, int tailX) { 
        int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth(); 
        int x = tailX - length; 
        return x; 
    }
    
    public void keyPressed(KeyEvent e) { 
        
    }

}

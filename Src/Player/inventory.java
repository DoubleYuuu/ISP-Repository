// Parnia Yazdanparast

package Player;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

/*
 * The inventory class manages the player's collection of items and weapons.
 * It also includes methods to add, remove and list these itmes.
 */
public class inventory {
    // Array to store weapon images
    private BufferedImage[] weaponImages;
    // List to store the weapon
    private List<Weapon> weapons; 
    // Image atlas containing teh weapon images
    private BufferedImage atlas;; 


    // Dimesnions for image atlas - could change
    private static final int SCREEN_WIDTH = 250;
    private static final int SCREEN_HEIGHT = 250;

    //Constructor
    public inventory(BufferedImage atlas) {
        this.weaponImages = new BufferedImage[4]; // Assuming a max of 4 weapon images
        this.weapons = new ArrayList<>();
        this.atlas = atlas;
        loadWeaponImages();
    }

    /*
    * This method loads the weapon images from the atlas
    */
    private void loadWeaponImages () {
        // dividing it into a 2x2 grid
        int imgWidth = atlas.getWidth() / 2;
        int imgHeight = atlas.getHeight() / 2;

        // load the images into the array
        weaponImages[0] = atlas.getSubimage(0, 0, imgWidth, imgHeight);
        weaponImages[1] = atlas.getSubimage(imgWidth, 0, imgWidth, imgHeight);
        weaponImages[0] = atlas.getSubimage(0, imgHeight, imgWidth, imgHeight);
        weaponImages[0] = atlas.getSubimage(imgWidth, imgHeight, imgWidth, imgHeight);
    }

    /* 
    * This method add weapons to the inventory
    */
    public void addWeapon (Weapon weapon){
        if (weapons.size() < 4){
            weapons.add(weapon);
        } else {
            System.out.println("Inventory is full.");
        }
    }
    
    /*
     * This method removes weapons from the inventroy
     */
    public boolean removeWeapon (Weapon weapon){
        return weapon.remove(weapon);
    }

        /*
         * Lists weapons in the inventory
         */
        public List<String> listweapons() {
            List<String> weaponNames = new ArrayList<>();
            for (Weapon weapon : weapons){
                weaponNames.add(weapon.getName());
            }
            return weaponNames;
        }

        /**
         * This method Draws the inventory on the screen
         */
        public void draw(Graphics g) {
            // draw background
            g.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

            // draw weapon images in inventory
            int squareSize = 100;
            int xOffset = 50;
            int yOffset = 50;

            for (int i = 0; i < weapons.size(); i ++){
                g.drawImage(weaponImages[i], xOffset + (i * squareSize), yOffset, squareSize, squareSize, null);
            }
        }

    /*
     * Checks if the inventory contains a specific weapon
     */
    public boolean hasWeapon (Weapon weapon){
        return weapon.contains(weapon);
    }

    /*
     * get the total number of weapons in inventory
     */
    public int getweaponCount(){
        return weapons.size();
    }
    } // end class




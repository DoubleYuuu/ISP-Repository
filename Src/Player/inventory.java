// Parnia Yazdanparast

package Player;

import java.util.ArrayList;
import java.util.List;

/*
 * The inventory class manages the player's collection of items and weapons.
 * It also includes methods to add, remove and list these itmes.
 */
public class inventory {
    // list to store items and weapons
    private List<Item> items;
    private List<Weapon> weapons; 
    private int maxCapacity; 

    //Constructor
    public void Inventory(int maxCapacity) {
        this.items = new ArrayList<>();
        this.weapons = new ArrayList<> ();
        this.maxCapacity = maxCapacity;
    }

    /*
    * This method adds an item to the inventory
    */
    public boolean addItem (Item item) {
        if (items.size() < maxCapacity){
            items.add(item);
            return true;
        }
        return false;

    }

    /* 
    * This method removes item from the inventory
    */ 
    public boolean removeItem(Item item){
        return items.remove(item);
    }

    /* 
    * This method add weapons to the inventory
    */
    public boolean addWeapon (Weapon weapon){
        if (weapon.size() <maxCapacity){
            weapons.add(weapon);
            return true;
        }
        return false;
    }
    
    /*
     * This method removes weapons from the inventroy
     */
    public boolean removeWeapon (Weapon weapon){
        return weapon.remove(weapon);
    }

    /*
     * checks if the inventory contains a specific item, true if it does.
     */
    public boolean hasItem(Item item){
        return items.contains(item);
    }

    /*
     * Checks if the inventory contains a specific weapon
     */
    public boolean hasWeapon (Weapon weapon){
        return weapon.contains(weapon);
    }

    /*
     * This method  Lists items in the inventory
     */
    public List<String> listItems(){
        List<String> itemNames = new ArrayList<>();
        for (Item item: items){
            itemNames.add(item.getName());
            
        }
        return itemNames;
        }

        /*
         * Lists aa weapons in the inventory
         */
        public List<String> listweapons() {
            List<String> weaponNames = new ArrayList<>();
            for (Weapon weapon : weapons){
                weaponNames.add(weapon.getName());
            }
            return weaponNames;
        }
    }




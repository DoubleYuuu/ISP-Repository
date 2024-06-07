package Main;

public class Game {
    private static String ID;
	
	Game(){
        // player profile information
		private static String ID = "";
        public static String username;
        public static String email;
        // progress and achievements
        private static int level;
        private static int stats;
        // inventory, 
        private InventoryState inventory;
        private Weapon weapon;
        private Item item;
        
	
	Game(String newID, String newUsername, String newEmail, int newLevel, int newStats, Inventory newInventory, Weapon newWeapon, Item newItem){
		ID = newID;
        username = newUsername;
        email = newEmail;
        level = newLevel;
        stats = newStats;
        inventory = newInventory;
        weapon = newWeapon;
        item = newItem;
	}
	
    // please tell me the length and type of each fields so I(Sunmin) can make binaryfile.
	public String getID(){
		return ID; 
	}
    public String getUsername(){
		return username; 
	}
    public String getEmail(){
		return email; 
	}
    public String getLevel(){
		return level; 
	}
    public String getStats(){
		return stats; 
	}
    public String getInventory(){
		return ; inventory
	}
    public String getWeapon(){
		return weapon; 
	}
    public String getItem(){
		return item; 
	}
}

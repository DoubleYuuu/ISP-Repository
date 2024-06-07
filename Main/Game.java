package Main;

public class Game {
    private static String ID;
	
	Game(){
		ID = "";
	}
	
	Game(String newID){
		ID = newID;
	}
	
	public String getID(){
		return ID; 
	}
}

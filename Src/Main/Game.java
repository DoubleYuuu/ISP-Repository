package Main;

public class Game{

    private GameWindow gameWindow;
    public static int SCALE = 1; 
    public GamePanel gamePanel; 


    public Game(){
        gamePanel = new GamePanel(this); 
        new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

    }

}
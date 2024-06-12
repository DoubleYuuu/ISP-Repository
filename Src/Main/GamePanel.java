package Main;


import Inputs.KeyInputs;
import Inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float x = 100;
    private float y = 100;
    private BufferedImage img;

    public static final String PLAYER_ATLAS = "player_sprites.png";  
    
    public GamePanel(){

        importImg();

        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);


    }

    private void importImg(){
        InputStream is = GamePanel.class.getResourceAsStream("/" + PLAYER_ATLAS);

        try{
            img = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void changeXSpeed(int value){
        this.x += value;
    }

    public void changeYSpeed(int value){
        this.y += value;
    }

    public void setRectPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img.getSubimage(0, 0, 30, 30), (int)x, (int)y,60,60, null);

    }

    	/*-
	* Method Name: randomNum
	* Author NAME: Imad Tahir,  Date: December 12 2023
	* Modified Name: Imad Tahir, Date: December 12 2023
	* Description: generates a random number
	* Parameters: low - the lower bound for the random numbers, high - the upper bound for the random numbers
	* Returns: A random number
	* Dependencies: N/A
	* Throws/Exceptions: N/A
	*/
	private static int randomNum(int low, int high) {
		return (int) (Math.random() * (high - (low - 1)) + low);
	}

}

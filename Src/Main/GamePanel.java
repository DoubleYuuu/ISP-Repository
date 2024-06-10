package Main;

import javax.swing.JPanel;

import Inputs.KeyInputs;
import Inputs.MouseInputs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float x = 100;
    private float y = 100;
    private float xDir = 1f;
    private float yDir = 1f;
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(150, 20, 90);
    
    public GamePanel(){

        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);


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

        updateRectangle();
        g.setColor(color);
        
        g.fillRect((int) x, (int) y, 200, 50);


    }

    private void updateRectangle(){
        x += xDir;
        if(x > 400 || x < 0){
            xDir *= -1;
            color = getRndColor();
        }
        y += yDir;
        if(y > 400 || y < 0 ){
            yDir *= -1;
            color = getRndColor();
        }
    }

    private Color getRndColor(){
        int r = randomNum(0,255);
        int g = randomNum(0, 255);
        int b = randomNum(0, 255);

        return new Color(r, g, b);
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

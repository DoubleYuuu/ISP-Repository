package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Player.Inventory;



public class Game implements Runnable {
    private static final int FPS = 60;
    private static final int UPS = 500; 
    private Thread gameThread;
    public Playing playing;
    private GamePanel panel;

    /*
     * Method Name: Game
     * @Author:  Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: June 3, 2024
     * @Description: Constructor for the Game class. Initializes game components and starts the game.
     * @Parameters: n/a
     * @Returns: n/a
     * Dependencies: GamePanel, GameWindow, Playing classes.
     * Throws/Exceptions: n/a
     */

    public Game() {
        initialize();
        panel = new GamePanel(this);
        new GameWindow(panel);
        panel.setFocusable(true);
        panel.requestFocus();
        startGame();
    }

    /*
     * Method Name: startGame
     * @Author:  Devadath Pillai
     * @Date: June 3, 2024
     * @Modified: June 3, 2024
     * @Description: Starts the game thread.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /*
     * Method Name: update
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 4, 2024
     * @Description: Updates the game state.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Playing class.
     * Throws/Exceptions: IOException - if an I/O error occurs.
     */

    public void update() throws IOException {
        playing.update();
          
    }

    /*
     * Method Name: draw
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 4, 2024
     * @Description: Draws the game state.
     * @Parameters: g - the Graphics context where the game will be drawn.
     * @Returns: void
     * Dependencies: Playing class.
     * Throws/Exceptions: IOException - if an I/O error occurs.
     */

    public void draw(Graphics g) throws IOException {
        playing.draw(g);
    }

    /*
     * Method Name: initialize
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 4, 2024
     * @Description: Initializes the game components.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: Playing class.
     * Throws/Exceptions: n/a
     */

    public void initialize() {
        playing = new Playing(this);
    }

     /*
     * Method Name: run
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 9, 2024
     * @Description: Main game loop for updating and rendering the game at fixed intervals.
     * @Parameters: n/a
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void run() {
        double frameTime = 1000000000.0 / FPS;
        double updateTime = 1000000000.0 / UPS;

        long lastTime = System.nanoTime();

        double timeSinceLastFrame = 0;
        double timeSinceLastUpdate = 0;

        while (true) {
            long currentTime = System.nanoTime();

            timeSinceLastFrame += (currentTime - lastTime) / frameTime;
            timeSinceLastUpdate += (currentTime - lastTime) / updateTime;
            lastTime = currentTime;

            if (timeSinceLastFrame >= 1) { 
                panel.repaint();
                timeSinceLastFrame--; // Don't set to 0 as a means of catching up if frames are lost
            }

            if (timeSinceLastUpdate >= 1) {
                try {
                    update();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                timeSinceLastUpdate--; // Don't set to 0 as a means of catching up if updates are lost
            }

        }
    }

    /*
     * Method Name: getPlaying
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 4, 2024
     * @Description: Returns the Playing instance.
     * @Parameters: n/a
     * @Returns: Playing - the Playing instance.
     * Dependencies: Playing class.
     * Throws/Exceptions: n/a
     */
    
    public Playing getPlaying() {
        return playing;
    }

    /*
     * Method Name: keyPressed
     * @Author:  Devadath Pillai
     * @Date: June 4, 2024
     * @Modified: June 4, 2024
     * @Description: Handles key press events.
     * @Parameters: e - the KeyEvent triggered by the key press.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void keyPressed(KeyEvent e) { 
        
    }



}
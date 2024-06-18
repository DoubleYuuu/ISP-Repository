package Main;

import java.awt.Graphics;
import java.io.IOException;



public class Game implements Runnable {
    private static final int FPS = 60;
    private static final int UPS = 500; 
    private Thread gameThread;
    public Playing playing;
    private GamePanel panel;


    public Game() {
        initialize();
        panel = new GamePanel(this);
        new GameWindow(panel);
        panel.setFocusable(true);
        panel.requestFocus();
        startGame();
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update() throws IOException {
        playing.update();
          
    }


    public void draw(Graphics g) throws IOException {
        playing.draw(g);
    }

    public void initialize() {
        playing = new Playing(this);
    }

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
    
    
    public Playing getPlaying() {
        return playing;
    }



}
package Weapons;

import Entities.*;
import Entity.Player;
import GameStates.Playing;
import UserInputs.MouseInputs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static Utilities.Atlas.*;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import static Utilities.Constants.*;
import static Utilities.Constants.Directions.RIGHT;

public class Bow implements MouseMotionListener {

    private Player player;
    BufferedImage img;
    Graphics2D g2d;
    MouseInputs mouse;
    Playing playing;

    public int xFlipped = 0; 
    private int wFlipped = 1; 
    private float xOffset = 0; 
    protected float x = 0;
    protected float y = 0;

    public Bow(Player player, Playing playing) {

        this.player = player;
        this.playing = playing;
        getImage();

    }

    public double setAngle(double centerY, double mouseY, double centerX, double mouseX) {

        return Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;

    }

    public void draw(Graphics g, int xOffset) {

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldXForm = g2d.getTransform();
        g2d.rotate(playing.getAngle(), this.x + 30 - xOffset, this.y + 50);
        this.xOffset = xOffset; 

        if (!Playing.paused && !Playing.inventory && !Playing.dead && !Playing.endGame) {

            if (Playing.bowIndex < 3) {

                if (playing.mouseX < this.x - xOffset) {

                    this.xFlipped = 0; 
                    this.wFlipped = 1; 

                } else {

                    this.xFlipped = WEAPON_WIDTH;
                    this.wFlipped = -1; 

                }
            } else {
                if (playing.getPlayer().getDirection() == RIGHT) {

                    g2d.setTransform(oldXForm);
                    this.xFlipped = 46;
                    this.wFlipped = -1; 

                } else {

                    g2d.setTransform(oldXForm);
                    this.xFlipped = 0; 
                    this.wFlipped = 1; 

                }
            }
        }

        g.drawImage(this.img, (int) this.x + this.xFlipped - xOffset, (int) this.y + 20, WEAPON_WIDTH * this.wFlipped, WEAPON_HEIGHT, null);
        g2d.setTransform(oldXForm);

    }

    public void update() {

        if (playing.mouseX < player.getHitbox().getCenterX() - xOffset)
            this.x = (float) player.getHitbox().getCenterX() - player.getHitbox().width;

        else

            this.x = (float) player.getHitbox().getCenterX();
        
        this.y = player.getHitbox().y - 20;

    }

    public void getImage() {

        if (Playing.bowIndex == 1) {

            this.img = getSpriteAtlas(BOW1_ATLAS);

        } else if (Playing.bowIndex == 2) {

            this.img = getSpriteAtlas(BOW2_ATLAS);

        } else if (Playing.bowIndex == 3) {

            if (playing.getPlayer().getItemQuantity(2) > 0) {

                this.img = getSpriteAtlas(BOMB_ATLAS);

            } else {

                this.img = getSpriteAtlas(NOTHING_ATLAS);

            }
            
        }

    }

    public float getX() {
        
        return this.x;

    }

    public float getY() {

        return this.y;

    }

    /* Mouse events */

    @Override
    public void mouseMoved(MouseEvent e) {

        // add later if needed

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        throw new UnsupportedOperationException("doesn't exist :)'");

    }
}



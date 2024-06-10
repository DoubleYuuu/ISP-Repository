package Weapons;

import GameStates.Playing;
import Entities.Entity;
import static Utilities.Constants.GAME_WIDTH;
import static Utilities.Constants.GAME_HEIGHT;
import static Utilities.Atlas.ARROW_ATLAS;
import static Utilities.Atlas.getSpriteAtlas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

public class Arrows extends Entity implements MouseListener {

    private BufferedImage img, arrowNormal, arrowSpecial;
    private double x, y, directionX, directionY;
    private Weapon1 weapon;
    private Playing playing;
    private int[][] lvlData;
    private double time;
    private boolean shoot = false;
    private double theta = 0;
    private int damage;

    private static final double SPEED1 = 10.0;
    private static final double SPEED2 = 7.0;
    private static final double SPEED3 = 1.0;

    public Arrows(Weapon1 weapon, Playing playing, double startX, double startY, double targetX, double targetY, int xOffset, int[][] lvlData, double time) {

        super((float) startX - 5, (float) startY - 5, 22, 22);
        this.weapon = weapon;
        this.playing = playing;
        this.x = startX;
        this.y = startY;
        this.lvlData = lvlData;
        this.time = time;

        setDirection(targetX, targetY, xOffset);
        setTime();
        getImage();
        initialize();

        if (!playing.getPlayer().isDead()) {

            playing.getSoundLibrary().playSound("Shoot");

        }

        
        if (Playing.gunIndex == 1) {

            this.damage = 10; 

        } else if (Playing.gunIndex == 2) {

            this.damage = 20; 

        } else if (Playing.gunIndex == 3) {

            this.damage = 30; 

        }

    }

    
    public void setDirection(double targetX, double targetY, int xOffset) {

        double angle = Math.atan2(targetY - y, targetX - x + xOffset);
        this.directionX = Math.cos(angle);
        this.directionY = Math.sin(angle);

    }

    
    public void move() {

        double speed = (Playing.bowIndex == 1) ? SPEED1 : (Playing.bowIndex == 2) ? SPEED2 : SPEED3;

        if (canMove((float) (hitbox.x + speed * directionX), (float) (hitbox.y + speed * directionY), hitbox.width, hitbox.height, lvlData) && !stuckBehindDoor) {

            x += speed * directionX;
            y += speed * directionY;
            hitbox.x += speed * directionX;
            hitbox.y += speed * directionY;

        } else {

            playing.removeArrow(this);

        }

    }

    
    public void draw(Graphics g, int xOffset) {

        Graphics2D g2d = (Graphics2D) g;
        int drawX = (int) Math.round(x - xOffset);
        int drawY = (int) Math.round(y);
        AffineTransform oldXForm = g2d.getTransform();

        if (!shoot) {

            theta = playing.getAngle();
            if (weapon.xFlipped == 0) {

                theta += Math.PI;

            }

            if (!playing.arrows.isEmpty()) {

                shoot = true;

            }

        }

        g2d.rotate(theta, drawX - 5, drawY - 5);

        if (Playing.gunIndex == 1) {

            g.drawImage(arrowSpecial, drawX - 5, drawY - 40, 42, 42, null);

        } else if (Playing.gunIndex == 2) {

            g.drawImage(arrowNormal, drawX - 5, drawY - 10, 42, 42, null);

        }
        g2d.setTransform(oldXForm);

        if (playing.arrows.size() > 0) {

            if (drawX >= weapon.x + 400 - xOffset || drawX >= GAME_WIDTH || drawX <= 0 || drawX <= weapon.x - xOffset - 400 || drawY <= 0 || drawY >= GAME_HEIGHT) {

                playing.removeArrow(this);

            }

        }

    }

    
    public void getImage() {

        BufferedImage img = getSpriteAtlas(ARROW_ATLAS);
        arrowNormal = img.getSubimage(0, 0, 42, 56);
        arrowSpecial = img.getSubimage(0, 56, 42, 56);

    }

    
    public void updateArrows() {

        try {

            for (Arrows arrow : playing.arrows) {

                arrow.move();
                this.time += 0.008;

            }

        } catch (ConcurrentModificationException e) {

            // Handle exception

        }

    }

   
    public void handleCollision() {

        for (Entity entity : playing.getEntities()) {

            if (hitbox.intersects(entity.getHitbox())) {

                entity.takeDamage(damage);
                playing.removeArrow(this);
                break;

            }

        }

    }

    
    public void setTime() {

        this.time = 0;

    }

    public double getTime() {

        return this.time;

    }

    public int getDrawX() {

        return (int) Math.round(x);

    }

    public int getDrawY() {

        return (int) Math.round(y);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

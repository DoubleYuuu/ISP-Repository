package Inputs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Main.GamePanel;

public class MouseInputs implements MouseMotionListener, MouseListener, ActionListener {

    private GamePanel panel; 

    /*
     * Method Name: MouseInputs
     * @Author: Devadath Pillai
     * @Date: June 7, 2024
     * @Modified:  June 7, 2024
     * @Description: Constructor for the MouseInputs class.
     * @Parameters: panel - the GamePanel instance to be controlled by the mouse inputs.
     * @Returns: n/a
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public MouseInputs(GamePanel panel) { 
        this.panel = panel; 
    }

    /*
     * Method Name: mouseDragged
     * @Author: Parnia Yazdanparast
     * @Date:  June 8, 2024
     * @Modified:  June 8, 2024
     * @Description: Handles the event when the mouse is dragged.
     * @Parameters: e - the MouseEvent triggered by the mouse drag.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /*
     * Method Name: mouseMoved
     * @Author: Parnia Yazdanparast
     * @Date:  June 8, 2024
     * @Modified:  June 8, 2024
     * @Description: Handles the event when the mouse is moved.
     * @Parameters: e - the MouseEvent triggered by the mouse move.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /*
     * Method Name: actionPerformed
     * @Author: Parnia Yazdanparast
     * @Date:  June 8, 2024
     * @Modified:  June 8, 2024
     * @Description: Handles the event when an action is performed.
     * @Parameters: e - the ActionEvent triggered by the action.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /*
     * Method Name: mouseClicked
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Handles the event when the mouse is clicked.
     * @Parameters: e - the MouseEvent triggered by the mouse click.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /*
     * Method Name: mousePressed
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Handles the event when the mouse is pressed.
     * @Parameters: e - the MouseEvent triggered by the mouse press.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mousePressed(MouseEvent e) {
        panel.getGame().getPlaying().mouseClicked(e);
    }

    /*
     * Method Name: mouseReleased
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Handles the event when the mouse is released.
     * @Parameters: e - the MouseEvent triggered by the mouse release.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /*
     * Method Name: mouseEntered
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Handles the event when the mouse enters a component.
     * @Parameters: e - the MouseEvent triggered by the mouse entering a component.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /*
     * Method Name: mouseExited
     * @Author: Devadath Pillai
     * @Date: June 9, 2024
     * @Modified: June 9, 2024
     * @Description: Handles the event when the mouse exits a component.
     * @Parameters: e - the MouseEvent triggered by the mouse exiting a component.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    @Override
    public void mouseExited(MouseEvent e) {
    } 

}
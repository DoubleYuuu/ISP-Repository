package Main;

import Main.Game;

public class State {
    public Game game;

    /*
     * Method Name: State
     * @Author: Devadath Pillai
     * @Date: June 2, 2024
     * @Modified: June 2, 2024
     * @Description: Constructor for the State class.
     * @Parameters: game - the Game instance associated with this state.
     * @Returns: n/a
     * Dependencies: Game class.
     * Throws/Exceptions: n/a
     */

    public State(Game game) {
        this.game = game;
    }

    /*
     * Method Name: setGame
     * @Author: Devadath Pillai
     * @Date: June 2, 2024
     * @Modified: June 2, 2024
     * @Description: Sets the Game instance associated with this state.
     * @Parameters: game - the Game instance to set.
     * @Returns: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */

    public void setGame(Game game) {
        this.game = game;
    }

}
package interfaces;

import model.Player;

/**
 * Created by avishai on 6/24/2017.
 */

public interface PlayerInterface {

    /**
     * When a player commits serve foul, When there are two fouls in a row,
     * the other player gets a point.
     */
    void addServeFoul(PlayerInterface opponent);

    /**
     * When a player win one point in a range of 14-30-40-(Ad)-win.
     */
    void addGamePoint(PlayerInterface opponent);

    /**
     * In order to win a game, player must win 4 points and be at least 2 points ahead.
     */
    void winGame(PlayerInterface opponent);

    /**
     * In order to win a set, player must win in at least 6 games and be at least 2 games ahead.
     */
    void winSet(PlayerInterface opponent);

    /**
     * In order to win the match, player should win 3 sets.
     */
    void winMatch();

    /**
     * Reset all points,games and sets the player won.
     */
    void reset();

    /**
     * Happens when the other player wins a game.
     */
    void resetGame();

    /**
     * Happens when the other player wins a set.
     */
    void resetSet();

    /**
     * Retrieve player's game points amount.
     * @return Current player's game points amount.
     */
    int getPoints();

    /**
     * Get the Tennis representation of amount of points. (ex: 1 -> 15, 2 -> 30, 3 -> 40...)
     * @return
     */
    String getPointsString();

    /**
     * Return the amount of won games in this set.
     * @return
     */
    int getGames();

    /**
     * When there is a score points of AD-40 and the other player wins a point so current player loses advantage and the points will go back to 40-40.
     */
    void looseAdvantage();
}

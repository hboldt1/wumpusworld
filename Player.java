// This class has been completed for the student
// ...replace with required documentation heading
// Model class - Player.java

/* Player.java
 * Hudson Boldt / Lab Section 02B | Thu 4:30
 *  
 * Player is a model that handles anything related to the player such as its inventory and position
 * 
 */

public class Player {
	private boolean arrow;
	private boolean gold;
	private int row;
	private int col;

// 4 arg constructor
/**
     * Constructs a new `Player` object with the specified starting row and column.
     * The player is initially given an arrow, but no gold.
     *
     * @param r the starting row for the player
     * @param c the starting column for the player
     */
public Player(int r, int c) {
	row = r;
	col = c;
	arrow = true;
	gold = false;
 }
/**
     * Consumes the player's arrow, setting the `arrow` property to `false`.
     */
 public void shootArrow() {
	arrow = false;
 }
/**
     * Grants the player the gold, setting the `gold` property to `true`.
     */
 public void grabGold() {
	gold = true;
 }
/**
     * Returns `true` if the player has the gold, `false` otherwise.
     *
     * @return `true` if the player has the gold, `false` otherwise
     */
 public boolean hasGold() {
	return gold;
 }
/**
     * Returns the current row of the player.
     *
     * @return the current row of the player
     */
 public int getRow() {
	return row;
 }
/**
     * Returns the current column of the player.
     *
     * @return the current column of the player
     */
 public int getCol() {
	return col;
 }
/**
     * Returns `true` if the player has an arrow, `false` otherwise.
     *
     * @return `true` if the player has an arrow, `false` otherwise
     */
public boolean hasArrow() {
	return arrow;
 }
/**
     * Sets the player's row to the specified value.
     *
     * @param r the new row for the player
     */
 public void setRow(int r) {
	row = r;
}
/**
     * Sets the player's column to the specified value.
     *
     * @param c the new column for the player
     */
public void setCol(int c) {
	col = c;
}
/**
     * Moves the player in the specified direction ('u', 'd', 'l', 'r').
     *
     * @param dir the direction to move the player
     */
// Move player based on direction ('u', 'd', 'l', 'r')
 public void move(char dir) {
	switch(dir) {
		case 'l':
			col--;
			break;
		case 'r':
			col++;
			break;
		case 'u':
			row--;
			break;
		case 'd':
			row++;
			break;
	} // end switch
 } // end move()

} // end class Player
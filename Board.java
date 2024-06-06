// Starter file ...replace with required documentation heading

// Model class - Board.java
// Reminder: No I/O statements in the Model (i.e., println, nextLine, etc.)
// Model only holds and manipulates the data

/* Board.java
 * Hudson Boldt / Lab Section 02B | Thu 4:30
 *  
 * Board is the meatiest part of the program. its like a mega model which handles all computations
 * including cell and player. everything is decided and changed in this class
 * 
 */

import java.util.*;

public class Board {
	private Cell[][] game;
	private int rows, cols;
	private Player player;
	private int exitRow;
	private int exitCol;
	private boolean exit;
	private boolean wumpusDead;

	Random r = new Random();


// No-arg constructor
// 1) Set exit and wampusDead to false
// 2) Randomly pick the dimensions (4-6 by 4-6) for rows, columns
// 3) Initialize the game board that size
// 4) Instantiate the player object using exitRow (rows-1) and exitCol (0)
// 5) Use nested for loop to add Cells to the game and add pits (DONE)
// 6) Randomly place one wampus and gold into  the game

/**
 * Constructs a new `Board` object with randomly generated dimensions (4-6 rows
 * and 4-6 columns), initializes the game board, places the player, Wumpus, and
 * gold, and sets up the game state.
 */
 public Board() {
	exit = false;
	wumpusDead = false;
	int rows = r.nextInt(3) + 4; // 4 to 6
	this.rows = rows;
	int cols = r.nextInt(3) + 4;
	this.cols = cols;

	game = new Cell[rows][cols];

	int exitRow = rows - 1;
    this.exitRow = exitRow;
	int exitCol = 0;
    this.exitCol = exitCol;

	Player player = new Player(exitRow, exitCol);
	this.player = player;

	// make player

	// Code below given to student

	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			game[i][j] = new Cell();
			if (i != exitRow && j != exitCol + 1) {
				int chance = r.nextInt(100);
				if (chance <= 9) {
					//place a pit (10% chance)
					game[i][j].addPit();
				}
			}
		} // end outer for
	} // end inner for

	// Generate Wump and place him

	int wumpRows = r.nextInt(rows - 1);
	int wumpCols = r.nextInt(cols - 1) + 1;

	while(game[wumpRows][wumpCols].containsPit() || (wumpRows == player.getRow() && wumpCols == player.getCol())){ // makes sure pit doesnt exist where wumpus is placed
		wumpRows = r.nextInt(rows);
		wumpCols = r.nextInt(cols);
	}

	game[wumpRows][wumpCols].addWumpus();

	// Generate Wump and place him

	int goldRows = r.nextInt(rows);
	int goldCols = r.nextInt(cols); 


	while(game[goldRows][goldCols].containsPit() || game[goldRows][goldCols].containsWumpus()){ 
		goldRows = r.nextInt(rows);
		goldCols = r.nextInt(cols);
	}
	game[goldRows][goldCols].addGold();

 } // end no-arg constructor
	
// Returns true if the wampus is at a given row/col position
// otherwise returns false	
/**
     * Returns `true` if the player's current position contains the Wumpus, `false`
     * otherwise.
     *
     * @return `true` if the player is eaten by the Wumpus, `false` otherwise
     */
 public boolean amEaten() {

	return game[player.getRow()][player.getCol()].containsWumpus();

 } // end amEaten()

// Returns true if there is a pit at a given row/col position
// otherwise returns false	
/**
     * Returns `true` if the player's current position contains a pit, `false`
     * otherwise.
     *
     * @return `true` if the player has fallen into a pit, `false` otherwise
     */
 public boolean fallen() {

	return game[player.getRow()][player.getCol()].containsPit();


 } // end fallen()
	
// Returns true if the wampus is dead
// otherwise returns false	
/**
     * Returns `true` if the Wumpus is dead, `false` otherwise.
     *
     * @return `true` if the Wumpus is dead, `false` otherwise
     */
 public boolean wumpusGone() {

	return wumpusDead;


 } // end wumpusGone()

// Returns true if player escaped (exit is true)
// otherwise returns false	
/**
     * Returns `true` if the player has escaped the cave, `false` otherwise.
     *
     * @return `true` if the player has escaped, `false` otherwise
     */
 public boolean escaped() {

	return exit;


 } // end escaped()
	
// Returns true if player has the gold
// otherwise returns false	
/**
     * Returns `true` if the player has the gold, `false` otherwise.
     *
     * @return `true` if the player has the gold, `false` otherwise
     */
 public boolean hasGold() {

	return player.hasGold();

 } // end hasGold()
	
// Returns true if player has an arrow
// otherwise returns false	
/**
     * Returns `true` if the player has an arrow, `false` otherwise.
     *
     * @return `true` if the player has an arrow, `false` otherwise
     */
 public boolean hasArrow() {

	return player.hasArrow();


 } // end hasArrow()
	
// If there is gold at a given row/col, play grabs the gold and return true
// otherwise returns false	
/**
     * Attempts to grab the gold at the player's current position. If successful,
     * the player grabs the gold and `true` is returned. Otherwise, `false` is
     * returned.
     *
     * @return `true` if the player grabs the gold, `false` otherwise
     */
public boolean grabGold() {

	if (game[player.getRow()][player.getCol()].containsGold()){
		player.grabGold();
        game[player.getRow()][player.getCol()].grabGold();
		return true;
	}

	return false;

	

 } // end grabGold()
	
// If players current position is at the exitRow and exitCol
// set exit to true and return true
// otherwise returns false	
 /**
     * Attempts to climb the exit at the player's current position. If the player's
     * position matches the exit coordinates and the player has the gold, `true` is
     * returned, indicating the player has escaped. Otherwise, `false` is returned.
     *
     * @return `true` if the player has escaped, `false` otherwise
     */
public boolean climb() {

	if (player.getRow() == this.exitRow && player.getCol() == this.exitCol){
		exit = true;
		return exit;
	}

	return false;

 } // end climb()

// Initially set wampus and pit to false
// Create a StringBuilder object 'sbc' (since no I/O allowed in the model)
// Get the current row/col of the player 
// If that position 'contains gold', append message to 'sb'
// If a wampus or pit is nearby, set to true
// If there is a wampus nearby, append message to 'sb'
// If there is a pit nearby, append message to 'sb'
// Return 'sb' as a String
/**
     * Evaluates the player's current position and the surrounding positions,
     * checking for the presence of gold, Wumpus, and pits. The method returns a
     * string containing any relevant information about the player's surroundings.
     *
     * @return a string containing information about the player's surroundings
     */
public String evaluateSpot() {
    // System.out.println("\t\tEvaluating");
    StringBuilder sb = new StringBuilder();
    int[] rowOffsets = {-1, 0, 0, 1};
    int[] colOffsets = {0, -1, 1, 0};

    // Check the player's current position
    if (game[player.getRow()][player.getCol()].containsGold()) {
        sb.append("You see a glitter.\n");
    }

    // Check the adjacent positions
    for (int i = 0; i < 4; i++) {
        int row = player.getRow() + rowOffsets[i];
        int col = player.getCol() + colOffsets[i];

        if (row < rows && row >= 0 && col < cols && col >= 0) {
            if (game[row][col].containsWumpus()) {
                sb.append("You smell a stench\n");
            }

            if (game[row][col].containsPit()) {
                sb.append("You feel a breeze.\n");
            }
        }
    }

    return sb.toString();
} // end evaluateSpot()

// If no wall, move player based on direction ('u', 'd', 'l', 'r')
// return whether there is a wall there or not
/**
     * Moves the player in the specified direction, if possible. If the move is
     * successful, `true` is returned. Otherwise, `false` is returned, indicating a
     * wall is present in the specified direction.
     *
     * @param dir the direction to move ('u', 'd', 'l', 'r')
     * @return `true` if the move is successful, `false` otherwise
     */
public boolean move(char dir) {
    switch (Character.toLowerCase(dir)) {
        case 'u':
            if (player.getRow() > 0 && !game[player.getRow() - 1][player.getCol()].containsWall()) {
                player.move('u');
                return true;
            }
            break;
        case 'd':
            if (player.getRow() < this.rows - 1 && !game[player.getRow() + 1][player.getCol()].containsWall()) {
                player.move('d');
                return true;
            }
            break;
        case 'l':
            if (player.getCol() > 0 && !game[player.getRow()][player.getCol() - 1].containsWall()) {
                player.move('l');
                return true;
            }
            break;
        case 'r':
            if (player.getCol() < this.cols - 1 && !game[player.getRow()][player.getCol() + 1].containsWall()) {
                player.move('r');
                return true;
            }
            break;
        default:
            return false;
    }

    return false;
}

// Get the currrent position of the player
// returns whether the shot hit the Wumpus
// If a player has an arrow, shoot it and determine if the wampus is killed (return true)
// otherwise return false
/**
     * Attempts to shoot an arrow in the specified direction. If the player has an
     * arrow and the arrow hits the Wumpus, `true` is returned, indicating the
     * Wumpus has been killed. Otherwise, `false` is returned.
     *
     * @param dir the direction to shoot the arrow ('u', 'd', 'l', 'r')
     * @return `true` if the Wumpus is hit, `false` otherwise
     */
public boolean shoot(char dir) {
    int newRow = player.getRow();
    int newCol = player.getCol();
    dir = Character.toLowerCase(dir);

    // Check if the player has an arrow
    if (player.hasArrow()) {
        switch (dir) {
            case 'u':
                // Shoot upwards
                for (int i = newRow - 1; i >= 0; i--) {
                    if (game[i][newCol].containsWumpus()) {
                        game[i][newCol].killWumpus();
                        player.shootArrow();
                        // System.out.println(wumpusGone());
                        return true;
                    }
                }
                // If no Wumpus found, consume the arrow and return false
                player.shootArrow();
                return false;
            case 'd':
                // Shoot downwards
                for (int i = newRow + 1; i < this.rows; i++) {
                    if (game[i][newCol].containsWumpus()) {
                        game[i][newCol].killWumpus();
                        player.shootArrow();
                        // System.out.println(wumpusGone());
                        return true;
                    }
                }
                // If no Wumpus found, consume the arrow and return false
                player.shootArrow();
                return false;
            case 'l':
                // Shoot left
                for (int i = newCol - 1; i >= 0; i--) {
                    if (game[newRow][i].containsWumpus()) {
                        game[newRow][i].killWumpus();
                        player.shootArrow();
                        // System.out.println(wumpusGone());
                        return true;
                    }
                }
                // If no Wumpus found, consume the arrow and return false
                player.shootArrow();
                return false;
            case 'r':
                // Shoot right
                for (int i = newCol + 1; i < this.cols; i++) {
                    if (game[newRow][i].containsWumpus()) {
                        game[newRow][i].killWumpus();
                        player.shootArrow();
                        // System.out.println(wumpusGone());
                        return true;
                    }
                }
                // If no Wumpus found, consume the arrow and return false
                player.shootArrow();
                return false;
            default:
                // Invalid direction
                return false;
        }
    } else {
        // Player has no arrows
        System.out.println("You don't have any arrows left!");
        return false;
    }
}// end shoot


 //BOARDSTATE PRINT ENTIRE MAP
 /**
     * Returns a string representation of the current state of the game board,
     * including the positions of the player, Wumpus, gold, and pits.
     *
     * @return a string representing the current state of the game board
     */
 public String boardState() {
    
    StringBuilder sb = new StringBuilder();
    sb.append("Rows: ").append(this.rows).append(" Col: ").append(this.cols).append("\n");
    sb.append("\nBooleans for Wampus, Gold, Pit\n");

    for (int i = 0; i < this.rows; i++) {
        sb.append("[");
        for (int j = 0; j < this.cols; j++) {
            Cell cell = this.game[i][j];
            sb.append(cell.containsWumpus()).append(",")
               .append(cell.containsGold()).append(",")
               .append(cell.containsPit());
            if (j < this.cols - 1) {
                sb.append("],[");
            } else {
                sb.append("]");
            }
        }
        sb.append("\n");
    }

    return sb.toString();
}

} // end class Board
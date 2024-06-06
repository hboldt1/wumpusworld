// Starter file ...replace with required documentation heading

// Model class - Cell.java
// Reminder: No I/O statements in the Model (i.e., println, nextLine, etc.)
// Model only holds and manipulates the data

/* Cell.java
 * Hudson Boldt / Lab Section 02B | Thu 4:30
 *  
 * cell is a model class that handles anything related to the cell such as wumpus gold and a pit.
 * i also added a wallhere because it was easier to computate.
 * 
 */

public class Cell {
	private boolean wumpusHere;
	private boolean goldHere;
	private boolean pitHere;
	private boolean wallHere; // added this

	// no-arg constructor sets all data properties to false
	
	public Cell() {
		this.wumpusHere = false;
		this.goldHere = false;
		this.pitHere = false;

	}

	// sets wumpusHere to true
	public void addWumpus() {
		this.wumpusHere = true;
	}

	// sets wumpusHere to false
	public void killWumpus() {
		this.wumpusHere = false;
	}

	// sets goldHere to true
	public void addGold() {
		this.goldHere = true;
	}

	// sets goldHere to false
	public void grabGold() {
		this.goldHere = false;

	}

	// sets pitHere to true
	public void addPit() {
		this.pitHere = true;
	}

	// added addWall
	public void addWall() {
		this.wallHere = true;
	}

	// returns the current value of wumpusHere
	/**
     * Returns `true` if the Wumpus is present in this cell, `false` otherwise.
     *
     * @return `true` if the Wumpus is present, `false` otherwise
     */
	public boolean containsWumpus() {
		return this.wumpusHere;
	}

	// returns the current value of goldHere
	/**
     * Returns `true` if gold is present in this cell, `false` otherwise.
     *
     * @return `true` if gold is present, `false` otherwise
     */
	public boolean containsGold() {
		return goldHere;
	}

	// returns the current value of pitHere
	/**
     * Returns `true` if a pit is present in this cell, `false` otherwise.
     *
     * @return `true` if a pit is present, `false` otherwise
     */
	public boolean containsPit() {
		return pitHere;
	}

	// added contains wall
	/**
     * Returns `true` if a wall is present in this cell, `false` otherwise.
     *
     * @return `true` if a wall is present, `false` otherwise
     */
	public boolean containsWall() {
		return this.wallHere;
	}
} // end class Cell
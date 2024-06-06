// Starter file ...replace with required documentation heading

// View class for Console I/O (View.java)
// Reminder: View knows nothing of the Model
// View only handles I/O statements (i.e., println, nextLine, etc.)
/* View.java
 * Hudson Boldt / Lab Section 02B | Thu 4:30
 *  
 * View handles all the player input and output the spits it out where its called
 * 
 */

import java.util.*;

public class View {
	private Scanner s;
		
	// Constructor is done for the student
	/**
     * Constructs a new `View` object and initializes the `Scanner` for user input.
     */
	public View(){
		s = new Scanner(System.in);
	} // end no-arg constructor

	// Prompts user for an option: (m)ove, (s)hoot, (g)rab, or (c)limb
	// Returns lowercase version of the choice

	/**
     * Prompts the user to enter an option: (m)ove, (s)hoot, (g)rab, or (c)limb.
     * The method returns the lowercase version of the user's choice.
     *
     * @return the lowercase version of the user's choice
     */
	public char getOption() {

		System.out.print("Enter option: (m)ove, (s)hoot, (g)rab, or (c)limb: ");

		String userInput = s.nextLine().toLowerCase();

		System.out.println();

		char charInput = userInput.charAt(0);

		return charInput;
	} // end getOption
		
	// Prompts user for a direction: (u)p, (d)own, (l)eft, or (r)ight
	// Returns lowercase version of the choice

	/**
     * Prompts the user to enter a direction: (u)p, (d)own, (l)eft, or (r)ight.
     * The method returns the lowercase version of the user's choice.
     *
     * @return the lowercase version of the user's choice
     */
	public char getDirection() {

		System.out.print("Enter direction: (u)p, (d)own, (l)eft, or (r)ight: ");

		String userInput = s.nextLine().toLowerCase();

		System.out.println();

		char charInput = userInput.charAt(0);

		return charInput;

	} // end getDirection
		
	// Displays any string passed to it followed by a newline
	// Used to display a message, such as "You hear a scream."

	/**
     * Displays the specified message, followed by a newline.
     *
     * @param msg the message to be displayed
     */
	public void displayMsg(String msg) {

		System.out.println(msg);

	} // end displayMsg
		
	// Displays any string passed to it followed by a newline
	// Used to display an error message, such as "There is a wall there."

	 /**
     * Displays the specified error message, followed by a newline.
     *
     * @param error the error message to be displayed
     */
	public void displayError(String error) {

		System.out.println(error);

	} // end displayError
		
	// Displays any string passed to it followed by a newline
	// Used to display the ending message, such as "You leave the cave with the gold!"
	// (On a new line) "The Wumpus is dead. You win!"

	/**
     * Displays the specified ending message, followed by a newline and the message
     * "The Wumpus is dead. You win!".
     *
     * @param msg the ending message to be displayed
     */
	public void endGame(String msg) {
		System.out.println(msg + "\nThe Wumpus is dead. You win");
	} // end endGame
} // end class View
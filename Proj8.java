// Starter file ...replace with required documentation heading

// Controller class - Proj8.java
// Reminder: No I/O statements in the controller class (i.e., println, nextLine, etc.)
// Use Board and View classes to do all of the 'work' for this application

/* Proj8.java
 * Hudson Boldt / Lab Section 02B | Thu 4:30
 *  
 * Proj8 is the contrllller class for this wumpus world game. Its a game where the player
 * needs to kill the monster, collect the gold and escape all while dodging pits and
 * relying of hints of its surroundings to navigate around. I utilized this class
 * to call all of the other methods and functions. No computating or input output happens
 * in the controller class. Its sole purpose is to "CONTROL" the program.
 * 
 */

public class Proj8 {
	public static void main(String[] args) {
		// Initialize the game
		Board board = new Board();
		View view = new View();
	
		// Display the initial board state
		System.out.println(board.boardState());
			
		// Start the game loop
		
		String status = board.evaluateSpot();
		view.displayMsg(status);

		while (!board.escaped() && !board.wumpusGone()) {
			// Get user input
			char option = view.getOption();
			switch (option) {
				case 'm':
					char direction = view.getDirection();
					if (!board.move(direction)) {
						view.displayError("There is a wall there.");
					}
					status = board.evaluateSpot();
					view.displayMsg(status);

					break;
				case 's':
					direction = view.getDirection();
					if (board.shoot(direction)) {
						view.displayMsg("You shot the Wumpus!");
						board.wumpusGone();
					} else {
						view.displayError("You missed the Wumpus.");
					}
					break;
				case 'g':
					if (board.grabGold()) {
						view.displayMsg("You found the gold!");
					} else {
						view.displayError("There is no gold here.");
					}
					break;
				case 'c':

					if (board.climb()) {
						if (!board.hasGold() && board.wumpusGone()) {
							board.escaped();
							view.endGame("You leave the cave with the gold!");
							break;
						}
						
						
					} else {
						view.displayError("This is not the exit.");
					}
					break;
				default:
					view.displayError("Invalid option.");
					break;
			}
	
			// Update the game state
			if (board.amEaten()) {
				view.displayMsg("The Wumpus has eaten you!");
				break;
			}
			if (board.fallen()) {
				view.displayMsg("You fell into a pit!");
				break;
			}
	
			// Check for win/loss conditions
			if (board.escaped() && board.hasGold()) {
				view.endGame("You leave the cave with the gold!");
			} else if (board.escaped() && board.wumpusGone()) {
				view.endGame("The Wumpus is dead. You win!");
			}
		}
	}
}
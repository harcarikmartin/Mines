package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
	
	/**
	 * Constructor.
	 */
	private Minesweeper() {
		userInterface = new ConsoleUI();

		Field field = new Field(9, 9, 10);
		userInterface.newGameStarted(field);
	}
	
	/** User interface. */
	private UserInterface userInterface;
	
	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new Minesweeper();
	}
}

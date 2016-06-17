package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
	private long startMillis = System.currentTimeMillis();
	private BestTimes bestTimes = new BestTimes();
	private static Minesweeper instance;
	private Settings setting;
	
	/**
	 * Constructor.
	 */
	private Minesweeper() {
		instance = this;
		userInterface = new ConsoleUI();
//		setting.load();

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
	
	public long getPlayingSeconds() {
		return (System.currentTimeMillis() - startMillis) / 1000;
	}
	
	public static void main(String[] args) {
		new Minesweeper();
	}

	public BestTimes getBestTimes() {
		return bestTimes;
	}

	public static Minesweeper getInstance() {
		return instance;
	}

	public Settings getSetting() {
		return setting;
	}

	public void setSetting(Settings setting) {
		this.setting = setting;
//		this.setting.save();
	}
}


// Test na vymazanie branch
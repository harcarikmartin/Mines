package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.Mine;
import minesweeper.core.Tile;
import minesweeper.core.Tile.State;


/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    private static Pattern PATTERN = Pattern.compile("([MOX])([A-I])?([0-8])?");
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field)
	 */
    @Override
	public void newGameStarted(Field field) {
        this.field = field;
        update();
        do {
            update();
     	    processInput();
        } while(true);
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
    @Override
	public void update() {
    	char row = 'A';
    	for(int z = -1; z < field.getColumnCount(); z++) {
			if(z == -1) {
				System.out.print(" ");
			}
			else {
				System.out.print(" " + z);
			}
    	}
    	System.out.println();
    	for (int x = 0; x < field.getRowCount(); x++) {
    		System.out.print(row);
			for (int y = 0; y < field.getColumnCount(); y++) {
				if(field.getTile(x,y) instanceof Mine && field.getTile(x,y).getState().equals(State.OPEN)) {
					System.out.print(" X");
				}
				if(field.getTile(x,y) instanceof Clue && field.getTile(x, y).getState().equals(State.OPEN)) {
					System.out.print(" C");
				}
				if(field.getTile(x,y).getState().equals(State.MARKED)) {
					System.out.print(" M");
				}
				if(field.getTile(x,y).getState().equals(State.CLOSED)) {
					System.out.print(" -");
				}
			}
			System.out.println();
			row++;
		}
    }
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    
    private void processInput() {
    	System.out.printf("Please enter your selection <X> EXIT, <MA1> MARK, <OB4> OPEN : ");
    	String input = readLine();
    	Matcher matcher = PATTERN.matcher(input);
    	
    	if(matcher.matches()) {
    		String typ = matcher.group(1);
    		String rowString = matcher.group(2);
    		String columnString = matcher.group(3);
    		char rowChar = 'A';
    		int row = 0;
    		int column = Integer.parseInt(columnString);
    		
    		for (int i = 0; i < field.getRowCount(); i++) {
				if(rowString.charAt(0) == rowChar) {
					row = i;
				}
				else {
					rowChar++;
				}
			}
    		if(typ == "X") {
    			//quit game
    		}
    		else if(typ == "O") {
    			if(row < field.getRowCount() && column < field.getColumnCount()) {
    				field.openTile(row,column);
//    				update();
    			}
    			else {
    				System.out.println("Wrong command");
    				processInput();
    			}	
    		}
    		else if(typ == "M") {
    			if(row < field.getRowCount() && column < field.getColumnCount()) {
    				field.markTile(row,column);
//    				update();
    			}
    			else {
    				System.out.println("Wrong command");
//    				update();
    			}	
    		}
    	}	
    }
}

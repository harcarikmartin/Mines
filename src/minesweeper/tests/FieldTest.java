package minesweeper.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.GameState;
import minesweeper.core.Mine;

public class FieldTest {
	
	static final int ROWS = 9;
	static final int COLUMNS = 9;
	static final int MINES = 10;
	
	@Test
	public void generate() {
		Field field = new Field(ROWS, COLUMNS, MINES);
		
		assertEquals(ROWS, field.getRowCount());
		assertEquals(COLUMNS, field.getColumnCount());
		assertEquals(MINES, field.getMineCount());
		
		int mineCount = 0;
		int clueCount = 0;
		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				assertNotNull(field.getTile(row, column));
				if(field.getTile(row, column) instanceof Mine) {
					mineCount++;
				}
				if(field.getTile(row, column) instanceof Clue) {
					clueCount++;
				}
			}
		}
		assertEquals(MINES, mineCount);
		assertEquals(ROWS * COLUMNS - MINES, clueCount);
	}
	
	@Test                
    public void isSolved() {
        Field field = new Field(ROWS, COLUMNS, MINES);
        
        assertEquals(GameState.PLAYING, field.getState());
        
        int open = 0;
        for(int row = 0; row < field.getRowCount(); row++) {
            for(int column = 0; column < field.getColumnCount(); column++) {
                if(field.getTile(row, column) instanceof Clue) {
                    field.openTile(row, column);
                    open++;
                }
                if(field.getRowCount() * field.getColumnCount() - open == field.getMineCount()) {
                    assertEquals(GameState.SOLVED, field.getState());
                } else {
                    assertNotSame(GameState.FAILED, field.getState());
                }
            }
        }
        assertEquals(GameState.SOLVED, field.getState());
    }
}

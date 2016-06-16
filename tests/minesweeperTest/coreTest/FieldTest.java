package minesweeperTest.coreTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import minesweeper.core.Field;
import minesweeper.core.Mine;

public class FieldTest {

	@Test
	public void testFieldConstructor() {
		Random random = new Random();
		int rows = random.nextInt(99);
		int columns = rows;
		int mines = rows * columns / 10;
		int minesCount = 0;
		
		Field field = new Field(rows, columns, mines);
		for (int i = 0; i < field.getRowCount(); i++) {
			for (int j = 0; j < field.getColumnCount(); j++) {
				if(field.getTile(i,j) instanceof Mine) {
					minesCount++;
				}
			}
		}
		assertTrue("Field not created!", mines == minesCount);
	}
	
	
	@Test
	public void testGenerate() {
		Random random = new Random();
		int nullCount = 0;
		int rows = random.nextInt(99);
		int columns = rows;
		int mines = rows * columns / 10;
		
		Field field = new Field(rows, columns, mines);
		for (int i = 0; i < field.getRowCount(); i++) {
			for (int j = 0; j < field.getColumnCount(); j++) {
				if(field.getTile(i,j).equals(null)) {
					nullCount++;
				}
			}
		}
		assertTrue("Field contains at least one tile that has not been initialized!", nullCount == 0);
	}
}

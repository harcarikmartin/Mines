package minesweeper;

import java.io.Serializable;

public class Settings implements Serializable{
	private final int rowCount; 
	private final int columnCount; 
	private final int mineCount;

	public static final Settings BEGINNER = new Settings(9,9,10);
	public static final Settings INTERMEDIATE = new Settings(16,16,40);
	public static final Settings EXPERT = new Settings(16,30,99);
	public static final String SETTING_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "minesweeper.settings";
	
	public Settings(int rowCount, int columnCount, int mineCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.mineCount = mineCount;
	}

	public int getMineCount() {
		return mineCount;
	}

	public int getColumnCount() {
		return columnCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
//	public void save() {
//		FileOutputStream
//			ObjectOutputStream
//	}
	
//	public static Settings load() {
//		FileInputStream
//			ObjectInputStream
//	}
	
	public int hashCode() {
		return 0;
	}
	
	public boolean equals(Object o) {
		return false;
	}
	
}

package minesweeper;

import java.io.Serializable;

public class Settings implements Serializable{
	private final int rowCount, columnCount, mineCount;

	public static final Settings BEGINNER = new Settings(9,9,10);
	public static final Settings INTERMEDIATE = new Settings(16,16,40);
	public static final Settings EXPERT = new Settings(16,30,99);
	public static final String SETTING_FILE = System.getProperty("üser.home") + System.getProperty("file.separator") + "minesweeper.settings";
	
	public Settings(int rowCount, int columnCount, int mineCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.mineCount = mineCount;
	}

	private int getMineCount() {
		return mineCount;
	}

	private int getColumnCount() {
		return columnCount;
	}
	
	private int getRowCount() {
		return rowCount;
	}
	
//	public void save() {
//		FileOutputStream
//			ObjectOutputStream
//	}
	
//	public void load() {
//		FileInputStream
//			ObjectInputStream
//	}
	
}

package minesweeper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

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
	
	public void save() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(SETTING_FILE);
			ObjectOutputStream s;
			try {
				s = new ObjectOutputStream(out);
				s.writeObject(BEGINNER);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
	}
	
	public static Settings load() {
		FileInputStream in;
		try {
			in = new FileInputStream(SETTING_FILE);
			ObjectInputStream s;
			try {
				s = new ObjectInputStream(in);
				 try {
					Settings setting =  (Settings) s.readObject();
					return setting;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int hashCode() {
		return rowCount * columnCount * mineCount;
	}
	
	public boolean equals(Object o) {
		return o.hashCode() == this.hashCode();
	}
	
}

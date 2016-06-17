package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
    /** List of best player times. */
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();

    /**
     * Returns an iterator over a set of  best times.
     * @return an iterator
     */
    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    /**
     * Adds player time to best times.
     * @param name name of the player
     * @param time player time in seconds
     */
    public void addPlayerTime(String name, int time) {
    	int compare;
    	int index = 0;
    	while (playerTimes.iterator().hasNext()) {
			compare = playerTimes.get(index).compareTo(playerTimes.get(index + 1));
			while (compare <= 0) {
				index++;
				compare = playerTimes.get(index).compareTo(playerTimes.get(index + 1));
			} 
		}
		PlayerTime pt = new PlayerTime(name, time);
    	playerTimes.add(index, pt);
//    	Collections.sort(playerTimes);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
    public String toString() {
    	Formatter f = new Formatter();
    	int pocet = 1;
    	while(playerTimes.iterator().hasNext()) {
    		f.format("%d. %s, ", pocet, playerTimes.toString());
    		pocet++;
    	}
        return f.toString();
    }
    
    public void reset() {
    	playerTimes.clear();
    }
    
    /**
     * Player time.
     */
    public static class PlayerTime implements Comparable<PlayerTime> {
        /** Player name. */
        private final String name;

        /** Playing time in seconds. */
        private final int time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }

		public String getName() {
			return name;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(PlayerTime o) {
			int result;
			if(this.time < o.time) {
				result = -1;
			} else if(this.time > o.time) {
				result = 1;
			} else {
				result = 0;
			}
			return result;
			
		}
    }
}
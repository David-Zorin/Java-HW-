package mines;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Mines {

	// class that compare between 2 places
	private class Place implements Comparable<Place> {
		private int i;
		private int j;

		// constructor for place
		public Place(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		// the toString func/method
		public String toString() {
			return "(" + i + ", " + j + ")";
		}

		@Override
		// the compareTo func/method
		public int compareTo(Place other) {
			return this.toString().compareTo(other.toString());
		}
	}

	private int height;
	private int width;
	private int board;
	private int numMines;
	private boolean showAll;
	private int[][] field; // board of points
	private Set<Place> flags = new TreeSet<>();
	private Set<Place> discovered = new TreeSet<>();

	// useing this to check all places around(x+1,x-1,y+1,y-1)
	private int[][] dirDxDy = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
	private Random r = new Random();

	// constructor for Mines
	public Mines(int height, int width, int numMines) {
		int i, j;
		board = height * width;
		field = new int[this.height = height][this.width = width];

		// loop to put random mines
		int m = 0;
		while (m < numMines) {
			i = r.nextInt(height);
			j = r.nextInt(width);
			if (addMine(i, j))
				m++;
		}
	}

	// func/method that checks if the place (x,y) is in the board/bounds
	private boolean isInBounds(int x, int y) {
		return x >= 0 && x < height && y >= 0 && y < width;
	}

	// func/method that add mines to the board (if in bounds ofc)
	public boolean addMine(int i, int j) {
		// if mine already placed return false
		if (field[i][j] == -1)
			return false;

		int nx, ny;
		// adds indications that (i,j) is a mine to nearby places
		for (int k = 0; k < 8; k++) {
			nx = i + dirDxDy[k][0];
			ny = j + dirDxDy[k][1];

			if (isInBounds(nx, ny) && field[nx][ny] != -1)
				field[nx][ny]++;
		}

		// mark [i][j] as a mine
		field[i][j] = -1;
		numMines++;
		return true;
	}

	
	// func/method that open place on board
	public boolean open(int i, int j) {
		int nx, ny;
		Place checkPlace = new Place(i, j);

		// check if its already mine
		if (field[i][j] == -1)
			return false;

		// check if its flag/open place
		if (flags.contains(checkPlace))
			return true;

		// adding the place to discovered
		discovered.add(checkPlace);

		// check if there are mines around
		if (field[i][j] != 0)
			return true;
		
		// opening places around
		else
			for (int k = 0; k < 8; k++) {
				nx = i + dirDxDy[k][0];
				ny = j + dirDxDy[k][1];

				if (isInBounds(nx, ny) && field[i][j] != -1 && !discovered.contains(new Place(nx, ny)))
					open(nx, ny);
			}
		return true;
	}

	// func/methos that setting the flag on the board
	public void toggleFlag(int x, int y) {
		Place addFlag = new Place(x, y);
		if (flags.contains(addFlag))
			flags.remove(addFlag);
		else
			flags.add(addFlag);
	}

	// checking if all places that are not mine opens
	public boolean isDone() {
		return (board - discovered.size() == numMines);
	}

	// func the will be returning the view point
	public String get(int i, int j) {
		Place p = new Place(i, j);
		
		if (!discovered.contains(p) && !showAll)
			return (flags.contains(p)) ? "F" : ".";

		if (field[i][j] == -1)
			return "X";

		if (field[i][j] == 0)
			return " ";

		return field[i][j] + "";
	}

	// setting flag of showAll to true
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	// returning the view on the board
	@Override
	public String toString() {
		StringBuilder mf = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				mf.append(get(i, j));
			mf.append('\n');
		}

		return mf.toString();
	}
}

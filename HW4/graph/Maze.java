package graph;

import java.util.ArrayList;
import java.util.Collection;

public class Maze implements GraphInterface<Place> {
	private int size;
	private char arr[][]; // array that will contain the maze
	private Place start;
	private Place end;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		this.size = size;
		if ((inmaze(startx) == false) || (inmaze(starty) == false) || (inmaze(endx) == false)
				|| (inmaze(endy) == false)) {
			throw new IllegalArgumentException();
		}
		// save the end and the start (Place)
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		arr = new char[size][size];
		// loop to create the maze array with dots
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				arr[i][j] = '.';
		}
		// place 'S' and 'E' in the maze
		arr[startx][starty] = 'S';
		arr[endx][endy] = 'E';
	}

	// retrun true if x is in frame
	private boolean inmaze(int x) {
		if (x < 0 || x > size - 1)
			return false;
		return true;
	}

	// function that add wall to the maze
	public boolean addWall(int x, int y) {
		// check x and y
		if (inmaze(x) == false || inmaze(y) == false) {
			throw new IllegalArgumentException();
		} else if (arr[y][x] != '.' || (x == start.getX() && y == start.getY())
				|| (x == end.getX() && y == end.getY())) {
			return false;
		}
		// add wall
		else {
			arr[y][x] = '@';
		}
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				s += arr[i][j];
			}
			s += "\n";
		}
		return s;
	}

	// func/method to check if able can solve maze using graph
	public boolean isSolvable() {
		// define flag that will save if we can or cannot and new graph
		boolean flag = false;
		Graph<Place> g = new Graph<>();
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				if (arr[i][j] != '@') {
					try {
						g.addVertex(new Place(i, j, size));
					} catch (GraphException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				if (arr[i][j] != '@') {
					connectPlace(g, i, j);
				}
			}
		}
		try {
			flag = g.connected(start, end);// call connected on g
		} catch (GraphException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// connect arr[i][j] to place above down left and right if there is
	private void connectPlace(Graph<Place> g, int i, int j) {
		if (inmaze(i - 1)) {
			if (arr[i - 1][j] != '@' && g.hasEdge(new Place(i, j, size), new Place(i - 1, j, size)) == false)
				try {
					g.addEdge(new Place(i, j, size), new Place(i - 1, j, size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if (inmaze(i + 1)) {
			if (arr[i + 1][j] != '@' && g.hasEdge(new Place(i, j, size), new Place(i + 1, j, size)) == false)
				try {
					g.addEdge(new Place(i, j, size), new Place(i + 1, j, size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if (inmaze(j - 1)) {
			if (arr[i][j - 1] != '@' && g.hasEdge(new Place(i, j, size), new Place(i, j - 1, size)) == false)
				try {
					g.addEdge(new Place(i, j, size), new Place(i, j - 1, size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
		if (inmaze(j + 1)) {
			if (arr[i][j + 1] != '@' && g.hasEdge(new Place(i, j, size), new Place(i, j + 1, size)) == false)
				try {
					g.addEdge(new Place(i, j, size), new Place(i, j + 1, size));
				} catch (GraphException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	// func/method that create Collection of neighbours of v
	public Collection<Place> neighbours(Place v) {
		// define ints and array list
		int i, j;
		Collection<Place> n = new ArrayList<>();
		// get x and y
		i = v.getX();
		j = v.getY();
		if (inmaze(i - 1)) {
			if (arr[i - 1][j] != '@')
				n.add(new Place(i - 1, j, size));

		}
		if (inmaze(i + 1)) {
			if (arr[i + 1][j] != '@')
				n.add(new Place(i + 1, j, size));

		}
		if (inmaze(j - 1)) {
			if (arr[i][j - 1] != '@')
				n.add(new Place(i, j - 1, size));

		}
		if (inmaze(j + 1)) {
			if (arr[i][j + 1] != '@')
				n.add(new Place(i, j + 1, size));

		}
		return n;
	}
}

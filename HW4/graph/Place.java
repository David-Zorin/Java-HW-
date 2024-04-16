package graph;

public class Place {
	private int x;
	private int y;

	// constructor
	public Place(int x, int y, int bound) {
		if (x < 0 || x > bound - 1 || y < 0 || y > bound - 1) {
			throw new IllegalArgumentException();
		} else {
			this.x = x;
			this.y = y;
		}
	}

	// getter for x
	public int getX() {
		return x;
	}

	// getter for y
	public int getY() {
		return y;
	}

	// checking if two places are equals
	@Override
	public boolean equals(Object obj) {
		// casting otherwise wont work :"(
		Place other = (Place) obj;
		// if they equals return true else false
		if (this.x == other.x && this.y == other.y)
			return true;
		return false;
	}

	// function that calculate the hash code
	@Override
	public int hashCode() {
		return Long.hashCode(x) * 31 + Long.hashCode(y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

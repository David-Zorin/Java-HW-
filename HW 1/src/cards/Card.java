package cards;

public class Card {
	private int number;
	private int suit;

	// constructor that initializes Card with number and suit
	public Card(int num, int suit) {
		number = num;
		this.suit = suit;
	}

	// return the cart number
	public int getNum() {
		return number;
	}

	// return the cart suit
	public int getSuit() {
		return suit;
	}

	public String toString() {
		int shape;
		shape = this.suit;
		if (shape == 0) {
			return this.number + "C";
		}
		if (shape == 1) {
			return this.number + "D";
		}
		if (shape == 2) {
			return this.number + "H";
		} else {
			return this.number + "S";
		}
	}

	// comparing cards, returning 1 if bigger , 0 if same , -1 if smaller
	public int compareTo(Card other) {
		if (this.getNum() > other.getNum()) {
			return 1;
		} else if (this.getNum() < other.getNum()) {
			return -1;
		} else if (this.getSuit() > other.getSuit()) {
			return 1;
		} else if (this.getSuit() < other.getSuit()) {
			return -1;
		} else {
			return 0;
		}
	}

}

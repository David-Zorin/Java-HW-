package cards;

public class Deck {
	private Card[] deck;
	private int amount;

	// creating deck using given number
	public Deck(int num) {
		int x = 4 * num;
		int t = 0;
		amount = x;
		deck = new Card[x];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++) {
				deck[t] = new Card(i, j);
				t++;
			}
		}
	}

	// creating deck by taking number of cards from other deck(from the end)
	public Deck(Deck from, int num) {
		int maxSize = from.getNumCards();
		int cardsAmount = Math.min(num, maxSize);
		deck = new Card[cardsAmount];
		this.amount = cardsAmount;

		for (int i = 0; i <= cardsAmount - 1; i++) {
			deck[i] = from.takeOne();
		}
	}

	/*
	 * creating deck by combining the decks using the following method: last card
	 * from first deck, last card from second deck and so on till both decks are
	 * empty
	 */
	public Deck(Deck first, Deck second) {
		int i = 0;
		int size = first.getNumCards() + second.getNumCards();
		deck = new Card[size];
		this.amount = size;
		while (first.getNumCards() > 0 || second.getNumCards() > 0) {
			if (first.getNumCards() > 0) {
				deck[i] = first.takeOne();
				i++;
			}
			if (second.getNumCards() > 0) {
				deck[i] = second.takeOne();
				i++;
			}
		}
	}

	// return deck cards mount
	public int getNumCards() {
		return this.amount;
	}

	// take and return last card from deck
	public Card takeOne() {
		int i = this.amount;
		if (i == 0) {
			return null;
		}
		this.amount -= 1;
		return this.deck[i - 1];
	}

	// sort the deck using bubble sort
	public void sort() {
		Card temp;
		int size = this.amount;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (this.deck[j].compareTo(this.deck[j + 1]) > 0) {
					temp = this.deck[j];
					this.deck[j] = this.deck[j + 1];
					this.deck[j + 1] = temp;
				}
			}
		}
	}

	// Returns a string of the form: [NumLetter, NumLetter, ..]
	public String toString() {
		String s = "";
		for (int i = 0; i < this.amount; i++) {
			s += this.deck[i];
			if (i < this.amount - 1) {
				s += ", ";
			}
		}

		return "[" + s + "]";
	}
}

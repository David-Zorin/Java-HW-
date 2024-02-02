package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s;

	// constructor
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		this.players = new Player[2];
		this.players[0] = p1;
		this.players[1] = p2;
		if (this.s == null) {
			this.s = new Scanner(System.in);
		}
	}

	// return true if the play win , position [0][0]
	protected boolean doesWin(int i, int j) {
		if (i == 0 && j == 0) {
			return true;
		}
		return false;
	}

	// one move play
	protected boolean onePlay(Player p) {
		int i, j;
		do {
			System.out.println(p.getName() + ", please enter row and column: ");
			i = s.nextInt();
			j = s.nextInt();

			// set the player's move and print it
			if (isEmpty(i, j)) {
				set(i, j, p);
				System.out.println(this);

				// check if won, return print and return true
				if (doesWin(i, j)) {
					System.out.println(p.getName() + " wins!");
					return true;
				}
				return false;
			} else {
				System.out.println("There is a piece there already. Try again.");
			}
		} while (true); // if piece taken keep trying till stop is empty
	}

	public Player play() {
		// continue the game until the maximum number of turns (total number of cells)
		for (int turn = 0; turn < n * m; turn++) {
			Player currentPlayer = players[turn % players.length];

			// return winner when he got it (there must be a winner)
			if (onePlay(currentPlayer)) {
				return currentPlayer;
			}
		}
		// there must be a winner so never it will never return null 
		return null;
	}
}

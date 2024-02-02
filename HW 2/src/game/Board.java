package game;

public class Board {
	protected Player[][] board;
	protected int n, m;

	// constructor for board of size n by m
	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	// if [i][j] already in return false , else add player on this spot and return
	// true
	protected boolean set(int i, int j, Player p) {
		// check if i and j are positive in range of board size and if [i][j] position
		// empty
		if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == null) {
			board[i][j] = p;
			return true;
		}
		return false;
	}

	// check if position [i][j] in empty if so, return true
	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null) {
			return true;
		}
		return false;
	}

	// return player in position [i][j]
	public Player get(int i, int j) {
		if (isEmpty(i, j)) {
			return null;
		}
		return (board[i][j]);
	}

	// check if game board is full, is so return true
	public boolean isFull() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j)) {
					return false;
				}
			}

		}
		return true;
	}

	// print the board as 2d and add mark of players on it nicely
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == null) {
					result += ".";
				} else {
					result += board[i][j].getMark();
				}
			}
			result += "\n";
		}
		return result;
	}

	// returns longest line possible
	protected int maxLineContaining(int i, int j) {
		Player player = get(i, j);
		if (player == null) {
			return 0; // no player at the specified position
		}

		int maxLine = 1; // initialize with 1 for the current position

		// check horizontally right +left
		maxLine = Math.max(maxLine, countLine(i, j, 0, 1, player) + countLine(i, j, 0, -1, player) - 1);

		// check vertically down + up
		maxLine = Math.max(maxLine, countLine(i, j, 1, 0, player) + countLine(i, j, -1, 0, player) - 1);

		// check diagonally down-right + up-left + down-left + up-right
		maxLine = Math.max(maxLine, countLine(i, j, 1, 1, player) + countLine(i, j, -1, -1, player) - 1);
		maxLine = Math.max(maxLine, countLine(i, j, 1, -1, player) + countLine(i, j, -1, 1, player) - 1);

		return maxLine;
	}

	// helper function to count the length of the line in a specific direction
	private int countLine(int i, int j, int di, int dj, Player player) {
		int count = 0;

		// continue in the specified direction until reaching other mark/null or out of
		// matrix
		while (i >= 0 && i < n && j >= 0 && j < m && (get(i, j) == player || isEmpty(i, j))) {
			if (get(i, j) == player) {
				count++;
			}
			i += di;
			j += dj;
		}

		return count;
	}
}

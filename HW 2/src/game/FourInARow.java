package game;

public class FourInARow extends Game {
	
	// constructor with 6x7 board
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	// checking horizontal,vertical,diagonals for win (4 in line)
	@Override
	protected boolean doesWin(int i, int j) {
	    return hasWinningLine(i, j, 0, 1) || // Check horizontal line
	           hasWinningLine(i, j, 1, 0) || // Check vertical line
	           hasWinningLine(i, j, 1, 1) || // Check diagonal line (down-right)
	           hasWinningLine(i, j, 1, -1); // Check diagonal line (down-left)
	}
	
	// help function to check if there is winning line
	private boolean hasWinningLine(int i, int j, int di, int dj) {
	    int count = 1;
	    int nextI = i + di;
	    int nextJ = j + dj;

	    // check left, stopping at board edge or different mark
	    while (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && get(nextI, nextJ) == get(i, j)) {
	        count++;
	        nextI += di;
	        nextJ += dj;
	    }

	    nextI = i - di;
	    nextJ = j - dj;

	    // check right, stopping at board edge or different mark
	    while (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && get(nextI, nextJ) == get(i, j)) {
	        count++;
	        nextI -= di;
	        nextJ -= dj;
	    }

	    return count >= 4;
	}

	@Override
	protected boolean onePlay(Player p) {
		int col;
		do {
			System.out.println(p.getName() + ", please enter column: ");
			col = s.nextInt();

			if (col < 0 || col >= m) {
				System.out.println("Invalid column number can be only(0-6). Please try again.");
			} else {
				// find the lowest empty row in the chosen column
				int row = 0;
				while (row < n && !isEmpty(row, col)) {
					row++;
				}

				if (row < n) {
					set(row, col, p);
					System.out.println(this);
					//check winner
					if (doesWin(row, col)) {
						System.out.println(p.getName() + " wins!");
						return true;
					}
					return false;
				} 
				else {
					System.out.println("Column is full. Please choose another column.");
				}
			}
		} while (true);//keep going
	}
}

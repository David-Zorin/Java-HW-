package tree;

import java.util.Scanner;

public class ReversedWords {

	// returns the number of strings that have reversed word
	public static int checkReversed() {
		int count = 0;
		Node root = new Node();
		Scanner scanner = new Scanner(System.in);
		String input;

		// get input from user(using scanner) till "X" entered
		while (!(input = scanner.next()).equals("X")) {
			String reversed = "";
			for (int i = input.length() - 1; i >= 0; i--) {
				reversed += input.charAt(i);
			}
			if (root.num(reversed) > 0) {
				count++;
			}
			root.add(input);
		}
		// close scanner for good manners and return count
		scanner.close();
		return count;
	}
}

package tree;

public class Node {
	private int count;
	private Node[] children;

	// constructor
	public Node() {
		this.count = 0;
		this.children = new Node[26]; // ('z' - 'a' + 1)
	}

	// returns the number of times the string is in the tree
	public int num(String s) {
		int index;
		// base case, return the count
		if (s.length() == 0) {
			return count;
		}
		index = s.charAt(0) - 'a';
		if (children[index] == null) {
			return 0;
		}
		// recursion call with the substring starting from index 1
		return children[index].num(s.substring(1));
	}

	// add the string to the tree
	public void add(String s) {
		int index;
		// base case, add 1 to count and return
		if (s.length() == 0) {
			count++;
			return;
		}
		index = s.charAt(0) - 'a';
		if (children[index] == null) {
			children[index] = new Node();
		}
		// recursion call with the substring starting from index 1
		children[index].add(s.substring(1));
	}
}

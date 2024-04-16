package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
	private int[] a1;
	private int[] a2;

	// constructor
	public TwoArrays(int[] a1, int[] a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	//iterator 1
	private class Iterator1 implements Iterator<Integer> {
		// declare variables for inex and counter to check when bigger then count
		private int count = 0;
		private int counter = 0;

		@Override
		// return true if we have numbers in at least one array
		public boolean hasNext() {
			if (count < a1.length || count < a2.length)
				return true;
			return false;
		}

		@Override
		public Integer next() {
			// if we have numbers in both arrays
			if (count < a1.length && count < a2.length) {
				if (counter % 2 == 0) {
					counter++;
					return a1[count];
				} else {
					counter++;
					return a2[count++];
				}
			}

			// check where the numbers
			else if (count < a1.length) {
				return a1[count++];
			}
			return a2[count++];

		}

	}

	// create new iterator
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator1();
	}
}

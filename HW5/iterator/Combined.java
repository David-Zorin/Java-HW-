package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E> {
	private Iterable<E> first;
	private Iterable<E> second;

	// constructor
	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first = first;
		this.second = second;
	}

	// iterator 2
	private class Iterator2 implements Iterator<E> {
		// declare counter to know which array to go in
		private int counter = 0;
		// get the iterators
		private Iterator<E> theFirst = first.iterator();
		private Iterator<E> theSecond = second.iterator();

		@Override
		// if both true return true, else false
		public boolean hasNext() {
			if (theFirst.hasNext() == true || theSecond.hasNext() == true)
				return true;
			return false;
		}

		@Override
		public E next() {
			// if we have <E> in both
			if (theFirst.hasNext() == true && theSecond.hasNext() == true) {
				if (counter % 2 == 0) {
					counter++;
					return theFirst.next();
				} else {
					counter++;
					return theSecond.next();
				}
			}
			// check in which Iterable has <E>
			else if (theFirst.hasNext() == true) {
				return theFirst.next();
			}
			return theSecond.next();

		}

	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator2();
	}

}

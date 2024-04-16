package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equiv<E> {
	// define ArrayList
	private List<Set<E>> eqArray = new ArrayList<>();

	// help func/method that gets E and return his set
	private Set<E> find(E e) {
		for (Set<E> i : eqArray) {
			for (E j : i) {
				if (j.equals(e))
					return i;
			}
		}
		return null;
	}

	// check if e1,e2 "shkulim"
	public void add(E e1, E e2) {
		// set e1 and e2
		Set<E> set1 = find(e1);
		Set<E> set2 = find(e2);
		// check if they equal, return
		if (are(e1, e2) == true)
			return;

		// if both null so their not in any set, we create new one then
		else if (set1 == null && set2 == null) {
			Set<E> newset = new HashSet<>();
			newset.add(e2);
			newset.add(e1);
			eqArray.add(newset);
		}
		// if only one of them in set so add the other
		else if (set1 == null && set2 != null) {
			set2.add(e1);
		} else if (set1 != null && set2 == null) {
			set1.add(e2);
		}

		// if both in set cobine them to set1 and delete set2
		else {
			set1.addAll(set2);
			eqArray.remove(set2);
		}
	}

	// func/method to check if e1 and e2 equals
	public boolean are(E e1, E e2) {
		// if they are the same return true
		if (e1.equals(e2))
			return true;
		
		// cheak if they are the same set
		Set<E> set1 = find(e1);
		Set<E> set2 = find(e2);
		if (set1 == null || set2 == null)
			return false;
		else if (set1.equals(set2))
			return true;
		return false;
	}
}

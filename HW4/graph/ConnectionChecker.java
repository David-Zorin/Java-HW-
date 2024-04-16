package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
	private Set<V> checked = new HashSet<>();
	private GraphInterface<V> gf;

	// constructor
	public ConnectionChecker(GraphInterface<V> g) {
		gf = g;
	}

	// check if you can go from point 1 to point 2
	public boolean check(V v1, V v2) {
		boolean flag = false;
		Collection<V> n = gf.neighbours(v1);
		if (n == null)
			return false;
		if (n.contains(v2) == true)
			return true;
		checked.add(v1);
		for (V v : n) {// for every neighbour
			if (checked.contains(v) == false) {
				if (flag = check(v, v2))
					break;
			}
		}
		return flag;
	}

}

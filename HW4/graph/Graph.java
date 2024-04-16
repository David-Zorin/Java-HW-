package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<>();

	// add vertex to the vertices
	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v)) {
			throw new GraphException("point was in the gragh");
		}
		vertices.add(v);
	}

	public void addEdge(V v1, V v2) throws GraphException {
		if (vertices.contains(v1) == false || vertices.contains(v2) == false) {
			throw new GraphException("point wasnt in the gragh, oopsy");
		}
		if (hasEdge(v1, v2) == true) {
			throw new GraphException("the edge is already exists");
		}
		// if theres no edges create new set
		if (edges.get(v1) == null) {
			edges.put(v1, new HashSet<>());
		}
		edges.get(v1).add(v2);

		if (edges.get(v2) == null) {
			edges.put(v2, new HashSet<>());
		}
		edges.get(v2).add(v1);
	}

	// func/method to check if there is edge between two points
	public boolean hasEdge(V v1, V v2) {
		Set<V> set;
		set = edges.get(v1);
		if (set == null) {
			return false;
		}
		if (set.contains(v2)) {
			return true;
		}
		return false;
	}

	// func/method that checks if you can go from point 1 to point 2
	public boolean connected(V v1, V v2) throws GraphException {
		Set<V> checked;
		checked = new HashSet<>();
		if (vertices.contains(v1) == false) {
			throw new GraphException("vertex isnt exsits");
		}
		if (vertices.contains(v2) == false) {
			throw new GraphException("vertex isnt exsits");
		}
		if (v1.equals(v2)) {
			return true;
		}
		if (edges.get(v1) == null || edges.get(v2) == null) {
			return false;
		}
		checked.add(v1);
		// call achieveCheck func
		return achieveCheck(edges.get(v1), v2, checked);
	}

	// func/methos that check recursively if we can go from v1 to v2
	private boolean achieveCheck(Set<V> edgeset, V v2, Set<V> checked) {
		if (edgeset.contains(v2))
			return true;
		for (V ver : edgeset) {
			if (checked.contains(ver) == false) {
				// add the vertex to checked
				checked.add(ver);
				// recursive calls
				if (achieveCheck(edges.get(ver), v2, checked) == true)
					return true;
			}
		}
		return false;
	}
}

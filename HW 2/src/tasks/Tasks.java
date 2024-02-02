package tasks;

public class Tasks {
	private int num;
	private int[][] depended;

	// constructor
	public Tasks(int num) {
		this.num = num;
		this.depended = new int[num][num];
	}

	/*
	 * add dependency that says that task1 should be executed after task 2. if task1
	 * or task2 is not a valid number of tasks it will return false and otherwise
	 * true
	 */
	public boolean dependsOn(int task1, int task2) {
		if ((task1 >= 0 && task1 < num) && (task2 >= 0 && task2 < num)) {
			depended[task2][task1] = 1;
			return true;
		}
		return false;
	}

	/*
	 * Return an array in which all the tasks appear in an order that fulfills all
	 * the dependencies. If there is no such order (i.e., there is a circle of
	 * dependencies), then it will return null
	 */
	public int[] order() {
		int[] order = new int[num];
		int[] inDegree = new int[num]; // track in-degrees
		int completed = 0; // number of tasks completed

		// calculate in-degrees
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (depended[i][j] == 1) {
					inDegree[j]++;
				}
			}
		}
		// use a circular array to store tasks with 0 in-degree
		int startIndex = 0, endIndex = 0;
		int[] zeroDegree = new int[num];

		// initialize with tasks having 0 in-degree
		for (int i = 0; i < num; i++) {
			if (inDegree[i] == 0) {
				zeroDegree[endIndex++] = i;
			}
		}

		// perform topological sorting using a circular array
		while (completed < num) {
			if (startIndex == endIndex) {
				return null; // cycle detected
			}

			int task = zeroDegree[startIndex++]; // get task with 0 in-degree
			order[completed++] = task; // add task to order

			// decrement in-degrees of dependent tasks and check for cycles
			for (int j = 0; j < num; j++) {
				if (depended[task][j] == 1) {
					if (--inDegree[j] == 0) {
						zeroDegree[endIndex++] = j; // add to zero-degree list
						endIndex %= num;
					} else if (inDegree[j] < 0) {
						return null; // cycle detected
					}
				}
			}
		}
		return order;
	}
}

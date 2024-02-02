package tasks;

public class NamedTasks extends Tasks {
	private String[] names;

	// constructor
	public NamedTasks(String[] names) {
		super(names.length);
		this.names = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			this.names[i] = names[i];
		}
	}

	/*
	 * Add dependency that task1 should be executed after task2. If task1 or task2
	 * is not a valid name of tasks, it will return false and otherwise true
	 */
	public boolean dependsOn(String task1, String task2) {
		int index1 = getIndex(task1);
		int index2 = getIndex(task2);

		if (index1 != -1 && index2 != -1) {
			return super.dependsOn(index1, index2);
		}
		return false;
	}

	// get the index of a task by name
	private int getIndex(String taskName) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(taskName)) {
				return i;
			}
		}
		return -1; // task not found
	}

	/*
	 * Return an array in which all the tasks appear in an order that fulfills all
	 * the dependencies. If there is no such order (i.e., there is a circle of
	 * dependencies), then it will return null
	 */
	public String[] nameOrder() {
		int[] order = super.order();
		if (order == null) {
			return null; // Circle of dependencies detected
		}

		String[] nameOrder = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			nameOrder[i] = names[order[i]];
		}

		return nameOrder;
	}
}

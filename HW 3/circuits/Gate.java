package circuits;

public abstract class Gate {

	protected Gate[] inGates;

	// constructor
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}

	// calculate the boolean value of the gate.
	public boolean calc() throws CircuitException {
		if (inGates == null) {
			return func(null);
		}
		boolean[] inValues = new boolean[inGates.length];
		// loop to calculate every index in the array
		for (int i = 0; i < inValues.length; i++) {
			inValues[i] = inGates[i].calc();
		}
		// call the func function/method
		return func(inValues);
	}

	// abstract function/method that calculates what the gate is supposed to calculate
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	// abstract getter for name
	public abstract String getName();

	// abstract function/method that returns the gate after simplification
	public abstract Gate simplify();

	@Override
	public String toString() {
		String str = "";
		// if no "in's" return the name
		if (inGates == null)
			return getName();
		// else return the name with the "toString" of each in "[]"
		str += getName();
		str += "[";
		for (int i = 0; i < inGates.length; i++) {
			str += inGates[i].toString();
			// add "," between each one till the last
			if (i != inGates.length - 1)
				str += ", ";
		}
		str += "]";
		// return the string
		return str;
	}
}

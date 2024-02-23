package circuits;

public class AndGate extends Gate {

	// constructor
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// getter for name
	public String getName() {
		return "AND";
	}

	@Override
	// do what function suppose to do
	protected boolean func(boolean[] inValues) throws CircuitException {
		// check if null, throw exception
		if (inValues == null) {
			throw new CircuitException();
		}
		// if there is any false then return false
		for (int i = 0; i < inValues.length; i++) {
			if (inValues[i] == false) {
				return false;
			}
		}
		// all true, return true
		return true;
	}

	@Override
	// simplify gate
	public Gate simplify() {
		int index = 0;
		Gate[] newAndGate = new Gate[inGates.length];

		// for loop on the inGates array
		for (int i = 0; i < inGates.length; i++) {
			// it its False return it
			if (inGates[i].simplify() instanceof FalseGate)
				return FalseGate.instance();
			// if its TrueGate then continue
			else {
				if (inGates[i].simplify() instanceof TrueGate) {
					continue;
				}
				newAndGate[index] = inGates[i].simplify();
				index++;
			}
		}
		if (index == 1) {
			return newAndGate[0].simplify();
		}

		// if no one left then he is True
		else if (index == 0) {
			return TrueGate.instance();
		}
		// create new AndGate
		else {
			Gate[] sNewAndGate = new Gate[index];
			for (int j = 0; j < index; j++) {
				sNewAndGate[j] = newAndGate[j];
			}
			return new AndGate(sNewAndGate);
		}
	}
}

package circuits;

public class OrGate extends Gate {

	// constructor
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// getter for name
	public String getName() {
		return "OR";
	}

	@Override
	// do what function suppose to do
	protected boolean func(boolean[] inValues) throws CircuitException {
		// check if null, throw exception
		if (inValues == null) {
			throw new CircuitException();
		}
		// if there is any true then return true
		for (int i = 0; i < inValues.length; i++) {
			if (inValues[i] == true) {
				return true;
			}
		}
		// all false, return false
		return false;
	}

	@Override
	// simplify gate
	public Gate simplify() {
		int index = 0;
		Gate[] newOrGate = new Gate[inGates.length];

		// for loop on the inGates array
		for (int i = 0; i < inGates.length; i++) {
			// it its TrueGate return it
			if (inGates[i].simplify() instanceof TrueGate)
				return TrueGate.instance();
			// if its FalseGate then continue
			else {
				if (inGates[i].simplify() instanceof FalseGate) {
					continue;
				}
				newOrGate[index] = inGates[i].simplify();
				index++;
			}
		}
		if (index == 1) {
			return newOrGate[0].simplify();

			// if no one left then he is false
		} else if (index == 0) {
			return FalseGate.instance();
		}
		// create new OrGate
		else {
			Gate[] sNewOrGate = new Gate[index];
			for (int j = 0; j < index; j++) {
				sNewOrGate[j] = newOrGate[j];
			}
			return new OrGate(sNewOrGate);
		}
	}
}

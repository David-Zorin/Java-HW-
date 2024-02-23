package circuits;

public class NotGate extends Gate {

	// constructor that creates new Gate[] (array with "in" inside him)
	public NotGate(Gate in) {
		super(new Gate[] { in });
	}

	@Override
	// getter for name
	public String getName() {
		return "NOT";
	}

	@Override
	// do what function suppose to do
	protected boolean func(boolean[] inValues) throws CircuitException {
		// check if null or more then 1 game, throw exception
		if (inValues == null || inValues.length > 1) {
			throw new CircuitException();
		}
		// return the opposite
		return !inValues[0];
	}

	@Override
	// simplify gate
	public Gate simplify() {
		//if true return false
		if (inGates[0].simplify() instanceof TrueGate) {
			return FalseGate.instance();
		}
		//if false return true
		else if (inGates[0].simplify() instanceof FalseGate) {
			return TrueGate.instance();
		}
		//if Notgate so the grandson is returned
		else if (inGates[0] instanceof NotGate) {
			return inGates[0].inGates[0].simplify();
		}
		return this;
	}
}
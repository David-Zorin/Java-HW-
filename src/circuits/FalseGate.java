package circuits;

public class FalseGate extends Gate {
	private static FalseGate f = null;

	// constructor
	private FalseGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// returns false
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	@Override
	// name getter ("F")
	public String getName() {
		return "F";
	}

	@Override
	// simplify the game
	public Gate simplify() {
		return FalseGate.instance();
	}

	// singleton function/method
	public static Gate instance() {
		if (f == null)
			f = new FalseGate(null);
		return f;
	}

}

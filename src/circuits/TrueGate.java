package circuits;

public class TrueGate extends Gate {
	private static TrueGate t = null;
	
	
	//constructor
	private TrueGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// returns true
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	@Override
	// name getter ("T")
	public String getName() {
		return "T";
	}

	@Override
	// simplify the game
	public Gate simplify() {
		return TrueGate.instance();
	}

	// singleton function/method
	public static Gate instance() {
		if (t == null)
			t = new TrueGate(null);
		return t;
	}
}

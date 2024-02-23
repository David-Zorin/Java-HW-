package circuits;

public class VarGate extends Gate {
	private String name;
	private Gate g;

	// constructor
	public VarGate(String name) {
		super(null);
		this.name = name;
	}

	@Override
	// getter for name with added "V" at start
	public String getName() {
		return "V" + name;
	}

	@Override
	// do what function suppose to do
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (g == null)
			throw new CircuitException();
		return g.func(inValues);
	}

	// setter for value
	public void setVal(boolean value) {
		if (value == true) {
			g = TrueGate.instance();
		} else {
			g = FalseGate.instance();
		}
	}

	@Override
	// simplify gate
	public Gate simplify() {
		//if not null then its true/false return it
		if (g != null) {
			return g;
		}
		//if null return this
		return this;
	}

}

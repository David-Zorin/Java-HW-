package circuits;

public class And2Gate extends AndGate {

	// constructor
	public And2Gate(Gate g1, Gate g2) {
		super(new Gate[] { g1, g2 });
	}
}

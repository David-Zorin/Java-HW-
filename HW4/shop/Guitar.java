package shop;

public class Guitar extends Instrument {
	private Type type;

	// constrctor
	public Guitar(String company, int price, Type type) {
		super(company, price);
		this.type = type;
	}
	
	//type getter
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return String.format("Guitar(%s) %s", getType(), super.toString());
	}
}

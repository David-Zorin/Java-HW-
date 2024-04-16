package shop;

public class Piano extends Instrument {
	private int octaves; // amount of octaves

	// constructor
	public Piano(String company, int price, int octaves) {
		super(company,price);
		this.octaves = octaves;
	}

	// octaves getter
	public int getOctaves() {
		return octaves;
	}

	@Override
	public String toString() {
		return String.format("Piano(%d octaves) %s", getOctaves(), super.toString());
	}
}

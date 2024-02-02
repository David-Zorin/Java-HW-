package cities;

public class Road {
	private City city1;
	private City city2;
	private int length;

	// constructor that initializes Road given 2city names and the length of the road
	public Road(City city1, City city2, int length) {
		this.city1 = city1;
		this.city2 = city2;
		this.length = length;
		city1.connect(this);
		city2.connect(this);
	}

	// return the first connected city to the road
	public City getCity1() {
		return city1;
	}

	// return the second connected city to the road
	public City getCity2() {
		return city2;
	}

	// return the length of the road
	public int getLength() {
		return length;
	}
}

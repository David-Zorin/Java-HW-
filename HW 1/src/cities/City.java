package cities;

public class City {
	private String name;
	private Road[] roads;
	private int numRoads;

	// constructor that initializes the city name,amount of connected roads (max 10
	// roads connected)
	public City(String name) {
		this.name = name;
		numRoads = 0;
		roads = new Road[10];
	}

	// add road to the city roads
	public void connect(Road r) {
		if (numRoads < 10) {
			roads[numRoads] = r;
			numRoads++;
		}
	}

	// returns the nearest city based on the road length
	public City nearestCity() {
		// check if city have no roads connected
		if (this.numRoads == 0) {
			return null;
		}

		// create variables
		int shortest = this.roads[0].getLength();
		int shortestindex = 0;

		// loop to find shortest road connected to a city
		for (int i = 1; i < this.numRoads; i++) {
			if (this.roads[i].getLength() < shortest) {
				shortest = this.roads[i].getLength();
				shortestindex = i;
			}
		}
		// make sure its not the exact city name(location)
		if (this.roads[shortestindex].getCity1().toString() == this.toString()) {
			return this.roads[shortestindex].getCity2();
		}

		return this.roads[shortestindex].getCity1();
	}

	// return the city name
	public String toString() {
		return name;
	}
}

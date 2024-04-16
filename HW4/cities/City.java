package cities;

public class City implements Comparable<City> {
	private String name;
	private Country country;
	private int population;

	// constructor
	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}

	// name getter
	public String getName() {
		return name;
	}

	// country getter
	public Country getCountry() {
		return country;
	}

	// population getter
	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return String.format("%s (of %s)", name, country);
	}

	// comparing two citys checking first by country and then by the name of the
	// city
	@Override
	public int compareTo(City o) {
		if (country.compareTo(o.getCountry()) > 0) {
			return 1;
		} else if (country.compareTo(o.getCountry()) < 0) {
			return -1;
		} else {
			return name.compareTo(o.getName());
		}
	}

	// checking if two citys are equals
	@Override
	public boolean equals(Object obj) {
		// casting to city otherwise wont work :(
		City other = (City) obj;
		// if equals return true else false
		if ((name.equals(other.getName())) && (country.equals(other.getCountry())))
			return true;

		return false;
	}

}

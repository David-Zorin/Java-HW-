package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {
	private Set<City> cities;
	private String name;

	// constructor
	public Country(String name) {
		this.name = name;
		cities=new TreeSet<>();
	}

	// adds the city to the list of the country's cities
	public void addCity(City city) {
		if (city.getCountry().equals(this) == false)
			throw new IllegalArgumentException();
		cities.add(city);
	}

	// calculate population in country
	public int population() {
		int sum = 0;
		// loop to sum population for each city
		for (City c : cities) {
			sum += c.getPopulation();
		}
		return sum;
	}

	@Override
	public String toString() {
		return name;
	}

	// returns the list of all cities in the country that have less than under
	// residents, sorted by city name
	public List<City> smallCities(int under) {
		// define new array list
		List<City> l = new ArrayList<>();
		// loop to run on cities and for each city sum the population that is under and
		// return the list
		for (City c : cities) {
			if (c.getPopulation() < under)
				l.add(c);
		}
		return l;
	}

	//
	public String report() {
		// define new string
		String s = "";
		int count = 0;
		s += name + "(" + population() + ")" + " : ";
		for (City c : cities) {
			// if to add comma to the string
			if (count != cities.size() - 1)
				s += c.getName() + "(" + c.getPopulation() + ")" + ", ";
			else
				s += c.getName() + "(" + c.getPopulation() + ")";
			count++;
		}
		return s;
	}

	// checking if two countries are equals
	@Override
	public boolean equals(Object obj) {
		// casting to country otherwise wont work :(
		Country other = (Country) obj;
		// if the same return true else false
		if (name.equals(other.name))
			return true;
		return false;
	}

	// comparing two countires
	@Override
	public int compareTo(Country o) {
		return name.compareTo(o.toString());
	}

}

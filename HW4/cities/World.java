package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
	private Map<String, Country> countries;

	// constructor
	public World() {
		countries = new TreeMap<>();
	}

	// add country
	public void addCountry(String name) {
		countries.put(name, new Country(name));
	}

	// add city based on the data
	public void addCity(String name, String countryName, int population) {
		int count = 0;
		// create new city
		City c = new City(name, new Country(countryName), population);
		// loop to run on country name
		for (String i : countries.keySet()) {
			// check if equals
			if (i.equals(countryName))
				countries.get(i).addCity(c);
			;
			count++;
		}
		// if there is no country throw exception
		if (count == 0)
			throw new IllegalArgumentException();
	}

	// retrun population of all cities
	public int population() {
		int sum = 0;
		// loop to run on all countries and sum the population
		for (String i : countries.keySet()) {
			sum += countries.get(i).population();
		}
		return sum;
	}

	// return list of cities that their population is less then "under"
	public List<City> smallCities(int under) {
		// define new array list
		List<City> l = new ArrayList<>();
		// loop to run all "small" cities
		for (String i : countries.keySet()) {
			l.addAll(countries.get(i).smallCities(under));
		}
		return l;
	}

	// retrun string of the "report" (all details)
	public String report() {
		// create new string
		String s = "";
		// loop to get repport from every country
		for (String i : countries.keySet()) {
			s += countries.get(i).report() + "\n";
		}
		s += "Total population is " + population() + "\n";
		return s;
	}
}

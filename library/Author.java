package library;

public class Author {
	private String name;
	private int birthYear;

	// constructor that initializes Author name and birthYear
	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	// return the name of the author
	public String getName() {
		return name;
	}

	// return the birth year of the author
	public int getBirthYear() {
		return birthYear;
	}

	// calculate and return the current age of the author
	public int getAge(int thisYear) {
		return (thisYear - birthYear);
	}

	// return representation of the author
	public String toString() {
		return (name + "(" + birthYear + ")");
	}
}

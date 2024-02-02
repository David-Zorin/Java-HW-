package library;

public class Book {
	private String title;
	private Author auth;

	// constructor that initializes Book with the title and the author info
	public Book(String title, Author auth) {
		this.title = title;
		this.auth = auth;
	}

	// return the book title
	public String getTitle() {
		return title;
	}

	// return the author name
	public String getAuthorName() {
		return (auth.getName());
	}

	// return the author birth year
	public int getAuthorBirthYear() {
		return (auth.getBirthYear());
	}

	// return representation of the book
	public String toString() {
		return title + " written by " + auth.toString();
	}
}

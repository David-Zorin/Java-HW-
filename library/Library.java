package library;

public class Library {
	private Book[] books;

	// constructor that initializes an empty library with given size books.
	public Library(int size) {
		books = new Book[size];
	}

	/*
	 * Creates an instance of the Book class with the title and author name and puts
	 * it instead the bookNum location in the library.
	 */
	public void setBook(int bookNum, String title, Author auth) {
		if (bookNum < books.length) {
			Book newBook = new Book(title, auth);
			books[bookNum] = newBook;
		} else {
			System.out.println(bookNum + " is an invalid index, so the book " + title
					+ " wasnt added, Please choose a valid index");
		}
	}

	// return the book info that located in the bookNum index in the libary
	public Book getBook(int bookNum) {
		if (bookNum >= books.length) {
			return null;
		}
		return books[bookNum];
	}
}
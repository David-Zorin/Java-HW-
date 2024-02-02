package root;

public class Rooter {
	private double precision;

	// method to initializes the class with a given precision
	public Rooter(double precision) {
		this.precision = precision;
	}

	// method to set the precision
	public void setPrecision(double precision) {
		this.precision = precision;
	}

	// return the root of x, according to the precision
	public double sqrt(double x) {

		// check if x is a negative number
		if (x < 0) {
			System.out.print("There is no root for negative numbers, so there is no root for the number: ");
			return x;
		}

		double one = 1;
		double two = x;

		// loop that iterates until the guesses are close enough to the precision
		while ((one - two) > precision || (two - one) > precision) {
			one = (one + two) * (0.5);
			two = (x / one);

			// if 'one' equals to 'two' then its the root, we can return it
			if (one == two) {
				return one;
			}
		}
		// return the calculated square root
		return one;
	}

}

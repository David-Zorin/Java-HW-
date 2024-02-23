package images;

public class RGB {
	private double red;
	private double green;
	private double blue;
	//the given colors
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1,0,0);
	public static final RGB GREEN = new RGB(0,1,0);
	public static final RGB BLUE = new RGB(0,0,1);
	
	//function to check that the color value is valid (0 to 1)
	private static double check(double x){
		if(x>1) { //if bigger then 1 then reutrn 1
			return 1;
		}
		else if(x<0) { //if negative return 0
			return 0;
		}
		else { //if its between 0-1 return it
			return x;
		}
	}

	//constructor that getting all 3 colors
	public RGB(double red, double green, double blue) {
		this.red = check(red);
		this.green = check(green);
		this.blue = check(blue);
	}
	
	//constructor for grey
	public RGB(double grey) {
		red = check(grey);
		green = check(grey);
		blue = check(grey);
	}
	
	//getter for red color
	public double getRed() {
		return red;
	}
	
	//getter for blue color
	public double getBlue() {
		return blue;
	}
	
	//getter for green color
	public double getGreen() {
		return green;
	}
	
	//inverts the color (one minus the correct color for each)
	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}
	
	//return new filtered color
	public RGB filter(RGB filter) {
		return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
	}
	
	//return new color by adding 2 given colors
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		RGB s = new RGB(0);
		s.red = check(rgb1.red + rgb2.red);
		s.green = check(rgb1.green + rgb2.green);
		s.blue = check(rgb1.blue + rgb2.blue);
		return s;
	}
	
	//return new color by mixing 2colors using given formula
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		alpha = check(alpha);
		return new RGB(alpha * rgb1.red + (1 - alpha) * rgb2.red,
				alpha * rgb1.green + (1 - alpha) * rgb2.green,
				alpha * rgb1.blue + (1 - alpha) * rgb2.blue);
	}
	
	@Override
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
}

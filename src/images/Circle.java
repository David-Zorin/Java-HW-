package images;

public class Circle extends BaseImage {
	int centerX;
	int centerY;
	int radius;

	//constructor getting width, height, center of x, center of y, radius, RGB center and RGB outside
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width,height,center,outside);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	//constructor getting size, radius, RGB center, RGB outside
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size,size,center,outside);
		centerX = size/2;
		centerY = size/2;
		this.radius = radius;
	}
	
	@Override
	public RGB get(int x, int y) {
		double alpha,length;
		//if points are in image
		if (InImage(x,y)) {
			//calculate the length of the line from center to the index
			length = Math.sqrt(Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2));
			if (length > radius) {
				alpha = 0;
			}
			else {
				alpha = ( 1- length / (double)radius);
			}
			return RGB.mix(rgb1,rgb2,alpha);
		}
		//else return null
		return null;
	}
}

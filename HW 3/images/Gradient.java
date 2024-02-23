package images;

public class Gradient extends BaseImage {
	
	//constructor
	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height, start, end);
	}

	public RGB get(int x, int y) {
		double alpha;
		if (InImage(x,y)) {
			//calculate alpha for the mix
			alpha = 1 - ((double)x / getWidth());
			return RGB.mix(rgb1, rgb2 ,alpha);
		}
		else {
			return null;
		}
	}
}

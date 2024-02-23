package images;

public abstract class BaseImage implements Image {
	private int width;
	private int height;
	protected RGB rgb1;
	protected RGB rgb2;
	
	
	//constructor
	public BaseImage(int width, int height, RGB rgb1, RGB rgb2) {
		this.width = width;
		this.height = height;
		this.rgb1 = rgb1;
		this.rgb2 = rgb2;
	}
	
	//getter for width
	public int getWidth() {
		return width; 
	}
	
	//getter for height
	public int getHeight() {
		return height; 
	}
	
	//check if cord are in image
	public boolean InImage(int x, int y) {
		if ( (x <= getWidth()) && (y <= getHeight())) {
			return true;
		}
		return false;
	}
}

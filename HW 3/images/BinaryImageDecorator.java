package images;

public abstract class BinaryImageDecorator implements Image {
	private int width;
	private int height;
	
	public BinaryImageDecorator(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	// getter for width
	public int getWidth() {
		return width;
	}
	
	//getter for height
	public int getHeight() {
		return height; 
	}
	
	//this will return the new color depend on the class
	protected abstract RGB createColor(RGB rgb1, RGB rgb2);
}

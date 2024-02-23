package images;

public abstract class ImageDecorator implements Image {
	protected Image g;
	protected RGB rgb;

	// constructor getting image
	public ImageDecorator(Image g) {
		this.g = g;
	}

	// constructor getting image and RBG
	public ImageDecorator(Image g, RGB rgb) {
		this.g = g;
		this.rgb = rgb;
	}

	// getter for with
	public int getWidth() {
		return g.getHeight();
	}

	// getter for height
	public int getHeight() {
		return g.getWidth();
	}
}

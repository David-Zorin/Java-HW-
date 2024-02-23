package images;

public class Invert extends ImageDecorator {

	// constructor
	public Invert(Image base) {
		super(base);
	}

	@Override
	public RGB get(int x, int y) {
		return g.get(x, y).invert();
	}

}

package images;

public class Transpose extends ImageDecorator {

	public Transpose(Image g) {
		super(g);
	}

	@Override
	public RGB get(int x, int y) {
		// swap x,y to y,x
		return g.get(y, x);
	}

}

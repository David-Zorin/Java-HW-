package images;

public class Filter extends ImageDecorator {

	//constructor
	public Filter(Image base, RGB filter) {
		super(base,filter);
	}

	@Override
	public RGB get(int x, int y) {
		return g.get(x,y).filter(rgb);
	}
	
}

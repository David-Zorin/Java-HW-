package images;

public class Superpose extends BinaryImageDecorator {
	private Image g1;
	private Image g2;
	
	public Superpose(Image base1, Image base2) {
		super(Math.max(base1.getWidth(), base2.getWidth()),
				Math.max(base1.getHeight(), base2.getHeight())); // sending parameters are the max width and height
		this.g1 = base1;
		this.g2 = base2;
	}

	@Override
	public RGB get(int x, int y) {
		//if both declared use superpose method
		if ((g1.get(x,y) != null) && (g2.get(x,y) != null)){
			return createColor(g1.get(x,y),g2.get(x,y));
		}
		//if only one declared then take his color
		else if ((g1.get(x,y) != null) || (g2.get(x,y) != null)){
			if (g1.get(x,y) == null) {
				return g2.get(x, y);
			}
			return g1.get(x, y);
		}
		//both undeclared so use black
		else
			return RGB.BLACK;
	}

	@Override
	//using superpose
	protected RGB createColor(RGB rgb1, RGB rgb2) {
		return RGB.superpose(rgb1, rgb2);
	}
}


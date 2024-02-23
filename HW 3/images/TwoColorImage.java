package images;

public class TwoColorImage extends  BaseImage{
	private TwoDFunc func;
	
	//constructor
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width,height,zero,one);
		this.func = func;
	}
	
	@Override
	//get image interface
	public RGB get(int x, int y) {
		//declare variables
		double alpha;
		double newalpha;
		double newx = (double)x / getWidth(); 
		double newy = (double)y / getHeight();
		
		//use func f to decide color
		newalpha = 1 - func.f(newx, newy);
		
		//make sure max is 1
		if(newalpha > 1){
			alpha=1;
		}
		//make sure minimum is 0
		else if(newalpha<0) {
			alpha=0;
		}
		//we good keep the same
		else {
			alpha=newalpha;
		}
		//return mixed color
		return RGB.mix(rgb1, rgb2, alpha);
			
	}
}


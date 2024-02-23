package iterator;

public class Fibonacci implements MyIterator {
	private int upperBound; 
	//define two variables for last 2 numbers in the fibo series:
	private int firstlast;
	private int secondlast;
	private int timerun; //'helping' variable
	
	//constructor
	public Fibonacci(int upperBound){
		this.upperBound = upperBound;
		firstlast = 1;
		secondlast = 1;
		timerun = 0;	
	}
	
	
	@Override
	//check if next number is bigger than upperBound
	public boolean hasNext(){
		if (firstlast + secondlast <= upperBound) {
			return true;
		}
		else {
			return false;
		}
	}

	
	@Override
	//calculate the  next number in the fibo series
	public int next() {
		int temp;
		if (timerun == 0 || timerun == 1) { //check if this first or second time
			timerun++;
			return firstlast;
		}
		if (hasNext() == false){//check if next number is bigger than upperBound
			return firstlast;
		}
		temp = firstlast; //calculate next number and return him
		firstlast = firstlast + secondlast;
		secondlast = temp;
		return firstlast;
	}
}
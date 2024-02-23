package iterator;
import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
	private int []x;
	private int index;
	
	//constructor
	public MyArray(int[]x){
		this.x=x;
		index=0;
	}
	
	@Override
	public boolean hasNext() {
		if (index<x.length) {
			return true;
		}
		return false;
	}
	
	
	@Override
	//run on the array and return the next number
	public int next() {
		if(index>=x.length)
			throw new NoSuchElementException();
		return x[index++];
	}
}

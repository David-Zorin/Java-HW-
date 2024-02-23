package iterator;

public class IteratorToString {
	//gets iterator 'it' as input
	public static String toString(MyIterator it) {
		StringBuilder b = new StringBuilder(); //create new string using the crazy effective StringBuilder
		b.append("["); // start with [
		
		//while there is next number add it with space
		while(it.hasNext()==true) {
			b.append(it.next()+" ");
		}
		b.deleteCharAt(b.length() - 1 ); //delete the last extra space
		b.append("]"); //end string with ]
		return b.toString(); //return the string 'b' we just created.
	}
}


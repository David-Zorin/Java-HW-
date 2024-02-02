package bank;

public class ProAccount extends Account {
	private int[] history;
	private int index;

	//constructor
	public ProAccount(String name) {
		super(name);
		history = new int[100];
		index = 0;
	}

	//add money to ProAccount using account add function and save history
	@Override
	public void add(int amount) {
		super.add(amount);
		history[index] = super.getShekels();
		index += 1;
	}

	//toString override to add history of account
	@Override
	public String toString() {
		String maString = "[";
		for (int i = 0 ; i<index ; i++) {
			maString += history[i];
			if(i + 1 != index) {
				maString += ',';
			}
		}
		maString += "]";
		
		return (super.toString()+ " " + maString);
	}

	//transfer money between 2accounts (from, to)
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(-amount);
		to.add(amount);
	}
}

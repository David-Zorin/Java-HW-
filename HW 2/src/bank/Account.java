package bank;

public class Account {
	private String name;
	private int money;

	// constructor that get account name
	public Account(String name) {
		this.name = name;
		money = 0;
	}

	// getter for money
	public int getShekels() {
		return money;
	}

	// getter for name
	public String getName() {
		return name;
	}

	// add/remove money from account
	public void add(int amount) {
		money += amount;
	}

	// toString
	@Override
	public String toString() {
		return (name + " has " + money + " shekels");
	}
}

package shop;

public abstract class Instrument {
	private int price;
	private String company;
	private int Serialnum;
	private static int Serial=0;
	
	//constructor
	public Instrument(String company, int price) {
		this.company = company;
		this.price = price;
		Serialnum = Serial;
		Serial++;
	}

	//price getter
	public int getPrice() {
		return price;
	}
	
	//company getter
	public String getCompany() {
		return company;
	}
	
	//serial number getter
	public int getSerial() {
		return Serialnum;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d), price = %d",getCompany(),getSerial(),getPrice());
	}
}

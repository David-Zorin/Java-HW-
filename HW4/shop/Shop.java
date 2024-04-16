package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	//define the ArrayList of Instruments
	private List<Instrument> instrumentArray=new ArrayList<>();
	
	//add instrument to ArrayList
	public void add(Instrument i) {
		instrumentArray.add(i);
	}
	
	//serial number getter
	public Instrument get(int serial) {
		//loop to run on instruments and check serial number
		for(Instrument i: instrumentArray) {
			if(i.getSerial()==serial)
				return i;
		}
		return null;
	}
	
	
	//retrun list of integers containning all serial numbers
	public List<Integer> allSerials() {
		//define new ArrayList of Integers
		List<Integer> serialArray=new ArrayList<>();
		//loop to run on Instruments and add serial number to new arraylist
		for(Instrument i:instrumentArray) {
			serialArray.add(i.getSerial());
		}
		return serialArray;
	}
	
	
	//return list of integers containning all serial number that are guitar of type "t"
	public List<Integer> guitarsOfType(Type t){
		//define new ArrayList of Integers
		List<Integer> serialArray=new ArrayList<>();
		//loop to run on Instruments and if they are guitar add their serial to the new arraylist
		for(Instrument i:instrumentArray) {
			if(i instanceof Guitar && ((Guitar) i).getType() == t)
				serialArray.add(i.getSerial());
		}
		return serialArray;
	}
	
	
	//removes/sells the instrument of the same serial number, if its last guitar then sorry we cant remove/sell 
	public void sell(int serial) throws MusicShopException{
		int guitarcounter = 0;
		//get instrument with serial number as "serial"
		Instrument g = get(serial);
		//check if he exists if not throw exception
		if(g == null)
			throw new MusicShopException("Instrument doesn't exsits");
		
		//check if he is guitar
		else if (g instanceof Guitar){
			//loop to count how many guitars we have
			for(Instrument i: instrumentArray) {
				if (i instanceof Guitar)
					guitarcounter++;
			}
			//if there is only 1guitar in shop then throw exception(we dont sell)
			if( guitarcounter == 1) {
				throw new MusicShopException("only one guiter, cant sell");
			}
			else {
				instrumentArray.remove(g);
			}
		}
		//if not guitar remove/sell it
		else
			instrumentArray.remove(g);
	}

	public int sellAll(int[] serials) {
		int counter = 0;
		//loop to run on the array
		for(int i = 0; i < serials.length; i++) {
			try {
				//try to sell
				sell(serials[i]);
			}
			//if we catched the exepction the sell didnt work, update counter
			catch(MusicShopException e) {
				counter++;
				}
		}
		return counter;
	}
}

package izelcavusoglu;

import java.util.Random;

public class Deneme {

	public int bol() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int bolen = r.nextInt(2) + 1;

		return 100 / bolen;
	}

	// private double calculateCoeff�cent(String from, String to) {
	// // TODO Auto-generated method stub
	//
	// Random r = new Random();
	// int rangeMin=0;
	// int rangeMax=4;
	// double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
	// return randomValue;
	// }
	//
	// private double convertTo(String from, String to, double amount) {
	// // TODO Auto-generated method stub
	//
	// double coefficent=calculateCoeff�cent(from,to);
	// return amount*coefficent;
	// }

}

package com.cavusoglu.exchange;

import java.util.HashMap;

/**
 * This class is used for holding all the functionality of the money exchanging
 * transaction
 * 
 * @version 2015
 * @author Izel Cavusoglu
 */

public class MoneyExchange {

	private HashMap<String, Double> coefficentMap = new HashMap<String, Double>();

	public MoneyExchange() {
		coefficentMap.put("USD/GBP", 0.66);
		coefficentMap.put("EUR/GBP", 0.74);
		coefficentMap.put("TL/GBP", 0.28);
		coefficentMap.put("USD/EUR", 0.89);
		coefficentMap.put("USD/TL", 2.35);
		coefficentMap.put("TL/EUR", 0.37);
	}

	public String concatParity(String currency1, String currency2) {

		/*
		 * Concatenates two different currencies' string symbol.
		 */

		String pair = currency1;
		pair = pair.concat("/").concat(currency2);
		return pair;
	}

	public double searchCoefficentMap(String currency1, String currency2)
			throws CoefficentDoesntFoundException {

		/*
		 * This method looks for concatenated symbols of two currencies at hash
		 * map.
		 */

		if (currency1.equals(currency2)) {
			return 1.0;
		}

		if (coefficentMap.get(concatParity(currency1, currency2)) != null) {
			return coefficentMap.get(concatParity(currency1, currency2));
		} else {
			if (coefficentMap.get(concatParity(currency2, currency1)) != null) {
				return (1 / coefficentMap
						.get(concatParity(currency2, currency1)));
			} else {
				throw new CoefficentDoesntFoundException();
			}
		}

	}

	public double calculate(String currency1, String currency2, double amount)
			throws NegativeAmountException, CoefficentDoesntFoundException {

		if (amount < 0) {
			throw new NegativeAmountException();
		}
		return amount * searchCoefficentMap(currency1, currency2);

	}

}

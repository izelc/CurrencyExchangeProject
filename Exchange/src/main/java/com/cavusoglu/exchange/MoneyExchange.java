package com.cavusoglu.exchange;

/**
 * This class is used for holding all the functionality of the money exchanging
 * transaction
 * 
 * @version 2015
 * @author Izel Cavusoglu
 */

public class MoneyExchange {

	private Charts currencyCharts;

	public MoneyExchange() { /* Creator pattern is used. */
		currencyCharts = new Charts();
	}

	public String concatParity(String currency1, String currency2) {

		/* Concatenates two different currencies' string symbol. */

		String pair = currency1;
		pair = pair.concat("/").concat(currency2);
		return pair;
	}

	private boolean hasCurrencyPair(String currency1, String currency2) {

		/* Checks if given currency parity exist in charts */

		if (currencyCharts.getCurrencyCharts().get(
				concatParity(currency1, currency2)) == null) {
			return false;
		} else {
			return true;
		}

	}

	public double searchCurrencyCharts(String currency1, String currency2)
			throws CurrencyPairDoesntFoundException {

		/*
		 * This method looks for concatenated symbols of two currencies at hash
		 * map.
		 */

		if (currency1.equals(currency2)) {
			return 1.0;
		}

		if (hasCurrencyPair(currency1, currency2)) {
			return currencyCharts.getCurrencyCharts().get(
					concatParity(currency1, currency2));
		} else if (hasCurrencyPair(currency2, currency1)) {
			return (1 / currencyCharts.getCurrencyCharts().get(
					concatParity(currency2, currency1)));
		} else {
			throw new CurrencyPairDoesntFoundException();
		}
	}

	public double calculate(String currency1, String currency2, double amount)
			throws NegativeAmountException, CurrencyPairDoesntFoundException {

		/*
		 * Calculates equivalent given amount of currency1 with respect to
		 * currency2
		 */

		if (amount < 0) {
			throw new NegativeAmountException();
		}
		return amount * searchCurrencyCharts(currency1, currency2);
	}

}

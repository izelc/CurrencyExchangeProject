package com.cavusoglu.exchange;

/**
 * This class is made for summing different currencies dynamically.
 * 
 * @author Izel Cavusoglu
 */

public class SumOfCurrencies {

	private MoneyExchange moneyExchange;

	public SumOfCurrencies() {
		moneyExchange = new MoneyExchange();
	}

	public String writeTheOperation(String operationThatContinues,
			String amount, String currencyUnit) {
		return operationThatContinues + amount + " " + currencyUnit + " + ";
	}

	public String addCurrencies(String addentCurrencyUnit,
			String resultCurrencyUnit, double addentCurrencyAmount,
			double totalCurrencyAmount) throws Exception {
		/*
		 * this method adds money to existing result currency. It's very
		 * eligible for adding more than two currencies.
		 */
		double sum = totalCurrencyAmount
				+ moneyExchange.calculate(addentCurrencyUnit,
						resultCurrencyUnit, addentCurrencyAmount);
		return String.format("%.02f", sum);
	}

	public String addCurrencies(String addentCurrencyUnit1,
			String addentCurrencyUnit2, double addentCurrencyAmount1,
			double addentCurrencyAmount2, String resultCurrencyUnit) throws Exception {
		/*
		 * this method sums two different currencies with respect to given
		 * different currency.
		 */
		double sum = moneyExchange.calculate(addentCurrencyUnit1,
				resultCurrencyUnit, addentCurrencyAmount1)
				+ moneyExchange.calculate(addentCurrencyUnit2,
						resultCurrencyUnit, addentCurrencyAmount2);
		return String.format("%.02f", sum) + " " + resultCurrencyUnit;
	}

}

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

	public String addCurrencies(String addentCurrencyUnit ,String resultCurrencyUnit, double addentCurrencyAmount,
			double totalCurrencyAmount) {
		double sum =  totalCurrencyAmount+moneyExchange.calculate(addentCurrencyUnit, resultCurrencyUnit,
			addentCurrencyAmount);
		return String.format("%.02f", sum);
	}

}

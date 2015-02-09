package com.cavusoglu.exchange;

import java.util.HashMap;

public class Charts {
	

	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();

	public Charts() {
		
		currencyCharts.put("USD/GBP", 0.66);
		currencyCharts.put("EUR/GBP", 0.74);
		currencyCharts.put("TL/GBP", 0.28);
		currencyCharts.put("USD/EUR", 0.89);
		currencyCharts.put("USD/TL", 2.35);
		currencyCharts.put("TL/EUR", 0.37);
	}
	
	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}
	
	

}

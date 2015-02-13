package com.cavusoglu.exchange;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

public class Charts {

	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();
	private String cof;

	public Charts() {

		try {
			Document document = Jsoup
					.connect("https://www.google.com/finance?q=USDJPY&ei=vBreVKnAAoOYwQO7toCwAQ")
					.get();
			
		
		cof=document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(1) > td:nth-child(2)")
					.text().substring(2);
		
		currencyCharts.put("USD/GBP", Double.parseDouble(cof));
		
		
	     cof=document
		.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(2) > td:nth-child(2)")
		.text().substring(2);

currencyCharts.put("USD/EUR", Double.parseDouble(cof));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currencyCharts.put("EUR/GBP", 0.74);
		currencyCharts.put("TL/GBP", 0.28);
		
		currencyCharts.put("USD/TL", 2.35);
		currencyCharts.put("TL/EUR", 0.37);
	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

}

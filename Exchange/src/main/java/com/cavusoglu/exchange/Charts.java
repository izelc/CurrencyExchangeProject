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
					.connect(
							"https://www.google.com/finance?q=USDJPY&ei=vBreVKnAAoOYwQO7toCwAQ")
					.get();
			cof = document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(1) > td:nth-child(2)")
					.text().substring(2);
			currencyCharts.put("USD/GBP", Double.parseDouble(cof));

			cof = document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(2) > td:nth-child(2)")
					.text().substring(2);
			currencyCharts.put("USD/EUR", Double.parseDouble(cof));

			document = Jsoup
					.connect(
							"https://www.google.com/finance?q=GBPUSD&ei=DYTeVLicKJLCwAPxwoDQAw")
					.get();
			cof = document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(2) > td:nth-child(2)")
					.text().substring(2);
			currencyCharts.put("GBP/EUR", Double.parseDouble(cof));

			document = Jsoup
					.connect(
							"https://www.google.com/finance?q=CURRENCY%3ATRY&ei=FoTeVKCkKIu-wAP9-IDACA")
					.get();
			cof = document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(1) > td:nth-child(2)")
					.text().substring(2);
			currencyCharts.put("TL/GBP", Double.parseDouble(cof));

			document = Jsoup
					.connect(
							"https://www.google.com/finance?q=CURRENCY%3ATRY&ei=FoTeVKCkKIu-wAP9-IDACA")
					.get();
			cof = document
					.select("#currency_value > div.sfe-break-bottom-4 > span.pr > span")
					.text();
			cof = cof.substring(0, cof.length() - 4);
			currencyCharts.put("TL/USD", Double.parseDouble(cof));

			document = Jsoup
					.connect(
							"https://www.google.com/finance?q=CURRENCY%3ATRY&ei=FoTeVKCkKIu-wAP9-IDACA")
					.get();
			cof = document
					.select("#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child(3) > td:nth-child(2)")
					.text().substring(2);
			currencyCharts.put("TL/EUR", Double.parseDouble(cof));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

}

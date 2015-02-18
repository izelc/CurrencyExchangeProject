package com.cavusoglu.exchange;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

public class Charts {

	private HashMap<String, Double> currencyCharts = new HashMap<String, Double>();

	public Charts() {

		try {

			currencyCharts.put("USD/GBP", connectToData("USDJPY", 1));

			currencyCharts.put("EUR/USD", connectToData("EURJPY", 1));

			currencyCharts.put("EUR/GBP", connectToData("EURJPY", 2));

			currencyCharts.put("TL/GBP", connectToData("TRYJPY", 2));

			currencyCharts.put("TL/USD", connectToData("TRYJPY", 1));

			currencyCharts.put("TL/EUR", connectToData("TRYJPY", 3));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, Double> getCurrencyCharts() {
		return currencyCharts;
	}

	private double connectToData(String q, int index) {
		/*
		 * Connects related section of google finance to find related parity.
		 * Returns the parity that we search as double.
		 */

		String site = "https://www.google.com/finance?q=" + q;
		Document document = null;
		String cssPath = "#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child("
				+ index + ") > td:nth-child(2)";
		try {
			document = Jsoup.connect(site).get();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return convertCurrencyDataToDouble(document.select(cssPath).text());

	}

	private double convertCurrencyDataToDouble(String str) {
		/*
		 * removes all non numeric characters in data and then converts data to
		 * double
		 */
		str = str.replaceAll("[^\\d.]", "");
		return Double.parseDouble(str);
	}

}

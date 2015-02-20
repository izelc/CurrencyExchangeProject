package com.cavusoglu.exchange;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Deneme {
	
	public static void main(String[] args){
   
		
		String num= "1.5{}$$$#@";
		
		System.out.println(convertCurrencyDataToDouble(num)+6);
		
		System.out.println(
				connectToData("EURJPY",1));
		
	}
	
	
	
	
	
	
	
	
	
	public static double connectToData(String q, int index) {
		String site="https://www.google.com/finance?q="+q;
		System.out.println(site);
	
		Document document = null;
		try {
			document = Jsoup
					.connect(
							site)
					.get();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("o site yok");
		}
		
		String cssPath="#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child("+index+") > td:nth-child(2)";
	       
		return  convertCurrencyDataToDouble(document
				.select(cssPath)
				.text());
				
				
        
	}
	
	
	public String obtainCSSPath(int index) {
	  return "#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child("+index+") > td:nth-child(2)";

	}
	
	public static double convertCurrencyDataToDouble(String str) {
		//removes all non numeric characters in data, and then converts data to double
		str = str.replaceAll("[^\\d.]", "");
		return Double.parseDouble(str);
	}

}




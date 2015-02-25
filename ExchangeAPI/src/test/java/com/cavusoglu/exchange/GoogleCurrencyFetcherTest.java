package com.cavusoglu.exchange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GoogleCurrencyFetcherTest {
	
	DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
	
		 @Before
		 public void before() throws IOException {
		 Document doc = (Document) Jsoup.parse(readFile("exampleGoogleFinanceTRYUSD"));
		 Mockito.doReturn(doc).when(mock).getDocument("TRYUSD");
		 }
		
		 @Test
		 public void testGetParity() throws IOException {
		GoogleCurrencyFetcher googleCurrencyFetcher= new GoogleCurrencyFetcher(mock);
		System.out.println(googleCurrencyFetcher.getParity("TRYUSD"));
	
		 }
		//
		// @Test
		// public void verifyConvertCurrencyDataToDouble() throws Exception {
		// String str = "$ 0.4072";
		// chart.getParity(chart.getDocument("TRYJPY"),
		// chart.findParticularCssPath(1));
		// Mockito.verify(chart).convertCurrencyDataToDouble(str);
		//
		// }
		//
		 /**Reads file from given path
		 * @param path file path
		 * @return file as string text
		 * @throws IOException
		 */
		 private String readFile(String path) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader(path));
		 String everything;
		 try {
		 StringBuilder sb = new StringBuilder();
		 String line = br.readLine();
		
		 while (line != null) {
		 sb.append(line);
		 sb.append(System.lineSeparator());
		 line = br.readLine();
		 }
		 everything = sb.toString();
		 } finally {
		 br.close();
		 }
		 return everything;
		 }




   
  


}

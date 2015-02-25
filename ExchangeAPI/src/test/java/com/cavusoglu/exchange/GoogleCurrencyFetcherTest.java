package com.cavusoglu.exchange;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GoogleCurrencyFetcherTest {
	
	DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
	
		 @Before
		 public void before() throws IOException {
		 Document doc = Jsoup.parse(readFile("exampleGoogleFinanceTRYUSD.html"));
		 Mockito.doReturn(doc).when(mock).getDocument("TRYUSD");
		 }
		
		 @Test
		 public void testGetParity() throws IOException {
		GoogleCurrencyFetcher googleCurrencyFetcher= new GoogleCurrencyFetcher(mock);
		assertEquals(0.4035,googleCurrencyFetcher.getParity("TRYUSD"), 0.1);
	
		 }
		
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

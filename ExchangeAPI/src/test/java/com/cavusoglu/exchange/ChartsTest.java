package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class ChartsTest {
	GoogleCurrencyFetcher mock = Mockito.mock(GoogleCurrencyFetcher.class);

@Before
	public void before() {
	Mockito.when(mock.getParity(Matchers.anyString())).thenReturn(3.0);

	}


@Test
public void testFillHashMap() throws Exception {
Charts instance = Charts.getInstance();
instance.fillHasHmap(mock);
assertEquals(3, instance.getCurrencyCharts().get("TL/USD"), 0.001);



}
	
	
	
	
	
	
	
	
	
	
	
	
	

	// @Before
	// public void before() throws IOException {
	// chart = Mockito.spy(new Charts());
	// Document doc = Jsoup.parse(readFile("exampleGoogleFinanceTRYJPY.html"));
	// Mockito.doReturn(doc).when(chart).getDocument("TRYJPY");
	// }
	//
	// @Test
	// public void testConnectToData() throws IOException {
	// double data = chart.getParity(chart.getDocument("TRYJPY"),
	// chart.findParticularCssPath(1));
	// assertEquals(0.4072, data, 0.0000);
	// }
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
	// /**Reads file from given path
	// * @param path file path
	// * @return file as string text
	// * @throws IOException
	// */
	// private String readFile(String path) throws IOException {
	// BufferedReader br = new BufferedReader(new FileReader(path));
	// String everything;
	// try {
	// StringBuilder sb = new StringBuilder();
	// String line = br.readLine();
	//
	// while (line != null) {
	// sb.append(line);
	// sb.append(System.lineSeparator());
	// line = br.readLine();
	// }
	// everything = sb.toString();
	// } finally {
	// br.close();
	// }
	// return everything;
	// }

	@Test
	public void testName() throws Exception {
		Charts charts = Charts.getInstance();
	   // Thread.sleep(20000);
		ChartsSearcher cs = new ChartsSearcher(charts);
		cs.searchCurrencyCharts("USD", "EUR");
	//	cs.searchCurrencyCharts("JPY", "TL");
		
	}

//	@Test
//	public void chartFixedService() throws Exception {
//		Charts charts = Charts.getInstance();
//		Thread.sleep(45000);
//	}

}

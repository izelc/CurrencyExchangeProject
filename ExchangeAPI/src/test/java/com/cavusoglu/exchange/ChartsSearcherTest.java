package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

public class ChartsSearcherTest {
	
	Charts mock = Mockito.mock(Charts.class);
	
	@Before
 public void before() {
		HashMap<String, Double> exampleChart = new HashMap<String, Double>();
		exampleChart.put("USD/TL", 2.35);
		exampleChart.put("GBP/TL", 3.0);
		exampleChart.put("EUR/GBP", 1.1);

		
		Mockito.when(mock.getCurrencyCharts()).thenReturn(
				exampleChart);

}

	@Test
	public void testConcatParity() {
		assertEquals("EUR/USD", new ChartsSearcher().concatParity("EUR", "USD"));
		assertEquals("GBP/USD", new ChartsSearcher().concatParity("GBP", "USD"));
		assertEquals("/", new ChartsSearcher().concatParity("", ""));
	}

	@Test
	public void testSearchCurrencySearchOnCharts() {
	
		
		

		assertEquals(2.35,
				new ChartsSearcher(mock).searchCurrencyCharts("USD", "TL"), 0.0001);

		assertEquals(1 / 2.35,
				new ChartsSearcher(mock).searchCurrencyCharts("TL", "USD"), 0.0001);

		assertEquals(1.1,
				new ChartsSearcher(mock).searchCurrencyCharts("EUR", "GBP"), 0.0001);

	}
	
	@Test
	public void testHasCurrencyPair() throws Exception {
		assertTrue(new ChartsSearcher(mock).hasCurrencyPair("USD", "TL"));
	}
	
	

}

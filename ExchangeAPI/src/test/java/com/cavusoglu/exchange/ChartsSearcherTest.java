package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

public class ChartsSearcherTest {

	@Test
	public void testConcatParity() {
		assertEquals("EUR/USD", new ChartsSearcher().concatParity("EUR", "USD"));
		assertEquals("GBP/USD", new ChartsSearcher().concatParity("GBP", "USD"));

		assertEquals("/", new ChartsSearcher().concatParity("", ""));
	}

	@Test
	public void testSearchCurrencySearchOnCharts() {
		HashMap<String, Double> exampleChart = new HashMap<String, Double>();
		exampleChart.put("USD/TL", 2.35);
		exampleChart.put("GBP/TL", 3.0);
		exampleChart.put("EUR/GBP", 1.1);

		Charts chart = Mockito.mock(Charts.class);
		Mockito.when(Charts.getInstance().getCurrencyCharts()).thenReturn(
				exampleChart);

		assertEquals(2.35,
				new ChartsSearcher().searchCurrencyCharts("USD", "TL"), 0.0001);

		assertEquals(1 / 2.35,
				new ChartsSearcher().searchCurrencyCharts("TL", "USD"), 0.0001);

		assertEquals(1.1,
				new ChartsSearcher().searchCurrencyCharts("EUR", "GBP"), 0.0001);

	}

}

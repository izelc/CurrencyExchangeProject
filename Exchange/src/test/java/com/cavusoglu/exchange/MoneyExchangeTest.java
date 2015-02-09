package com.cavusoglu.exchange;

import static org.junit.Assert.*;
import org.junit.Test;

import com.cavusoglu.exchange.MoneyExchange;
import com.cavusoglu.exchange.NegativeAmountException;

public class MoneyExchangeTest {

	@Test
	public void testConcatParity() {
		assertEquals("EUR/USD", new MoneyExchange().concatParity("EUR", "USD"));
		assertEquals("GBP/USD", new MoneyExchange().concatParity("GBP", "USD"));
		assertEquals("/", new MoneyExchange().concatParity("", ""));
	}

	@Test
	public void testsearchCurrencyCharts() {
		assertEquals(2.35,
				new MoneyExchange().searchCurrencyCharts("USD", "TL"), 0.0001);
		
		assertEquals(1 / 2.35,
				new MoneyExchange().searchCurrencyCharts("TL", "USD"), 0.0001);

		assertEquals(1.0,
				new MoneyExchange().searchCurrencyCharts("EUR", "EUR"), 0.0001);
		
		assertTrue(0 < new MoneyExchange().searchCurrencyCharts("GBP", "USD"));
		
		assertNotEquals(-1,
				new MoneyExchange().searchCurrencyCharts("TL", "EUR"), 0.0001);
	}

	@Test
	public void testCalculate() throws NegativeAmountException {
		MoneyExchange m = new MoneyExchange();
		assertEquals(4.70, m.calculate("USD", "TL", 2), 0.01);
	}

}

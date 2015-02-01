package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	public void testSearchCoefficentMap() {
		assertEquals(2.35,
				new MoneyExchange().searchCoefficentMap("USD", "TL"), 0.0001);
		assertEquals(1 / 2.35,
				new MoneyExchange().searchCoefficentMap("TL", "USD"), 0.0001);

		assertEquals(1.0,
				new MoneyExchange().searchCoefficentMap("EUR", "EUR"), 0.0001);
		assertTrue(0 < new MoneyExchange().searchCoefficentMap("GBP", "USD"));
		assertNotEquals(-1,
				new MoneyExchange().searchCoefficentMap("TL", "EUR"), 0.0001);

	}

	@Test
	public void testCalculate() throws NegativeAmountException {
		MoneyExchange m = new MoneyExchange();
		assertEquals(4.70, m.calculate("USD", "TL", 2), 0.01);

	}

}

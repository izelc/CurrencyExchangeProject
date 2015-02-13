package com.cavusoglu.exchange;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfCurrenciesTest {

	@Test
	public void addCurrenciesTest() {
		SumOfCurrencies sc=new SumOfCurrencies();
		String sum=sc.addCurrencies("USD", "EUR", 1, 1, "TL");
		assertEquals("5,05 TL", sum);
	}

}

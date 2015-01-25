import static org.junit.Assert.*;

import org.junit.Test;


public class MoneyExchangeTest {

	@Test
	public void testConcatParity() {
		assertEquals("EUR/USD", new MoneyExchange().concatParity("EUR", "USD"));
		assertEquals("GBP/USD",new MoneyExchange().concatParity("GBP", "USD"));
		assertEquals("/",new MoneyExchange().concatParity("", ""));
		
		
	}
	
	@Test
	public void testSearchCoefficentMap()  {
		assertEquals( 2.35 ,new MoneyExchange().searchCoefficentMap("USD","TL"),0.0001);
		assertEquals( 1/2.35 ,new MoneyExchange().searchCoefficentMap("TL","USD"),0.0001);
		assertEquals( -1.0 ,new MoneyExchange().searchCoefficentMap("elma","balik"),0.0001);
		assertTrue(0<new MoneyExchange().searchCoefficentMap("GBP","USD"));
		assertNotEquals(-1, new MoneyExchange().searchCoefficentMap("TL","EUR"),0.0001 );
	
		}
	
	@Test
	public void testCalculate()  {
		assertEquals(2, 35);
		
	}

}

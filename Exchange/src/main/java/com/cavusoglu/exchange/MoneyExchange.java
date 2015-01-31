package com.cavusoglu.exchange;

import java.util.HashMap;



public class MoneyExchange {

	private HashMap<String, Double> coefficentMap = new HashMap<String, Double>();

	public MoneyExchange() {
		// TODO Auto-generated constructor stub

		coefficentMap.put("USD/GBP", 0.66);
		coefficentMap.put("EUR/GBP", 0.74);
		coefficentMap.put("TL/GBP", 0.28);
		coefficentMap.put("USD/EUR", 0.89);
		coefficentMap.put("USD/TL", 2.35);
		coefficentMap.put("TL/EUR", 0.37);
	}

	
	public String concatParity(String currency1, String currency2) { // iki para
																		// biriminin
																		// sembolunü
																		// birleþtirir.
	        String pair = currency1;
			pair = pair.concat("/").concat(currency2);
			return pair;
		

	}

	public double searchCoefficentMap(String currency1, String currency2) {
		// HashMapte iki para biriminin sembollerinin birleþtirilmiþ haliyle
		// oluþan indexe gider, oradaki deðeri geri döndürür.
		
		
			if(currency1.equals(currency2))
				return 1.0;

			if (coefficentMap.get(concatParity(currency1, currency2)) != null)
				return coefficentMap.get(concatParity(currency1, currency2));
			else 
			{
				if (coefficentMap.get(concatParity(currency2, currency1)) != null)
					return (1 / coefficentMap.get(concatParity(currency2, currency1)));
				else
				return -1.0;
			}
		
	}
	
 public double calculate(String currency1 ,String currency2,double amount ) throws NegativeAmountException{
	
	 if (amount<0)
	 throw new NegativeAmountException();
	     if(searchCoefficentMap(currency1, currency2)==-1.0)
	    	 return -1.0; 
   
	     return amount*searchCoefficentMap(currency1, currency2);
		 
	 }

}

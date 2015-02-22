package com.cavusoglu.exchange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ChartsTest {
	
	private Charts chart;

	@Before
	public void before() throws IOException {
		chart = Mockito.spy(new Charts());
		Document doc = Jsoup.parse(readFile("exampleGoogleFinanceTRYJPY.html"));
		Mockito.doReturn(doc).when(chart).getDocument("TRYJPY");
	}

	@Test
	public void testConnectToData() throws IOException {
		double data = chart.getParity(chart.getDocument("TRYJPY"),
				chart.findParticularCssPath(1));
		assertEquals(0.4072, data, 0.0000);
	}

	@Test
	public void verifyConvertCurrencyDataToDouble() throws Exception {
		String str = "$ 0.4072";
		chart.getParity(chart.getDocument("TRYJPY"),
				chart.findParticularCssPath(1));
		Mockito.verify(chart).convertCurrencyDataToDouble(str);

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

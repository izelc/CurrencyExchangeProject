package com.cavusoglu.exchange;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.Test;

public class JettyTest {
	@Test
	public void testName() throws Exception {
		SslContextFactory sslContextFactory = new SslContextFactory(true);
		HttpClient client = new HttpClient(sslContextFactory);

		client.start();
		
		String response = client.GET("https://www.google.com/finance?q=TRYJPY")
				.getContentAsString();
		
		client.stop();
	}
}

package org.elastest.demo_test;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.rnorth.visibleassertions.VisibleAssertions.assertTrue;

/**
 * Simple example of plain Selenium usage.
 */
public class DemoTest {

	@Test
	public void simplePlainSeleniumTest() {

		String appIP = System.getenv("APP_IP");
//		String appIP = "http://172.27.0.11:8080";
		System.out.println("SuT ip: " + appIP);

		boolean works = validUrl(appIP);
		System.out.println("assert");
		assertTrue("The SuT is started and works fine", works);
	}

	public static boolean validUrl(String URLName) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

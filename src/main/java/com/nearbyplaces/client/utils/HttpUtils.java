package com.nearbyplaces.client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpUtils {

	final private static String baseString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	final private static String apiKeyQueryParameter = "&key=AIzaSyDaWuwgt3UAmHzrrFHuwcNzuAB4palhx1Y";

	public static String getQueryParameter(String name, String value, String encoding)
			throws UnsupportedEncodingException {
		return "&" + name + "=" + URLEncoder.encode(value, encoding);
	}

	public static String getQueryParameter(String name, String value) throws UnsupportedEncodingException {
		return getQueryParameter(name, value, "UTF-8");
	}

	public static String getJSONResponse(String queryString) throws IOException {
		String response = null;
		BufferedReader in = null;
		URLConnection connection = null;
		try {
			URL url = new URL(baseString + queryString + apiKeyQueryParameter);

			connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String nextLine = in.readLine();
			StringBuilder stringBuilder = new StringBuilder(nextLine);
			while (nextLine != null) {
				nextLine = in.readLine();
				stringBuilder.append(nextLine);
			}
			response = stringBuilder.toString();
		} catch (IOException ioe) {
			if (in != null) {
				in.close();
			}
		}
		return response;
	}
}

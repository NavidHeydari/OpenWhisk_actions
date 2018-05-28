package edu.uw.tcss562.navid.openwhisk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ActionCaller {

	public static final String COMMA = ", ";

	public static JsonObject main(JsonObject args) {
		// public static void main(String[] args) {

		List<ActionCallerResult> actionCallingResults = new ArrayList<ActionCallerResult>();
		Gson jsonConvertor = new Gson();
		
		StringBuffer sb = new StringBuffer();

		StringBuilder url = new StringBuilder();
		int time2Execute = 1;
		int in_num = 0;
		// for testing
//		url.append(
//				"https://openwhisk.ng.bluemix.net/api/v1/web/navidh2%40uw.edu_dev/default/actionCpuStress.json?number=10");

		if (args.has("base-url")) {
			
			url.append(args.getAsJsonPrimitive("base-url").getAsString());
			in_num = args.getAsJsonPrimitive("in-num").getAsInt();
			time2Execute = args.getAsJsonPrimitive("time2Execute").getAsInt();

			url.append("?number=").append(in_num);

		}

		JsonObject destActionCallResponse = new JsonObject();

		String result = null;// as default if it didn't get the response.

		

		for (int index = 0; index < time2Execute; index++) {
			//init and cleanup
			result = "NA";
			sb.delete(0, sb.length());
			
			// 1. start timer
			long networkDelayStartTime = System.nanoTime();
			// 2. calling end point
			result = call(url.toString());

			// 3. get the result
			if (Objects.nonNull(result) && result.contains("result")) {
				result = result.split(":")[1].replaceAll("\"", "").replaceAll("}", "");
			}
			// 4. stop timer
			long networkDelayStopTime = System.nanoTime();
			long networkDelayInterval = networkDelayStopTime - networkDelayStartTime;

			// 5. formatting result 
			sb
			.append("Action called via action REST").append(COMMA)
				.append(result).append(COMMA)
				.append("Action called via client").append(COMMA)
				.append("FullDestActionURL:").append(COMMA)
				.append(url).append(COMMA)
				.append("Network Delay Start Time").append(COMMA)
				.append(networkDelayStartTime).append(COMMA)
				.append("Network Delay Stop Time").append(COMMA)
				.append(networkDelayStopTime).append(COMMA)
				.append("Network Delay Interval Time").append(COMMA)
				.append(networkDelayInterval).append(COMMA);

			// System.out.println(sb.toString());
			ActionCallerResult obj = new ActionCallerResult();
			obj.setResult(sb.toString());
			actionCallingResults.add(obj);
			
		}
 
		destActionCallResponse.addProperty("finalResults", jsonConvertor.toJson(actionCallingResults));
		return destActionCallResponse;
	}

	/**
	 * encapsulating the hassel of calling REST end point using URL and java.net
	 * package.
	 * 
	 * @param endpoin_url
	 * @return
	 */
	private static String call(final String endpoin_url) {

		StringBuilder contentFromActionCall = new StringBuilder();

		try {

			URL url = new URL(endpoin_url);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed to call: HTTP error code is: " + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			String line;

			while ((line = br.readLine()) != null) {
				contentFromActionCall.append(line);
			}

			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentFromActionCall.toString();

	}

}
package edu.uw.tcss562.navid.openwhisk;

import com.google.gson.JsonObject;

public class Action3 {

	public static final String COMMA = ", ";

	public static JsonObject main(JsonObject args) {
		// public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("input_number,start_time, stop_time, interval_nanoSec,").append(System.lineSeparator());

		int input_number = 0;

		if (args.has("number")){
			input_number = args.getAsJsonPrimitive("number").getAsInt();
		}else{
			input_number = 50;
		}
		// if (args.length > 0) input_number = Integer.parseInt(args[0]);

		JsonObject response = new JsonObject();

		// start timer
		long startTime = System.nanoTime();
		// do some work, keep CPU busy!
		fibonacci_recursion(input_number);

		// stop timer
		long stopTime = System.nanoTime();
		long interval = stopTime - startTime;

		sb.append(input_number)
		.append(COMMA).append(startTime)
		.append(COMMA).append(stopTime)
		.append(COMMA).append(interval).append(COMMA);

		// System.out.println(sb.toString());
		response.addProperty("result", sb.toString());

		return response;
	}

	/**
	 * static implementation of fib using recursion. NOTE that we are using this
	 * function to generate some load on the CPU and gather some statistical
	 * information on how CPUs can behave.
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacci_recursion(int n) {
		if (n <= 1)
			return n;

		return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);

	}

}
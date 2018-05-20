package edu.uw.tcss562.navid.openwhisk;

import com.google.gson.JsonObject;

public class Action3 {
    public static JsonObject main(JsonObject args) {
    	
    	long startTime = System.nanoTime();
    	
        String name = "stranger";
        if (args.has("name"))
            name = args.getAsJsonPrimitive("name").getAsString();
        JsonObject response = new JsonObject();
        response.addProperty("greeting", "Hello " + name + "!");
        
        long endTime = System.nanoTime();
        long interval = endTime - startTime;
        
        response.addProperty(" timeinterval:" ,interval);
        
        return response;
    }
}
package com.demo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class FunctionHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

	  @Override
	  public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
	    Map<String, Object> output = new HashMap<>();
	    output.put("foo", System.currentTimeMillis());
	    output.put("bar", LocalDateTime.now());
	    output.put("input", input);
	    output.put("context", context);
	    return output;
	  }

}

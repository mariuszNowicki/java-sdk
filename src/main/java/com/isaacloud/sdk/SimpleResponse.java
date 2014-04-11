package com.isaacloud.sdk;

import net.minidev.json.JSONObject;

public class SimpleResponse extends Response {

	private JSONObject body;
	
	public SimpleResponse(JSONObject _body) {
		body = _body;
	}
	
	@Override
	public boolean isArray() {
		return false;
	}

	@Override
	public boolean isObject() {
		return true;
	}

	@Override
	public Object getJson() {
		return body;
	}
	
	@Override 
	public String toString(){
		return body.toJSONString();
	}
	
}

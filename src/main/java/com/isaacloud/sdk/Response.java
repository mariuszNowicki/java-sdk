package com.isaacloud.sdk;

public abstract class Response {
	
	public abstract boolean isArray();
	public abstract boolean isObject();
	public abstract Object getJson();
}

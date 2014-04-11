package com.isaacloud.sdk;

import net.minidev.json.JSONArray;

public class ListResponse extends Response {
	
	private long total;
	private long limit;
	private long offset;
	private JSONArray body;
	
	public ListResponse(JSONArray _body,long _total, long _limit, long _offset) {
		body = _body;
		total = _total;
		limit = _limit;
		offset = _offset;
	}

	public long getTotal() {
		return total;
	}

	public long getLimit() {
		return limit;
	}

	public long getOffset() {
		return offset;
	}

	@Override
	public boolean isArray() {
		return true;
	}

	@Override
	public boolean isObject() {
		return false;
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

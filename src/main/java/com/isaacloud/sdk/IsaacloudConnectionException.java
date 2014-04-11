package com.isaacloud.sdk;

import net.minidev.json.JSONObject;

public class IsaacloudConnectionException extends Exception {
	private static final long serialVersionUID = 1L;
	protected JSONObject error;

	IsaacloudConnectionException() {
		error = null;
	}

	IsaacloudConnectionException(String _error) {
		error = new JSONObject();		
		error.put("message", _error);
	}

	IsaacloudConnectionException(JSONObject _error) {
		error = _error;
	}

	public String getMessage() {
		if (error != null)
			return error.get("message").toString();
		else
			return "";
	}

	public JSONObject getJSON() {
		return error;
	}
	
	public int getInternalCode(){
		if (error != null)
			return Integer.parseInt(error.get("code").toString());
		else
			return 0;
	}
	
	public JSONObject getData(){
		if (error != null && error.containsKey("data"))
			return (JSONObject) error.get("data");
		else
			return new JSONObject();
	}
}

class BadRequestException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	BadRequestException() {
		error = null;
	}

	BadRequestException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	BadRequestException(JSONObject _message) {
		error = _message;
	}
}

class UnauthorizedException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	UnauthorizedException() {
		error = null;
	}

	UnauthorizedException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	UnauthorizedException(JSONObject _message) {
		error = _message;
	}
}

class InternalServerException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	InternalServerException() {
		error = null;
	}

	InternalServerException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	InternalServerException(JSONObject _message) {
		error = _message;
	}
}

class PaymentRequiredException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	PaymentRequiredException() {
		error = null;
	}

	PaymentRequiredException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	PaymentRequiredException(JSONObject _message) {
		error = _message;
	}
}

class ForbiddenException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	ForbiddenException() {
		error = null;
	}

	ForbiddenException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	ForbiddenException(JSONObject _message) {
		error = _message;
	}
}

class NotFoundException extends IsaacloudConnectionException {

	private static final long serialVersionUID = 1L;

	NotFoundException() {
		error = null;
	}

	NotFoundException(String _message) {
		error = new JSONObject();
		error.put("message", _message);
	}

	NotFoundException(JSONObject _message) {
		error = _message;
	}
}
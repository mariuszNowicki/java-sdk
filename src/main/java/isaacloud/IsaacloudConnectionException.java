package isaacloud;

import net.minidev.json.JSONObject;

public class IsaacloudConnectionException extends Exception {
	private static final long serialVersionUID = 1L;
	protected JSONObject message;

	IsaacloudConnectionException() {
		message = null;
	}

	IsaacloudConnectionException(String _message) {
		message = new JSONObject();		
		message.put("message", _message);
	}

	IsaacloudConnectionException(JSONObject _message) {
		message = _message;
	}

	public String getMessage() {
		if (message != null)
			return message.toJSONString();
		else
			return "";
	}

	public JSONObject getJSONMessage() {
		return message;
	}
}

class BadRequestException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	BadRequestException() {
		message = null;
	}

	BadRequestException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	BadRequestException(JSONObject _message) {
		message = _message;
	}
}

class UnauthorizedException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	UnauthorizedException() {
		message = null;
	}

	UnauthorizedException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	UnauthorizedException(JSONObject _message) {
		message = _message;
	}
}

class InternalServerException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	InternalServerException() {
		message = null;
	}

	InternalServerException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	InternalServerException(JSONObject _message) {
		message = _message;
	}
}

class PaymentRequiredException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	PaymentRequiredException() {
		message = null;
	}

	PaymentRequiredException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	PaymentRequiredException(JSONObject _message) {
		message = _message;
	}
}

class ForbiddenException extends IsaacloudConnectionException {
	private static final long serialVersionUID = 1L;

	ForbiddenException() {
		message = null;
	}

	ForbiddenException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	ForbiddenException(JSONObject _message) {
		message = _message;
	}
}

class NotFoundException extends IsaacloudConnectionException {

	private static final long serialVersionUID = 1L;

	NotFoundException() {
		message = null;
	}

	NotFoundException(String _message) {
		message = new JSONObject();
		message.put("message", _message);
	}

	NotFoundException(JSONObject _message) {
		message = _message;
	}
}
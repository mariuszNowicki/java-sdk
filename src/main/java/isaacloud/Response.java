package isaacloud;


public abstract class Response {
	
	public abstract boolean isArray();
	public abstract boolean isObject();
	public abstract Object getJson();
}

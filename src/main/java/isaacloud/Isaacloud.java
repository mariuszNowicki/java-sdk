package isaacloud;

import java.util.Map;

public class Isaacloud extends Connector {

	private static String baseUrl = "https://api.isaacloud.com";
	private static String baseOauth = "https://oauth.isaacloud.com";
	private static String version = "v1";
	
	public Isaacloud( Map<String,String> config) {
		super(baseUrl,baseOauth,version,config);		
	}
}

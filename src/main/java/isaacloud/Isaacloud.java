package isaacloud;

import java.util.HashMap;
import java.util.Map;

public class Isaacloud extends Connector {
	
	
	/**
	 * Constructor for default isaacloud.
	 * @param config - map that contains clientID:clientSecret
	 */
	public Isaacloud( Map<String,String> config) {		
		super("https://api.isaacloud.com","https://oauth.isaacloud.com","v1",config);		
				
	}
	
	/**
	 * Call to api methods.
	 * @param uri
	 * @param method
	 * @param parameters
	 * @param body
	 * @return api json response
	 */
	public String api(String uri,String method,HashMap<String,Object> parameters, String body){
		return this.callService(uri, method, parameters, body);
	}
	
	/**
     * Get base api url
     * @return url to api
     */
    public String getApiUrl() {
        return this.baseUrl;
    }
    
    /**
     * Get base oauth url
     * @return oauth url
     */
    public String getOauthUrl() {
        return Isaacloud.oauthUrl;
    }
    
    /**
     * Get base version
     * @return api version
     */
    public String getVersion() {
        return this.version;
    }
    
    /**
     * Get token
     * @return type
     */
    public String getToken(){
       return Isaacloud.getAuthentication(); 
    }
    
}

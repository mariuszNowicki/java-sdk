package isaacloud;

import java.io.IOException;
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
	 * @throws IOException 
	 */
	public Response api(String uri,String method,Map<String,Object> parameters, String body) throws IOException{
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
        return oauthUrl;
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
     * @throws IOException 
     */
    public String getToken() throws IOException{
       return getAuthentication(); 
    }
    
}

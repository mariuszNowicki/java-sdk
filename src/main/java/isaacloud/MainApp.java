package isaacloud;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Map<String,String> config = new HashMap<String,String>();
		
		config.put("secret", "19e940ac4fa3b165faef16cbd06b1cc6");
		config.put("clientId", "13");
		
		Map<String,Object > params = new HashMap<String,Object>();
		params.put("id", 1);
		params.put("fields", "updateAt,email");
		
		Isaacloud isaacloudSdk = new Isaacloud(config);
		String result = isaacloudSdk.callService("/cache/users", "get",new HashMap<String,Object>(), null);
		System.out.println(result);
	}

}

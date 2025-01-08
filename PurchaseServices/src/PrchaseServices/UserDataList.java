package PrchaseServices;

import java.util.HashMap;
import java.util.Map;

public class UserDataList {
	
	
	
	 private Map<String, User> userData = new HashMap<>();
		
		public void setUserData(String x,User user)
		{
			userData.put(x,user);
		}
		public Map<String, User> getMap()
		{
			return userData;
		}

}

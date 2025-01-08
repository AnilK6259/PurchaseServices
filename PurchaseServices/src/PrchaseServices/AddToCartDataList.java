package PrchaseServices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddToCartDataList {
	
	
	
	private Map<String,Map<Integer,AddToCartServicesProperties>> addToCart=new HashMap<>();
	//private Map<Integer,AddToCartServicesProperties> addToCartInnermap=new HashMap<>();
	
	public Map<String,Map<Integer,AddToCartServicesProperties>> getAddToCartDataList()

	{
		return this.addToCart;
	}
	
	
	
	/*public void setAddToCartInnerMap(int orderId,AddToCartServicesProperties acsp)
	{
		addToCartInnermap.put(orderId, acsp);
	}
	*/
	@SuppressWarnings("unchecked")
	public void setAddToCartDataList(String userName,int orderId,AddToCartServicesProperties acsp)
	{
		Map<Integer,AddToCartServicesProperties> addToCartInnermap=addToCart.computeIfAbsent(userName, k->new HashMap());
		
		addToCartInnermap.put(orderId, acsp);
		//setAddToCartInnerMap( orderId,acsp);
		
		//addToCart.put(userName, addToCartInnermap) addToCartInnermap.put(orderId, addToCartDataList));
		addToCart.put(userName, addToCartInnermap);
	}
	
	
}

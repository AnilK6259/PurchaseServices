package PrchaseServices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdersList {
	
	private Map<String,Map<Integer,OrdersProperties>> OrdersListData=new HashMap<>();
	
	private Set<Integer> orderCount=new HashSet<>();
	
	//private Map<Integer,OrdersProperties> OrderListInnerMap=new HashMap<>();
	
	/*public Map<Integer,OrdersProperties> getOrderListInnerMap()
	{
		return OrderListInnerMap;
	}*/
	
	public void setOrderlist(String usertName,int orderId,OrdersProperties NewOrder)
	{
		//OrderListInnerMap.put(orderId, NewOrder);
		
		/*Map<Integer,OrdersProperties> OrderListInnerMap=OrdersListData.get(usertName);
		
		if(OrderListInnerMap==null)
		{
			OrderListInnerMap=new HashMap<>();
			
			OrderListInnerMap.put(orderId,NewOrder);
			
			OrdersListData.put(usertName, OrderListInnerMap);
		}
		
		else
		{
			OrderListInnerMap.put(orderId,NewOrder);
		}
		//OrdersListData.put(usertName, OrderListInnerMap);*/
		
		   Map<Integer, OrdersProperties> OrderListInnerMap = OrdersListData.computeIfAbsent(usertName, k -> new HashMap<>());
	
		    OrderListInnerMap.put(orderId, NewOrder);
	}
	
	public Map<String,Map<Integer,OrdersProperties>> getOrderDataList()
	{
		return this.OrdersListData;
	}
	
	public void setOrderCount(int count)
	{
		orderCount.add(count);
	}

	public Set<Integer> getOrderCount() {
		return orderCount;
	}
	

}


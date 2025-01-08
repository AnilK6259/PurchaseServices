package PrchaseServices;

import java.util.Map;
//import java.util.Map.Entry;

public class Orders {
	
	private AccountServices accountServices;
	//private Scanner sc;
	
	public Orders(AccountServices accountServices)
	{
		this.accountServices=accountServices;
		//this.sc=sc;
	}
	
	public void displayOrders()
	{
		//int i=accountServices.getProductServices().getOrderList().getOrderList().size();
		
		if(!accountServices.getProductServices().getOrderList().getOrderDataList().containsKey(accountServices.getSignIn().getUserName()))
		
		{
			System.out.println("No Orders were Placed");
			accountServices.accountServicesHomePage();
		}
		
		else
		{
			
			System.out.println("Your Orders");
			
			String userName=accountServices.getSignIn().getUserName();
			
			for(Map.Entry<Integer, OrdersProperties> entry : accountServices.getProductServices().getOrderList().getOrderDataList().get(userName).entrySet())
			{
				//if(userName.equalsIgnoreCase(entry.getValue().username))
				//{
					System.out.println(entry.getValue()); 
				//}
			   
			}
			

			accountServices.accountServicesHomePage();
		}
	}

}


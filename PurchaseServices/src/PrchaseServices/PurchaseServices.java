package PrchaseServices;

import java.util.Scanner;

public class PurchaseServices {
	
	private Scanner sc;
	private SignUp signup;
	private ProductServices productServices;
	private double puchasePrcie;
	private String  userName;
	private WriteOrders wrOrders;
	
	public void setOrdersFile(WriteOrders wrOrders)
	{
		this.wrOrders=wrOrders;
	}
	
	
	public PurchaseServices(Scanner sc,SignUp signup,ProductServices productServices)
	{
		this.sc=sc;
		this.signup=signup;
		this.productServices=productServices;
	}
	
	public void buyProduct(String x,double y,double z,String productName,String UserName)
	{
		puchasePrcie=z;
		userName=UserName;
		
		String tempBankName=signup.readInput(sc, "Please enter your bank name like SBI,HDFC...");
		String tempWishTOContinue;
		
		if(tempBankName.equalsIgnoreCase(x))
		{
			
			
			tempWishTOContinue=signup.readInput(sc, "Your Discount method matched with current Bank service so your final price is : \n"+
					puchasePrcie+"\n" +
					" Do you wish to 'continue' or give new new account details then type 'New'");
			
		}
		
		else
		{
			puchasePrcie=productServices.getPriceDeriveData().finalPriceOfProduct(tempBankName, y);
			tempWishTOContinue=signup.readInput(sc, "Your Discount method not matched with current Bank service so your final price is : \n"+
					puchasePrcie+" Do you wish to continue or give new new account details then type 'New'");
		}
		
		if(tempWishTOContinue.equalsIgnoreCase("continue"))
		{
		;
		}
		else
		{
			buyProduct(x,y,z,productName,UserName);
		}
		
		String tempCardNumber=signup.readInput(sc,"please provide your card number");
		
		System.out.println("Your final price is:\n" +
                "purchasePrice: " + puchasePrcie + "\n" +
                "DeliveryCharges: " + productServices.getPriceDeriveData().deliveryCharges + "\n" +
                "GST: " + productServices.getPriceDeriveData().getGSTRate(tempBankName, y));
		
		String cancleOrSubmit=signup.readInput(sc,"Type 'Cancel' or 'Submit' ");
		cancelOrSubmit(cancleOrSubmit,tempCardNumber,puchasePrcie,productName);
		

	}
	
	public void cancelOrSubmit(String x,String CardNumber,double puchasePrcie,String productName)
	{
		
		
		if(x.equalsIgnoreCase("cancel"))
		{
			System.out.println("Your payment was cancelled");
			
			productServices.productServices();
		}
		
		else if(x.equalsIgnoreCase("submit"))
		{
			int orderID=getOrderId(userName);
			
			String transactionNumber=orderID+""+CardNumber;
			
			System.out.println("Your payment was success, your order will be delivered soon..");
			
			OrdersProperties NewOrder=new OrdersProperties();
			//productServices.getOrderList().setOrderList(orderID, productName, puchasePrcie, CardNumber, transactionNumber,userName);
			
			//productServices.getOrderList().setOrderListArray(productServices.getOrderList());
			NewOrder.setOrdersProperties(orderID, productName, puchasePrcie, CardNumber, transactionNumber, userName);
			
			productServices.getOrderList().setOrderlist(userName, orderID, NewOrder);
			
			wrOrders.writeOrderFile(NewOrder);
			
			productServices.getAccountServices().accountServicesHomePage();
			
		}
		
		else
		{
			System.out.println("please write valid details");
			
			String cancleOrSubmit=signup.readInput(sc,"Type 'Cancel' or 'Submit' ");
			
			cancelOrSubmit(cancleOrSubmit,CardNumber,puchasePrcie,productName);
		}
	}
	
	public int getOrderId(String userName)
	{
		//int orderId=productServices.getOrderList().getOrderDataList().get(userName).keySet().size()+1;
		int orderId=productServices.getOrderList().getOrderCount().size()+1;
		return orderId;
	}

}


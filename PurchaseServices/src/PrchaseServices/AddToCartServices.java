package PrchaseServices;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

public class AddToCartServices {
	
	private Scanner sc;
	private AccountServices accountServices;
	private AddToCartDataList addToCardDataList;
	
	public AddToCartDataList getAddToCartDataList()
	{
	return	this.addToCardDataList;
	}
	
	public AddToCartServices(Scanner sc,AccountServices accountServices,AddToCartDataList addToCardDataList)
	{
		this.sc=sc;
		this.accountServices=accountServices;
		this.addToCardDataList=addToCardDataList;
	}
	
	public void addToCartServicesSetData(String UserName,String productName,double productPrice)
	{
		int orderId;
		if(addToCardDataList.getAddToCartDataList().containsKey(UserName))
		{
		orderId=addToCardDataList.getAddToCartDataList().get(UserName).size()+1;
		}
		
		else
		{
			orderId=1;
		}
		
		AddToCartServicesProperties acsp=new AddToCartServicesProperties();
		
		acsp.setAddToCartDataListValues(productName, productPrice, orderId, UserName);
		
		addToCardDataList.setAddToCartDataList(UserName, orderId, acsp);
		
		WriteCartFile wcf=new WriteCartFile();
		
		wcf.wirteCartFile(acsp);
		
		accountServices.accountServicesHomePage();
	}
	
	public void addToCartServicesDetails(String UserName)
	{
		//addToCartServicesSetData(UserName,productName,productPrice);
		
		if(addToCardDataList.getAddToCartDataList().containsKey(UserName))
		{
			for(Entry<Integer, AddToCartServicesProperties> entry :addToCardDataList.getAddToCartDataList().get(UserName).entrySet())
			{
				
				System.out.println("Serial No : "+entry.getKey()+" ;ProductName : "+entry.getValue().getProductName()+" ;price : "+entry.getValue().getProductPrice());
			}
			
			String tempInput=accountServices.getHome().getSignUp().readInput(sc,"Want to remove cart 'Y' or back");
			
			removeOrBack(tempInput,UserName);
		}
		
		else
		{
			System.out.println("No Products were added to Cart");
			accountServices.accountServicesHomePage();
		}
		
		
	}
	
	public void removeOrBack(String action,String UserName)
	{
		String tempInput=action;
		if(tempInput.equalsIgnoreCase("y"))
		{
			String removeAllOrOne=accountServices.getHome().getSignUp().readInput(sc,"Want to remove 'All' or 'one'");
			
			if(removeAllOrOne.equalsIgnoreCase("all"))
			{
				
				String filePath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\AddToCart\\";
				
				String fileName=null;
				
				File files=new File(filePath);
				
				File filesPaths[]=files.listFiles();
				
				for(File removeFiles:filesPaths)
				{
				
					Object[] orderIdKeySet=addToCardDataList.getAddToCartDataList().get(UserName).keySet().toArray();
				
				for(Object id:orderIdKeySet)
				{
					fileName=UserName+id+".txt";
					
					if(removeFiles.getName().equalsIgnoreCase(fileName))
						{
						if(removeFiles.exists())
						{
							if(removeFiles.canWrite())
							{
								System.out.println(removeFiles.delete());
							}
							
							
						}
						
						//files.deleteOnExit(removeFiles);
						//removeFiles.deleteOnExit();
						};
				}
				}
				
				addToCardDataList.getAddToCartDataList().remove(UserName);
				
				System.out.println("Cart Cleared");
				
				accountServices.accountServicesHomePage();
			}
			
			else if(removeAllOrOne.equalsIgnoreCase("one"))
			{
			int cartOrder=Integer.parseInt(accountServices.getHome().getSignUp().readInput(sc,"Type SerialNumber"));
			
			if(addToCardDataList.getAddToCartDataList().get(UserName).containsKey(cartOrder))
			{
                String filePath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\AddToCart\\";
				
				String fileName=UserName+cartOrder+".txt";
				
				File files=new File(filePath);
				
				File filesPaths[]=files.listFiles();
				
				for(File removeFiles:filesPaths)
				{
				
					if(removeFiles.getName().equalsIgnoreCase(fileName))
					{
						if(removeFiles.exists())
						{
							if(removeFiles.canWrite())
							{
								System.out.println(removeFiles.delete());
							}
							
							
						}
					};
						
				
				}
				
				
				addToCardDataList.getAddToCartDataList().get(UserName).remove(cartOrder);
				
				System.out.println("Item removed from Cart");
				
				accountServices.accountServicesHomePage();
				
			}
			}
			
			else
			{
				System.out.println("Given data is invalid please try again");
				
				removeOrBack(tempInput,UserName);
		}
			
		}
		
		else if(tempInput.equalsIgnoreCase("back"))
		{
			accountServices.accountServicesHomePage();
		}
		
		else
		{
			System.out.println("Please provide valid details");
			tempInput=accountServices.getHome().getSignUp().readInput(sc,"Want to remove cart 'Y' or back");
			removeOrBack(tempInput,UserName);
		
		}
	}

}


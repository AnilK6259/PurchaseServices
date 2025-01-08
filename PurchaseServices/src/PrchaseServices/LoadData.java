package PrchaseServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadData {
	
	private User user;
	private UserDataList usd;
	private String dataPath;
	private Products products;
	private ProductDataList productDataList;
	private AddToCartDataList addToCartDataList;
	private OrdersList ordersList;
	
	public LoadData(User user ,UserDataList usd,Products products,ProductDataList productDataList,AddToCartDataList addToCartDataList,OrdersList ordersList)
	{
		this.user=user;
		this.usd=usd;
		this.products=products;
		this.productDataList=productDataList;
		this.addToCartDataList=addToCartDataList;
		this.ordersList=ordersList;
	}
	
	public void readUsersData(String pathType)
	{
		switch(pathType)
		{
		case "users": dataPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Users\\";
		break;
		
		case "products":dataPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Products\\";
		break;
		
		case "addtocart":dataPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\AddToCart\\";
		break;
		
		case "orders":dataPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Orders\\";
		break;
		
		}
		
		
		
		File f=new File(dataPath);
		
		
		File[] files=f.listFiles();
		
		 if (files == null || files.length == 0)
		 {
	            System.out.println("No files found in the directory.");
	            return;
	        }
		 
		 else
		 {
		
		for(File file:files)
			{
			
			switch(pathType)
			{
			case "users": readDataFromUserFile(file.getPath());
			break;
			
			case "products":readDataFromProductsFile(file.getPath());
			break;
			
			case "addtocart":readDataFromAddToCartFile(file.getPath());
			break;
			
			case "orders":readDataFromOrdersFile(file.getPath());
			break;
			
			}
			}
		 }
		 
	}
	
	public void readDataFromUserFile(String x) 
	{
		try
		{
		FileReader fr=new FileReader(x);
		
		try (BufferedReader br = new BufferedReader(fr)) {
			boolean loopBreak=true;
			
			User NewUser=new User();
			
			while(loopBreak)
			{
				String lineValue=br.readLine();
				
				
				if(lineValue!=null)
				{
				String lineArray[]=lineValue.split(": ");
				
				switch(lineArray[0])
				{
				
				case "userName":NewUser.setUserName(lineArray[1]);break
				;
				
				case "title":NewUser.settitle(lineArray[1]);break
				;
				
				case "firstName": NewUser.setfirstName(lineArray[1]);break
				;
				
				case "lastName": NewUser.setlastName(lineArray[1]);break
				;
				case "mailId": NewUser.setmailId(lineArray[1]);break
				;
				
				case "password":NewUser.setpassword(lineArray[1]);break
				;
				
				default:loopBreak=false;
					
					break;
				}
				
				//User NewUser=user;
				
				if(NewUser.getUserName()!=null&&NewUser.getfirstName()!=null&&NewUser.getlastName()!=null&&NewUser.getmailId()!=null&&NewUser.getpassword()!=null&&NewUser.gettitle()!=null)
				//if(NewUser!=null)
				{
					if(usd.getMap().get(NewUser.getUserName())==null)
					{
					usd.setUserData(NewUser.getUserName(), NewUser);
					
					System.out.println(usd.getMap().get(NewUser.getUserName()));
					System.out.println("user added to map");
					
					//System.out.println(user);
					}
					
					loopBreak=false;
					//NewUser.resetUser();   
				}
				}
			}
		}
		fr.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void readDataFromProductsFile(String x) 
	{
		try
		{
		FileReader fr=new FileReader(x);
		
		try (BufferedReader br = new BufferedReader(fr)) {
			boolean loopBreak=true;
			
			Products NewProducts=new Products() ;
			
			while(loopBreak)
			{
				String lineValue=br.readLine();
				
				if(lineValue!=null)
				{
				String lineArray[]=lineValue.split(": ");
				
				switch(lineArray[0])
				{
				
				case "productKey":NewProducts.setProductKey(lineArray[1]);
				break
				;
				
				case "productName":NewProducts.setProductName(lineArray[1]);
				
				break
				;
				
				case "description": NewProducts.setdescription(lineArray[1]);
				
				break
				;
				
				case "productPrice": NewProducts.setProductPrice(Double.parseDouble(lineArray[1]));
				break
				;
				case "productRating": NewProducts.setproductRating(lineArray[1]);;break
				;
				
				case "productReviews":NewProducts.setproductReviews(lineArray[1]);
				break
				;
				
				default:loopBreak=false;
					
					break;
				}
				
				if(NewProducts.getProductKey()!=null&&NewProducts.getdescription()!=null&&NewProducts.getProductName()!=null&&NewProducts.getProductPrice()!=0&&NewProducts.getproductRating()!=null&&NewProducts.getproductReviews()!=null)
				{
					if(productDataList.getProductDataList().containsKey(NewProducts.getProductKey()))
					{
						if(!productDataList.getProductDataList().get(NewProducts.getProductKey()).containsKey(NewProducts.getProductName()))
						{
							productDataList.setProductsDataList(NewProducts.getProductKey(), NewProducts.getProductName(), NewProducts);
						System.out.println("Products added");
						System.out.println(productDataList.getProductDataList().get(NewProducts.getProductKey()).get(NewProducts.getProductName()));
						}
					
					}
					
					else
					{
						productDataList.setProductsDataList(NewProducts.getProductKey(), NewProducts.getProductName(), NewProducts);
						System.out.println("Products added");
						System.out.println(productDataList.getProductDataList().get(NewProducts.getProductKey()).get(NewProducts.getProductName()));
					}
					
					loopBreak=false;
					//products.resetProducts();
				}
				}
			}
		}
		
		fr.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void readDataFromAddToCartFile(String x) 
	{
		try
		{
		FileReader fr=new FileReader(x);
		
		
		try (BufferedReader br = new BufferedReader(fr)) {
			boolean loopBreak=true;
			
			//AddToCartDataList NewCart=new AddToCartDataList();
			
			AddToCartServicesProperties newacsp=new AddToCartServicesProperties();
			
			while(loopBreak)
			{
				String lineValue=br.readLine();
				
				if(lineValue!=null)
				{
				String lineArray[]=lineValue.split(": ");
				
				switch(lineArray[0])
				{
				
				case "orderId":newacsp.setOredrID(Integer.parseInt(lineArray[1]));
				
				break
				;
				
				case "username":newacsp.setUserName(lineArray[1]);
				
				break
				;
				
				case "productName": newacsp.setproductName(lineArray[1]);
				
				break
				;
				
				case "productPrice": newacsp.setproductPrice(Double.parseDouble(lineArray[1]));
				break
				;
				
				default:loopBreak=false;
					
					break;
				}
				
				if(newacsp.getorderId()!=0&&newacsp.getProductName()!=null&&newacsp.getuserName()!=null&&newacsp.getProductPrice()!=0.0)
				{
					if(addToCartDataList.getAddToCartDataList().containsKey(newacsp.getuserName()))
					{
						if(!addToCartDataList.getAddToCartDataList().get(newacsp.getuserName()).containsKey(newacsp.getorderId()))
						{
							addToCartDataList.setAddToCartDataList(newacsp.getuserName(), newacsp.getorderId(), newacsp);
						System.out.println("AddToCardDetails added");
						}
					
					}
					
					else
					{
						addToCartDataList.setAddToCartDataList(newacsp.getuserName(), newacsp.getorderId(), newacsp);
						System.out.println("AddToCardDetails added");
						//System.out.println(productDataList.getProductDataList().get(products.getProductKey()).get(products.getProductName()));
						System.out.println(addToCartDataList.getAddToCartDataList().get(newacsp.getuserName()));
						
					}
					
					loopBreak=false;
					//addToCartDataList.resetCart();
				}
				}
			}
		}
		
		fr.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void readDataFromOrdersFile(String x) 
	{
		try
		{
		FileReader fr=new FileReader(x);
		
		
		try (BufferedReader br = new BufferedReader(fr)) {
			boolean loopBreak=true;
			int tempOrderId=0;
			String tempUserName=null;
			String temporderedProductName=null;
			String tempbankAccountNumber=null;
			double temporderedPeroductPrice=0;
			String temporderTransactionNumber=null;
			
			//OrdersList NewOrders=new OrdersList();
			
			OrdersProperties LoadOrders=new OrdersProperties();
			
			while(loopBreak)
			{
				String lineValue=br.readLine();
				
				if(lineValue!=null)
				{
				String lineArray[]=lineValue.split(": ");
				
				switch(lineArray[0])
				{
				
				case "orderID": tempOrderId=Integer.parseInt(lineArray[1]);
				
				break
				;
				
				case "username":tempUserName= lineArray[1];
				
				break
				;
				
				case "orderedProductName": temporderedProductName= lineArray[1];
				
				break
				;
				
				case "orderedPeroductPrice": temporderedPeroductPrice= Double.parseDouble(lineArray[1]);
				break
				;
				
			    case "bankAccountNumber": tempbankAccountNumber= lineArray[1];
				
				break
				;
				
			    case "orderTransactionNumber": temporderTransactionNumber= lineArray[1];
				
				break
				;
				
				default:loopBreak=false;
					
					break;
				}
				
				if(tempbankAccountNumber!=null&&tempOrderId!=0&&temporderedPeroductPrice!=0&&temporderedProductName!=null&&temporderTransactionNumber!=null&&tempUserName!=null)
				{
					//ordersList.setOrderList(tempOrderId, temporderedProductName, temporderedPeroductPrice, tempbankAccountNumber, temporderTransactionNumber, tempUserName);
					
					LoadOrders.setOrdersProperties(tempOrderId, temporderedProductName, temporderedPeroductPrice, tempbankAccountNumber, temporderTransactionNumber, tempUserName);
					
					if(ordersList.getOrderDataList().containsKey(LoadOrders.username))
					{
						if(!ordersList.getOrderDataList().get(LoadOrders.username).containsKey(LoadOrders.orderID))
						{
							ordersList.setOrderlist(LoadOrders.username, LoadOrders.orderID, LoadOrders);
						System.out.println("Orders added");
						
						//System.out.println(ordersList.getOrderListInnerMap().keySet().size());
						
						if(LoadOrders!=null)
						{
							if(ordersList.getOrderDataList()!=null)
							{
								if(ordersList.getOrderDataList().containsKey(tempUserName))
								{
									if(ordersList.getOrderDataList().get(tempUserName).containsKey(tempOrderId))
									{
										System.out.println(ordersList.getOrderDataList().get(tempUserName).get(tempOrderId));
									}
								}
							}
						}
						}
					
					}
					
					else
					{
						ordersList.setOrderlist(LoadOrders.username,LoadOrders.orderID, LoadOrders);
						System.out.println("Orders added");
						//System.out.println(ordersList.getOrderListInnerMap().keySet().size());
						
						//System.out.println(productDataList.getProductDataList().get(products.getProductKey()).get(products.getProductName()));
					if(LoadOrders!=null)
					{
						if(ordersList.getOrderDataList()!=null)
						{
							if(ordersList.getOrderDataList().containsKey(tempUserName))
							{
								if(ordersList.getOrderDataList().get(tempUserName).containsKey(tempOrderId))
								{
									System.out.println(ordersList.getOrderDataList().get(tempUserName).get(tempOrderId));
								}
							}
						}
					}
					
					}
					
					loopBreak=false;
					//ordersList.resetOrders();
				}
				}
			}
		}
		
		fr.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}

package PrchaseServices;

import java.util.Map;
import java.util.Scanner;


public class ProductServices {
	
	//private Products products;
	private ProductDataList productDataList;
	private Scanner sc;
	private double finalPrice;
	private SignUp signup;
	private PriceDeriveData pricederivedata;
	private OrdersList orderList;
	private PurchaseServices purchaseServices;
	private AccountServices accountservices;
	
	public ProductServices(ProductDataList productDataList,Scanner sc,SignUp signup,AccountServices accountservices)
	{
		//this.products=products;
		
		this.productDataList=productDataList;
		
		this.sc=sc;
		
		this.signup=signup;
		
		this.accountservices=accountservices;
	}
	
	public AccountServices getAccountServices()
	{
		return this.accountservices;
	}
	
	public void setPurchaseServices(PurchaseServices purchaseServices)
	{
		this.purchaseServices=purchaseServices;
	}
	
	public void setOrderlist(OrdersList orderlist)
	{
		this.orderList=orderlist;
	}
	
	public OrdersList getOrderList()
	{
		return orderList;
	}
	
	public void setPriceDeriveData(PriceDeriveData pricederivedata)
	{
		this.pricederivedata=pricederivedata;
	}
	public PriceDeriveData getPriceDeriveData()
	{
		return pricederivedata;
	}
	
	public void productServices()
	{
		System.out.println("What are you looking for 'Laptops', 'Mobiles','TV' ");
		
		String tempInput=signup.readInput(sc, "Please choose one iteme over there or type 'back'");
		
		displayPrpducts(tempInput);
		
		String tempInput1=signup.readInput(sc, "Please choose one item over there or type 'back'");
		
		if(productDataList.getProductDataList().get(tempInput).containsKey(tempInput1))
		{
		System.out.println(productDataList.getProductDataList().get(tempInput).get(tempInput1));
		}
		
		else
		{
			//System.out.println("please enter valid details");
			productServices();
		}
		//"+productDataList.getProductDataList().get(tempInput).get(tempInput1).getProductPrice());
		System.out.println("You will get Discount based on this 'FirstOrder', CreditCards-(HDFC,SBI,AXIS,ICICI");
		
		System.out.println("Type 'NewUser' If this is your firstOrder");
		
		System.out.println("Type 'Other' for default dicount");
		
		String inputDiscountMethod=signup.readInput(sc,"Please enter you discount way");
		
		finalPrice=pricederivedata.finalPriceOfProduct(inputDiscountMethod,productDataList.getProductDataList().get(tempInput).get(tempInput1).getProductPrice()) ;
		
		System.out.println("Your Final price will be :"+finalPrice);
		
		String tempInput3=signup.readInput(sc, "Do you wish to Buy or AddToCart or type 'back'");
		
		if(tempInput3.equalsIgnoreCase("buy"))
		{
			purchaseServices.buyProduct(inputDiscountMethod, productDataList.getProductDataList().get(tempInput).get(tempInput1).getProductPrice(), finalPrice,tempInput1,accountservices.getSignIn().getUserName());
		}
		
		else if (tempInput3.equalsIgnoreCase("addtocart"))
		{
			accountservices.getAddToCartServices().addToCartServicesSetData(accountservices.getSignIn().getUserName(), tempInput1, finalPrice);
		}
		
		else
		{
			System.out.println("please enter valid details");
			productServices();
		}
		
	}
	
	public void displayPrpducts(String x)
	{
		if ( productDataList.getProductDataList().containsKey(x)) {
			
			Map<String,Products> iteratorProducts=productDataList.getProductDataList().get(x);
	       
	        for (Map.Entry<String, Products> entry :iteratorProducts.entrySet() ) 
	        {
	            //if(x.equals(entry.getValue().getProductKey()))
	           // {
	            System.out.println(entry.getValue()); 
	            //}
	            
	        }
	    } else {
	        
	        System.out.println("No products found for the category: " + x);
	        productServices();
	    }
	}
	


}

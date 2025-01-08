package PrchaseServices;

public class AddToCartServicesProperties {

	private int orderId;
	@SuppressWarnings("unused")
	private String userName;
	private String productName;
	private double productPrice;
	
	public void setAddToCartDataListValues(String productName,double productPrice,int orderId,String userName )
	{
		this.orderId=orderId;
		this.userName=userName;
		this.productName=productName;
		this.productPrice=productPrice;
	}
	
	public String getProductName()
	{
		return this.productName;
	}
	
	public double getProductPrice()
	{
		return this.productPrice;
	}
	
	public String getuserName()
	{
		return this.userName;
	}
	
	public int getorderId()
	{
		return this.orderId;
	}
	
	public void setOredrID(int orderID)
	{
		this.orderId=orderID;
	}
	
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	
	public void setproductName(String productName)
	{
		this.productName=productName;
	}
	
	public void setproductPrice(double productPrice)
	{
		this.productPrice=productPrice;
	}
	
	   public String toString() {
	        return "AddToCartDataList{" +
	   "orderId='" + orderId + '\'' +
	                "productName='" + productName + '\'' +
	                ", productPrice='" + productPrice + '\''  +
	                '}';
	    }
	   
	   public void resetCart()
	   {
		 this.orderId=0;
			this.userName=null;
			this.productName=null;
			this.productPrice=0;
	   }
	
}

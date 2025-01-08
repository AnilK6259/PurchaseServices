package PrchaseServices;

public class Products {
	
	private String productName;
	private String description;
	private double productPrice;
	private String productRating;
	private String productReviews;
	private String productKey;
	
	public void setProducts(String a,String b,double c,String d,String e)
	{
		this.productName=a;
		this.description=b;
		this.productPrice=c;
		this.productRating=d;
		this.productReviews=e;
	}
	
	public void setProductKey(String x)
	{
		this.productKey=x;
	}
	
	public void setProductName(String x)
	{
		this.productName=x;
	}
	
	public void setdescription(String description)
	{
		this.description=description;
	}
	
	public void setproductRating(String productRating)
	{
		this.productRating=productRating;
	}
	
	public void setproductReviews(String productReviews)
	{
		this.productReviews=productReviews;
	}
	
	public void setProductPrice(double ProductPrice)
	{
		this.productPrice=ProductPrice;
	}
	
	public double getProductPrice()
	{
		return this.productPrice;
	}
	
	public String getProductKey()
	{
		return this.productKey;
	}
	
	public String toString() {
        return "Products{" +
        		"productKey='" + productKey + '\'' +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productRating='" + productRating + '\'' +
                ", productReviews='" + productReviews + '\'' +
                '}';
    }
	
	public String getProductName()
	{
		return this.productName;
	}
	
	public String getdescription()
	{
		return this.description;
	}
	
	public String getproductRating()
	{
		return this.productRating;
	}
	
	public String getproductReviews()
	{
		return this.productReviews;
	}
	
	public void resetProducts()
	{
		 productName=null;
		description=null;
	productPrice=0;
		 productRating=null;
		productReviews=null;
		productKey=null;
	}

}


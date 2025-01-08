package PrchaseServices;

public class OrdersProperties {
	
	int orderID;
	String orderedProductName;
	double orderedPeroductPrice;
	String bankAccountNumber;
	String orderTransactionNumber;
	String username;
	
	public String toString() {
        return "OrdersList{" +
                "orderID='" + orderID + '\'' +
                ", orderedProductName='" + orderedProductName + '\'' +
                ", orderedPeroductPrice='" + orderedPeroductPrice + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", orderTransactionNumber='" + orderTransactionNumber + '\'' +
                '}';
    }
	
	public void setOrdersProperties(int orderID, String orderedProductName,double orderedPeroductPrice,String bankAccountNumber,String orderTransactionNumber,String username)
	{
		this.orderID=orderID;
		this.orderedProductName=orderedProductName;
		this.orderedPeroductPrice=orderedPeroductPrice;
		this.bankAccountNumber=bankAccountNumber;
		this.orderTransactionNumber=orderTransactionNumber;
		this.username=username;
		
	}
	
	public void setOrderId(int orderid)
	{
		this.orderID=orderid;
	}
	
	public void setorderedProductName(String orderedProductName)
	{
		this.orderedProductName=orderedProductName;
	}
	
	public void setorderedPeroductPrice(double orderedPeroductPrice)
	{
		this.orderedPeroductPrice=orderedPeroductPrice;
	}
	
	public void setbankAccountNumber(String bankAccountNumber)
	{
		this.bankAccountNumber=bankAccountNumber;
	}
	
	public void setorderTransactionNumber(String orderTransactionNumber)
	{
		this.orderTransactionNumber=orderTransactionNumber;
	}
	
	public void setusername(String username)
	{
		this.username=username;
	}
	
	public void resetOrders()
	{
		this.orderID=0;
		this.orderedProductName=null;
		this.orderedPeroductPrice=0;
		this.bankAccountNumber=null;
		this.orderTransactionNumber=null;
		this.username=null;
	}


}

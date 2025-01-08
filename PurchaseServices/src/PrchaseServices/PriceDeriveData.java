package PrchaseServices;

public class PriceDeriveData {
	
	double deliveryCharges;
	double GST;
	double discount=0;
	double GSTAmount=0;
	
	public PriceDeriveData()
	{
		this.deliveryCharges=30;
		this.GST=18;
	}
	
	public double discount(String x)
	{
		double newUser=10;
		double HDFC=12;
		double SBI=13;
		double ICICI=9;
		
		double axis=11;
		
		switch(x.toLowerCase())
		{
		case ("newuser"): discount=newUser;break;
		
		case("hdfc"):discount=HDFC;break;
		
		case("sbi"): discount=SBI;break;
		
		case("icici"):discount=ICICI;break;
		
		case("axis"):discount=axis;break;
		
		default:
		{
			System.out.println("Provide valid details");
			break;
		}
		
		}
		return this.discount;
	}
	
	public double finalPriceOfProduct(String x,double y)
	{
		return (y-(y*(discount(x))/(100))+(y-(y*(discount(x))/(100)))*(GST/100)+(deliveryCharges));
	}
	
	public double getGSTRate(String x,double y)
	{
		GSTAmount=((y-(y*((discount(x))/(100)))))*(GST/100);
		
		return GSTAmount;
	}
	
	/*public double getPriceAfterDiscount(String x,double y)
	{
		return (y-(y*((discount(x))/(100))));
	}*/

}


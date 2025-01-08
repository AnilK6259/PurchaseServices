package PrchaseServices;

import java.util.Scanner;

public class AccountServices {

	private UserDataList usd;
	private ChangePassword cpwd;
	private Scanner sc;
	private User user;
	private SignIn signin;
	private Home home;
	private UpdateUserDetailsServices uuds;
	private AccountDetails accountDetails;
	private ProductServices productServices;
	private Orders orders;
	private AddToCartServices addToCartServices;
	
	public AccountServices(UserDataList userdatalist,Scanner sc,SignIn signin,Home home)
	{
		this.usd=userdatalist;
		//this.cpwd=cpwd;
		this.sc=sc;
		//this.user=user;
		this.signin=signin;
		this.home=home;
		
	}
	
	public AddToCartServices getAddToCartServices()
	{
		return this.addToCartServices;
	}
	
	public void setAddToCartServices(AddToCartServices addToCartServices)
	{
		this.addToCartServices=addToCartServices;
	}
	
	public void setProductServices(ProductServices productServices)
	{
		this.productServices=productServices;
	}
	
	public void setOrders(Orders orders)
	{
		this.orders=orders;
	}
	
	public ProductServices getProductServices()
	{
	return this.productServices;
	}
	
	public void setChangePassword(ChangePassword cpwd)
	{
		this.cpwd=cpwd;
	}
	public void setAccountDetails(AccountDetails accountDetails)
	{
		this.accountDetails=accountDetails;
	}
	
	public void setUpdateUserDetails(UpdateUserDetailsServices uuds)
	{
		this.uuds=uuds;
	}
	
	public String getUserId()
	
	{
		return signin.tempUserID;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public UserDataList getUserDataList()
	{
		return usd;
	}
	
	public SignIn getSignIn()
	{
		return signin;
	}
	
	public Home getHome()
	{
		return this.home;
	}
	
	public void accountServicesHomePage()
	{
		user=usd.getMap().get(getUserId());
		System.out.println("Welcome to Your Account : "+user.title+" "+user.firstName+" "+user.lastName);

		String tempInput=home.getSignUp().readInput(sc, "Please choose you services 'ChangePassword' 'Account Details' 'UpdateUserDetails' 'Orders' 'Products' 'cart' ");
		
		
		switch (tempInput.toLowerCase())
		{
		case "changepassword":cpwd.changePassword();
			break;
			
		case "accountdetails":accountDetails.printUserDetails();
			break;
			
		case "updateuserdetails":uuds.updateUserDetails();
			break;
			
		case "orders":orders.displayOrders();
			break;
			
		case "products":productServices.productServices();
			break;
			
		case "cart":addToCartServices.addToCartServicesDetails(getSignIn().tempUserID);
			
			default:
			{
				//tempInput=home.readInput(sc, "Please choose you services 'ChangePassword' 'Account Details' 'UpdateUserDetails' 'Orders' Products'");
				accountServicesHomePage();
				break;
			}
		}
	}
}


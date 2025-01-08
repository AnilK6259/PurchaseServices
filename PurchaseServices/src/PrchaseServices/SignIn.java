package PrchaseServices;

import java.util.Scanner;

class SignIn
{
	private UserDataList userdatalist;
	private Home home;
	private AccountServices accountservices;
	String tempUserID;
	
	public SignIn(UserDataList userdatalist,Home home)
	{
		this.userdatalist=userdatalist;
		this.home=home;
	}
	public void setAccountServices(AccountServices accountservices)
	{
		this.accountservices=accountservices;
	}
	
	public SignIn() {
		// TODO Auto-generated constructor stub
	}
	
	public Home getHome()
	{
		return home;
	}
	
	public String getUserName()
	{
		return this.tempUserID;
	}

	public void verifyUser()
	{
		//userdatalist.getMap();
		Scanner sc=new Scanner(System.in);
	tempUserID=home.getSignUp().readInput(sc,"Please enter your UserName");
		String tempPassword=home.getSignUp().readInput(sc,"Please enter your Password");
		
		//System.out.println(userdatalist.getMap().containsKey(tempUserID));
		if(userdatalist.getMap().containsKey(tempUserID))
  
		{
			//System.out.println(userdatalist.getMap().get(tempUserID));
			//userdatalist.getMap().get(tempUserID);
			  // User user = userdatalist.getMap().get(tempUserID).getpassword();
			   
		        if (userdatalist.getMap().get(tempUserID).getpassword().equals(tempPassword)) 
			{
				System.out.println("User succesfully SignedIn");
				accountservices.accountServicesHomePage();
				sc.close();
			}
			
			else
			{
				System.out.println("Invalid Credential Details");
				home.dashBoard();
				sc.close();
			}
		}
		
		else
		{
			System.out.println("Invalid Credential Details");
			home.dashBoard();
			sc.close();
		}
		
	}
	
	
}


package PrchaseServices;

//import java.util.Scanner;

public class UserNameVerification {

	private UserDataList usd;
	private SignUp signUp;
	
	public UserNameVerification(UserDataList usd,SignUp signUp)
	{
		this.usd=usd;
		this.signUp=signUp;
	}
	
	public void userNameavailablityCheck(String userName)
	{
		if(usd.getMap().containsKey(userName))
		{
			System.out.println("User Name is not Available, please provide another one");
			signUp.collectUserDetails();
		}
	}
}

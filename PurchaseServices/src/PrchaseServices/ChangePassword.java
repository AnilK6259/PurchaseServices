package PrchaseServices;

import java.util.Scanner;

public class ChangePassword {

	private Scanner sc;
	private AccountServices accountServices;
	private UserDataList usd;
	private Home home;
	private User user;
	private SignIn signin;
	
	String oldPassword;
	String newPassword;
	String confirmNewPassword;
	
	public ChangePassword(Scanner sc,AccountServices acs,UserDataList usd,Home h,SignIn signin)
	{
		this.sc=sc;
		this.accountServices=acs;
		this.usd=usd;
		this.home=h;
		this.signin=signin;
	}
	
	public void changePassword()
	{
		User NewUser=new User();
		
		NewUser=usd.getMap().get(signin.tempUserID);
		oldPassword=user.password;
		
		String tempOldPassword=home.getSignUp().readInput(sc,"Please enter your OldPassword");
		newPassword=home.getSignUp().readInput(sc,"Please enter your NewPassword");
		confirmNewPassword=home.getSignUp().readInput(sc,"Please enter your ConfirmNewPassword");
		
		if(oldPassword.equals(tempOldPassword)&&newPassword.equals(confirmNewPassword))
		{
			NewUser.password=newPassword;
			System.out.println("password Changed Successfully");
			
			System.out.println("your updated password is "+NewUser.password);
			//System.out.println(accountServices.getUserDataList().getMap().toString());
			
			WriteUser wu= new WriteUser();
			
			wu.writeUserFile(NewUser);
			
			accountServices.accountServicesHomePage();
		}
		
		else
		{
			System.out.println("Given Details are Incorrect");
			changePassword();
		}
		
	}
}


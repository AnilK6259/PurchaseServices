package PrchaseServices;

import java.util.Scanner;

public class ForgetPassword {
	
	private Home home;
	private Scanner sc;
	
	public ForgetPassword(Home home,Scanner sc)
	{
		this.home=home;
		this.sc=sc;
	}
	
	public void changePassword()
	{
		String tempInput=home.getSignUp().readInput(sc, "Please enter your user name");
		
		if(home.getUserDataList().getMap().containsKey(tempInput))
		{
			User fpUser=new User();
			
			fpUser=home.getUserDataList().getMap().get(tempInput);
			
			String tempNewPassword=home.getSignUp().readInput(sc, "Please enter your NewPassword");
			
			String tempConfirmNewPassword=home.getSignUp().readInput(sc, "Please enter your ConfirmNewPassword");
			
			if(tempNewPassword.equals(tempConfirmNewPassword))
			{
				fpUser.password=tempNewPassword;
				
				System.out.println("Password updated successfully as :"+fpUser.password);
				
				WriteUser wu=new WriteUser();
				
				wu.writeUserFile(fpUser);
				
				home.dashBoard();
			}
		}
		
		else
		{
			System.out.println("Invalid details");
			changePassword();
		}
	}

}

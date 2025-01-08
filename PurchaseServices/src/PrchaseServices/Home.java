package PrchaseServices;

import java.util.Scanner;

class Home {

	private UserDataList usd;
	private SignIn signin;
	private User user;
	private SignUp signup;
	private ForgetPassword forgetPassword;
	private Scanner sc;
	
	public void setSignIn(SignIn signin) {
        this.signin = signin;
    }
	public SignUp getSignUp()
	{
		return this.signup;
	}
	
	public void setSignUp(SignUp signup)
	{
		this.signup=signup;
	}
	public Home(UserDataList userdatalist,User user,Scanner sc)
	{
		this.usd=userdatalist;
		this.user=user;
		this.sc=sc;
	}
	
	public User getUser()
	{
		return this.user;
	}
	
	public UserDataList getUserDataList()
	{
		return this.usd;
	}
	
	public void setForgetPassword(ForgetPassword forgetPassword)
	{
		this.forgetPassword=forgetPassword;
	}
	
	
	public void dashBoard(){
		try {
        
            System.out.println("Welcome to goods and Services");

            String x=signup.readInput(sc,"Please Choose Signin or SignUp or ForgetPassword");
            if(x.equalsIgnoreCase("signup"))
            {
           signup.newUserCreation();
            }
            
            else if(x.equalsIgnoreCase("signin"))
            {
            	signin.verifyUser();
            }
            
            else if(x.equalsIgnoreCase("forgetpassword"))
            {
            	forgetPassword.changePassword();
            }
            
            else
            {
            	dashBoard();
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        }
}


package PrchaseServices;

import java.util.Scanner;

public class UpdateUserDetailsServices {
	
	private AccountServices accountservices;
	private Scanner sc;
	
	public UpdateUserDetailsServices(AccountServices accountservices,Scanner sc)
	{
		this.accountservices=accountservices;
		this.sc=sc;
	}
	
	public void updateUserDetails()
	{
		String tempInput=accountservices.getSignIn().getHome().getSignUp().readInput(sc, "Choose UpdateUserdetails or AccountServices");
		
		if(tempInput.equalsIgnoreCase("updateuserdetails"))
		{
			User updateUser=new User();
			
			String userName=accountservices.getSignIn().getUserName();
			
			updateUser=accountservices.getUserDataList().getMap().get(userName);
			
String tempTitle=readInput(sc,"Your Title is :"+accountservices.getUser().title+" \nIf you do not wish to update click on enter button",updateUser.gettitle());
//userDetailsUpdate(updateUser.gettitle(),tempTitle);
			
String tempFirstName=readInput(sc,"Your FirstName is :"+accountservices.getUser().firstName+" \nIf you do not wish to update click on enter button",updateUser.getfirstName());			
//userDetailsUpdate(updateUser.getfirstName(),tempFirstName);

String tempLastName=readInput(sc,"Your LastName is :"+accountservices.getUser().lastName+" \nIf you do not wish to update click on enter button",updateUser.getlastName());			
//userDetailsUpdate(updateUser.getlastName(),tempLastName);

String tempMailId=readInput(sc,"Your MailID is :"+accountservices.getUser().mailId+" \nIf you do not wish to update click on enter button",updateUser.getmailId());			
//userDetailsUpdate(updateUser.getmailId(),tempMailId);
          
          updateUser.title=tempTitle;
          
          updateUser.firstName=tempFirstName;
          
          updateUser.lastName=tempLastName;
          
          updateUser.mailId=tempMailId;


          WriteUser wu=new WriteUser();
          
          wu.writeUserFile(updateUser);
          
          System.out.println("user is updated");
          
          accountservices.accountServicesHomePage();

		}
		else if(tempInput.equalsIgnoreCase("accountservices"))
		{
			accountservices.accountServicesHomePage();
		}
		
		else
		{
			updateUserDetails();
		}
	}
	
	 public  String readInput(Scanner sc, String prompt,String x) {
	        System.out.println(prompt);
	        String input = sc.nextLine().trim();
	        while (input.isEmpty()) {
	            
	            input = x;
	        }
	        return input;
	    }
	/* public void userDetailsUpdate(String x,String y)
	 {
		 if(x==y)
		 {
			//Will think about later
			 x=y;
		 }
		 else
		 {
			 x=y; 
		 }*/
			 
		 
	// }

}

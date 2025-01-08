package PrchaseServices;

import java.util.Scanner;
public class SignUp {
	
	private Home home;
	private Scanner sc;
	private UserNameVerification unv;
	private WriteUser wrUser;
	public void setScanner(Scanner sc)
	{
		this.sc=sc;
	}
	
	public void setScanner(UserNameVerification unv)
	{
		this.unv=unv;
	}
	
	public SignUp(Home home)
	{
		this.home=home;
	}
	
	public void setWriteUser(WriteUser wrUser)
	{
		this.wrUser=wrUser;
	}
	
	public void newUserCreation()
	{
		   User newUser = collectUserDetails();
           if (newUser != null) {
        	   
               home.getUserDataList().setUserData(newUser.userName, newUser);
               
               wrUser.writeUserFile(newUser);
               
               System.out.println("User added successfully!");
               
              // home.getUser().resetUser();
               
               home.dashBoard();
           }
	}
	
	public User collectUserDetails() {
        
		String tempUserName = readInput(sc, "please enter your User Name");
		unv.userNameavailablityCheck(tempUserName);
		String tempTitle = readInput(sc, "please enter your Title");
        String tempFirstName = readInput(sc, "please enter your First Name");
        String tempLastName = readInput(sc, "please enter your Last Name");
        String tempMailId = readInput(sc, "please enter your Mail ID");
        
        String tempPassword = readInput(sc, "please enter your Password");

        //User user = new User(tempTitle, tempFirstName, tempLastName, tempMailId, tempPassword);
        home.getUser().setUser(tempTitle, tempFirstName, tempLastName, tempMailId, tempPassword);
        home.getUser().setUserName(tempUserName);
        return  home.getUser();
    }

   public  String readInput(Scanner sc, String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Input cannot be empty. " + prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }

}


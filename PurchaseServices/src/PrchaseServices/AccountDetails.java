package PrchaseServices;


import java.util.*;

public class AccountDetails {
	
	private AccountServices accountservices;
	//private Scanner sc;
	
	public AccountDetails(AccountServices accountservices,Scanner sc)
	{
		this.accountservices=accountservices;
		//this.sc=sc;
	}
	
	public void printUserDetails()
	{
		System.out.println(accountservices.getUserDataList().getMap());
		
		accountservices.accountServicesHomePage();
	}

}  

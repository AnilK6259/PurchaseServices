package PrchaseServices;

import java.util.Scanner;

public class UserModule {
    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 
    	User user=new User();
    	
    	UserDataList usd = new UserDataList();
    	
        Home home =new Home(usd,user,sc);
        
        SignIn signin = new SignIn(usd, home); // Pass both parameters
        
        home.setSignIn(signin); // You might need to implement this method in Home
        
        AccountServices accountservices=new AccountServices(usd,sc,signin,home);
        
        signin.setAccountServices(accountservices);
        
        ChangePassword cpwd=new ChangePassword(sc,accountservices,usd,home,signin);
        
        AccountDetails accountDetails=new AccountDetails(accountservices, sc);
        
        UpdateUserDetailsServices uuds=new UpdateUserDetailsServices(accountservices, sc);
        
        accountservices.setChangePassword(cpwd);
        
        accountservices.setUpdateUserDetails(uuds);
        
        accountservices.setAccountDetails(accountDetails);
        
        SignUp signup=new SignUp(home);
        signup.setScanner(sc);
        
        UserNameVerification unv=new UserNameVerification(usd, signup);
        
        signup.setScanner(unv);
        ForgetPassword forgetPassword=new ForgetPassword(home,sc);
        home.setForgetPassword(forgetPassword);
        
        PriceDeriveData priceDeriveData=new PriceDeriveData();
        
        ProductDataList productDataList=new ProductDataList();
        
        ProductServices productServices=new ProductServices(productDataList, sc, signup, accountservices);
        
        PurchaseServices purchaseServices=new PurchaseServices(sc, signup, productServices);
        
        //OrdersProperties op=new OrdersProperties();
        
        OrdersList orderList=new OrdersList();
        
        Orders orders=new Orders(accountservices);
        
        AddToCartDataList addToCartDataList=new AddToCartDataList();
        
        AddToCartServices addToCartService=new AddToCartServices(sc, accountservices, addToCartDataList);
        
        productServices.setOrderlist(orderList);
        productServices.setPurchaseServices(purchaseServices);
        productServices.setPriceDeriveData(priceDeriveData);
        
        accountservices.setProductServices(productServices);
        accountservices.setOrders(orders);
        accountservices.setAddToCartServices(addToCartService);
        

        
        Products products=new Products();
 
        home.setSignUp(signup);
        
        WriteUser wrUser=new WriteUser();
        
        signup.setWriteUser(wrUser);
        
        WriteOrders wrOrders=new WriteOrders();
        
        purchaseServices.setOrdersFile(wrOrders);
        
        LoadData  rd=new LoadData (user, usd, products, productDataList, addToCartDataList, orderList);
       
        rd.readUsersData("orders");
        
        rd.readUsersData("users");
        
        rd.readUsersData("products");
        
       rd.readUsersData("addtocart");
        
      home.dashBoard(); 
        
        sc.close(); 
    }

    
}


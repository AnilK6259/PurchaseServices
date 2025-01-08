package PrchaseServices;

class User {
    String firstName;
    String title;
    String lastName;
    String userName;
    String mailId;
    String password;

   /* public User(String title, String firstName, String lastName, String mailId, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailId = mailId;
        this.password = password;
    }*/
    
    public User()
    {
    	
    }
    
    public void setUser(String title, String firstName, String lastName, String mailId, String password)
    {
    	this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailId = mailId;
        this.password = password;
       // this.userName=userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mailId='" + mailId + '\'' +
                ", password='" + password + '\'' +
               // ",userName='"+userName+
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void settitle(String title) {
        this.title = title;
    }
    
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setmailId(String mailId) {
        this.mailId = mailId;
    }
    
    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getUserName()
    {
    	return this.userName;
    }
    
    public String gettitle()
    {
    	return this.title;
    }
    public String getfirstName()
    {
    	return this.firstName;
    }
    
    public String getlastName()
    {
    	return this.lastName;
    }
    
    public String getmailId()
    {
    	return this.mailId;
    }
    
    public String getpassword()
    {
    	return this.password;
    }
    
    public void resetUser() {
        this.userName = null;
        this.title = null;
        this.firstName = null;
        this.lastName = null;
        this.mailId = null;
        this.password = null;
    }

}

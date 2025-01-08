package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteUser {
	
	public void writeUserFile(User newUser)
	{
		User user=newUser;
		
		String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Users\\";
		
		String fileName=tooStringFileName(user.getUserName());
		
		String filePath=tooStringFileName(fileName,dirPath);
		
		File file=new File(filePath);
		try
		{
		FileWriter fw=new FileWriter(file);
		
		try (BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write("userName: "+user.getUserName()+"\n");
			bw.write("title: "+user.gettitle()+"\n");
			bw.write("firstName: "+user.getfirstName()+"\n");
			bw.write("lastName: "+user.getlastName()+"\n");
			bw.write("mailId: "+user.getmailId()+"\n");
			bw.write("password: "+user.getpassword()+"\n");
		}
		fw.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String tooStringFileName(String fileName)
	{
		StringBuffer sb=new StringBuffer(fileName);
		sb.append(".txt");
		
		return sb.toString();
	}
	
	public String tooStringFileName(String fileName,String dirPath)
	{
		StringBuffer sb=new StringBuffer(dirPath);
		sb.append(fileName);
		
		return sb.toString();
	}
	
	

}

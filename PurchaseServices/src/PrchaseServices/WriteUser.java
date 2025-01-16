package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class WriteUser {
	
	public void writeUserFile(User newUser)
	{
		User user=newUser;
		
		String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Users\\";
		
		String fileName=tooStringFileName(user.getUserName());
		
		String filePath=tooStringFileName(fileName,dirPath);
		
		File file=new File(filePath);
		/*try
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
		}*/
		
		JsonFactory jf=new JsonFactory();
		
		try {
			JsonGenerator jg=jf.createGenerator(file, JsonEncoding.UTF8);
			
			jg.writeStartObject();
			
			jg.writeStringField("userName", user.getUserName());
			
			jg.writeStringField("title", user.gettitle());
			
			jg.writeStringField("firstName", user.getfirstName());
			
			jg.writeStringField("lastName", user.getlastName());
			
			jg.writeStringField("mailId", user.getmailId());
			
			jg.writeStringField("password", user.getpassword());
			
			jg.writeEndObject();
			
			jg.close();
			
			System.out.println("Json File Created");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String tooStringFileName(String fileName)
	{
		StringBuffer sb=new StringBuffer(fileName);
		sb.append(".json");
		
		return sb.toString();
	}
	
	public String tooStringFileName(String fileName,String dirPath)
	{
		StringBuffer sb=new StringBuffer(dirPath);
		sb.append(fileName);
		
		return sb.toString();
	}
	
	

}

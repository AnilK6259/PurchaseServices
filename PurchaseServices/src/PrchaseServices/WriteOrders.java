package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class WriteOrders {
	
	public void writeOrderFile(OrdersProperties NewOrder)
	{
		OrdersProperties ordersList=NewOrder;
		
        String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Orders\\";
		
		String fileName=tooStringFileName(String.valueOf(ordersList.orderID));
		
		String filePath=tooStringFileName(fileName,dirPath);
		
		File file=new File(filePath);
		
		/*try
		{
			FileWriter fw=new FileWriter(file);
			
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				bw.write("orderID: "+ordersList.orderID+"\n");
				bw.write("orderedProductName: "+ordersList.orderedProductName+"\n");
				bw.write("orderedPeroductPrice: "+ordersList.orderedPeroductPrice+"\n");
				bw.write("bankAccountNumber: "+ordersList.bankAccountNumber+"\n");
				bw.write("orderTransactionNumber: "+ordersList.orderTransactionNumber+"\n");
				bw.write("username: "+ordersList.username+"\n");
			}
			
			fw.close();
			
			System.out.println("File created");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}*/
		
		JsonFactory jf=new JsonFactory();
		
		try {
			JsonGenerator jg=jf.createGenerator(file, JsonEncoding.UTF8);
			
			jg.writeStartObject();
			
			jg.writeNumberField("orderId", ordersList.orderID);
			
			jg.writeStringField("orderedProductName", ordersList.orderedProductName);
			
			jg.writeNumberField("orderedPeroductPrice", ordersList.orderedPeroductPrice);
			
			jg.writeStringField("bankAccountNumber", ordersList.bankAccountNumber);
			
			jg.writeStringField("orderTransactionNumber", ordersList.orderTransactionNumber);
			
			jg.writeStringField("username", ordersList.username);
			
			jg.writeEndObject();
			
			 jg.close();
	            
	            System.out.println("JSON file created successfully!");
	            
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

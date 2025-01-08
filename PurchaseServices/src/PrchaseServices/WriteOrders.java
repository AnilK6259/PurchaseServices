package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteOrders {
	
	public void writeOrderFile(OrdersProperties NewOrder)
	{
		OrdersProperties ordersList=NewOrder;
		
        String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\Orders\\";
		
		String fileName=tooStringFileName(String.valueOf(ordersList.orderID));
		
		String filePath=tooStringFileName(fileName,dirPath);
		
		File file=new File(filePath);
		
		try
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

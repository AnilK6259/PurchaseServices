package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteCartFile {
	
	public void wirteCartFile(AddToCartServicesProperties acsp)
	{
		String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\AddToCart\\";
		
		String fileName=acsp.getuserName()+acsp.getorderId();
		
		String filePath=dirPath+fileName+".txt";
		
		File file=new File(filePath);
		
		try
		{
			FileWriter fw=new FileWriter(file);
			
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				bw.write("orderId: "+acsp.getorderId()+"\n");
				bw.write("username: "+acsp.getuserName()+"\n");
				bw.write("productName: "+acsp.getProductName()+"\n");
				bw.write("productPrice: "+acsp.getProductPrice()+"\n");
			}
			fw.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

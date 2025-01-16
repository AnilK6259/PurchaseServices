package PrchaseServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class WriteCartFile {
	
	public void wirteCartFile(AddToCartServicesProperties acsp)
	{
		String dirPath="C:\\Users\\anilk\\JavaPractice\\PurchaseAndServices\\AddToCart\\";
		
		String fileName=acsp.getuserName()+acsp.getorderId();
		
		String filePath=dirPath+fileName+".json";
		
		File file=new File(filePath);
		
		/*try
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
		}*/
		
		JsonFactory jf=new JsonFactory();
		
		try {
			JsonGenerator jg=jf.createGenerator(file, JsonEncoding.UTF8);
			
			jg.writeStartObject();
			
			jg.writeNumberField("orderId", acsp.getorderId());
			
			jg.writeStringField("userName", acsp.getuserName());
			
			jg.writeStringField("productName", acsp.getProductName());
			
			jg.writeNumberField("productPrice", acsp.getProductPrice());
			
			jg.writeEndObject();
			
			 jg.close();
	            
	            System.out.println("JSON file created successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

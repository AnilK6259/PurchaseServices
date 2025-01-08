package PrchaseServices;

import java.util.HashMap;
import java.util.Map;
//import java.util.TreeMap;

public class ProductDataList {
	
	
	private Map<String,Map<String,Products>> productDataList=new HashMap<>();
	
	
	
	public Map<String,Map<String,Products>> getProductDataList()
	{
		return this.productDataList;
	}
	
	public void setProductsDataList(String category,String productName,Products products)
	{
	
		
        /* Map<String,Products> productsDataListInnerMap;
         
         if(productDataList.containsKey(category))
         {
        	 productsDataListInnerMap=productDataList.get(category);
        	 
        	 productsDataListInnerMap.put(productName, products); 
         }
		
         else
         {
        	  productsDataListInnerMap=new HashMap<String, Products>();
        	 productsDataListInnerMap.put(productName, products);
        	 productDataList.put(category, productsDataListInnerMap);
         }*/
         
         Map<String, Products> productsDataListInnerMap = 
                 productDataList.computeIfAbsent(category, k -> new HashMap<>());
             
           
             productsDataListInnerMap.put(productName, products);
		
		//productDataList.put(category, (Map<String, Products>) productsDataListInnerMap.put(productName, products));
	
	}

}

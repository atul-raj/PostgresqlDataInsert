package com.util.data;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class DataGen {
	
	public void insertData(StringEntity params){
		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

		   try {
		       HttpPost request = new HttpPost("https://predix-services-example.run.aws-usw02-pr.ice.predix.io/api/v1/pgd/");
		      // StringEntity params =new StringEntity("{\"turbine\":\"t125\",\"site\":2,\"customer\":4,\"project\":14, \"status\":1, \"temperature\":19.3, \"voltage\":10.1} ");
		     
		       request.addHeader("content-type", "application/json");
		     
		       request.setEntity(params);
		       HttpResponse response = httpClient.execute(request);
		       System.out.println(response.getStatusLine());
		   }catch (Exception ex) {
		   } finally {
		   }
	}

}

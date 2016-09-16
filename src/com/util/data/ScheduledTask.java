package com.util.data;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {

	Date now; // to display current time
	Date last = new Date(2016, 9, 17);
	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		
		
		System.out.println("Time is :" + now); // Display current time
		System.out.println("Last Time is :" + last);
		String parameters = "";
		String turbine = "";
		String site = "";
		String customer = "";
		String project = "";
		String status = "" ;
		String power = "";
		double voltage = 0.0;
		double temperature =  0.0;
		double rangeMin = 80;
		double rangeMax = 130;
		double rangeMinV = 100;
		double rangeMaxV = 250;
		DecimalFormat df = new DecimalFormat("#.##");  
		int count = 1;
		//for demo only.
		DataGen dGen = new DataGen();
		for (int i = 0; i <= 45; i++) {
			System.out.println("Execution in Main Thread...." + i);
			
			//MongoInsert moins = new  MongoInsert();
	          turbine = "T" + (i+1) ;
	          site = "S" + count++ ;
	          switch (count) {
	            case 1:  project = "US-North";
	                     customer = "GE-ELECTRIC";
	                     break;
	            case 2:  project = "US-South";
	                     customer = "DTE Energy";
	                     break;
	            case 3:  project = "US-EAST";
	                     customer = "Public Service Elec & Gas";	            
	                     break;
	            case 4:  project = "US-SOUTH";
	                     customer = "Virginia Electric & Power";
	                     break;
	            case 5:  project = "US-CENTRAL";
	                     customer = "Duke Energy Carolinas";
	                      break;
	          }  
	         
	          
	          if (count == 5){
	        	  count = 1; 
	          }
	          Random random = new Random();
	         int power2 = random.nextInt(30);
	     	temperature = ThreadLocalRandom.current().nextDouble(rangeMin, rangeMax);
		    
	     	temperature = Double.valueOf(df.format(temperature));
	     	voltage = ThreadLocalRandom.current().nextDouble(rangeMinV, rangeMaxV);
		    
	     	voltage = Double.valueOf(df.format(temperature));
	         power = Integer.toString(power2);
	          Random random1 = new Random();
	          int status1 = random1.nextInt(8);
	        //  System.out.println("status1==>"+status1+"  Power==>"+power);
	          if (status1 == 0){
	        	 power = "0";
	        	 status = "0";
	          }else {
	        	  status = "1";
	          }
	       
	       try {
	        	  parameters = "{\"turbine\":\""+turbine+"\",\"site\":\""+site+"\",\"customer\":\""+customer+"\",\"project\":\""+project+"\", \"status\":"+status+", \"temperature\":"+temperature+", \"voltage\":"+voltage+"} ";
	        	//  System.out.println(parameters);
	         
				StringEntity params =new StringEntity(parameters);
			
				 dGen.insertData(params);
				
		} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
		}
			//moins.insertData(turbine, site,customer, project,status,power);
	        	 
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (now == last) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
	}
}
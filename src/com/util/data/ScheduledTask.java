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

public void run() {

String turbine = "";
String site = "";
String customer = "";
String project = "";

for (int count = 1; count <= 4; count++) {

         site = "S" + count ;
         switch (count) {
           case 1:  project = "US-North";
                    customer = "GE-ELECTRIC";
                    for(int i = 1 ; i<= 4; i++){
                    	 turbine = "T" + i ;
                    	 generateOtherData(turbine, site, customer, project);
                    	 
                    }
                    break;
           case 2:  project = "US-South";
                    customer = "DTE Energy";
                    for(int i = 1 ; i<= 4; i++){
                   	 turbine = "T" + i ;
                   	 generateOtherData(turbine, site, customer, project);
                   	 
                   }
                    break;
           case 3:  project = "US-East";
                    customer = "Public Service Elec & Gas";  
                    for(int i = 1 ; i<= 3; i++){
                   	 turbine = "T" + i ;
                   	 generateOtherData(turbine, site, customer, project);
                   	 
                   }
                    break;
           case 4:  project = "US-West";
                    customer = "Duke Energy Carolinas";
                    for(int i = 1 ; i<= 5; i++){
                   	 turbine = "T" + i ;
                   	 generateOtherData(turbine, site, customer, project);
                   	 
                   }
                    break;
             }  
       
         
    

     }
     }
public void generateOtherData(String turbine,String site,String customer,String project){
	String parameters = "";
	
	String status = "" ;
	double voltage = 0.0;
	double temperature =  0.0;
	double rangeMin = 350;
	double rangeMax = 600;
	double rangeMinV = 5;
	double rangeMaxV = 25;
	DecimalFormat df = new DecimalFormat("#.##"); 
	DataGen dGen = new DataGen();
    temperature = ThreadLocalRandom.current().nextDouble(rangeMin, rangeMax);

temperature = Double.valueOf(df.format(temperature));
voltage = ThreadLocalRandom.current().nextDouble(rangeMinV, rangeMaxV);

voltage = Double.valueOf(df.format(voltage));
   
     Random random1 = new Random();
     int status1 = random1.nextInt(8);
     if (status1 == 0){
         status = "0";
         voltage = 0.0;
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
 // e1.printStackTrace();
 } 
}

     }           
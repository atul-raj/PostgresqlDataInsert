package com.util.data;


import java.util.Timer;


//Main class
public class SchedulerMain {
	public static void main(String args[]) throws InterruptedException {

		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 1000*60*10); // Create Repetitively task for every 1 secs

		
	}
}
package it.clever.course.j2se.threads;


import java.util.*;

class Task extends TimerTask {
  
    int count = 1;

	// run is a abstract method that defines task performed at scheduled time.
    public void run() {
        System.out.println(count+" : Mahendra Singh");
	    count++;
    }
}

class TaskScheduling {

   public static void main(String[] args) {
       Timer timer = new Timer();
   
       // Schedule to run after every 3 second(3000 millisecond)
       timer.schedule( new Task(), 300);	
   }
}
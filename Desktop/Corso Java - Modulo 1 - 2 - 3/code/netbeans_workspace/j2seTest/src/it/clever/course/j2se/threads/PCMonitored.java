package it.clever.course.j2se.threads;

public class PCMonitored {
	
  public static void main(String [] args) {
     Buffer2 b = new Buffer2(4);
     Producer2 p = new Producer2(b);
     Consumer2 c = new Consumer2(b);

     p.start();
     c.start();
  }
}

class Buffer2 {
   private char [] buffer;
   private int count = 0, in = 0, out = 0;

   Buffer2(int size)
   {
      buffer = new char[size];
   }
 
   public synchronized void Put(char c) {
	   while(count == buffer.length) 
       {
            try { wait(); }
            catch (InterruptedException e) { } 
            finally { } 
       } 
     System.out.println("Producing " + c + " ...");
     buffer[in] = c; 
     in = (in + 1) % buffer.length; 
     count++;
     notify(); 
   }
    
   public synchronized char Get() {
       while (count == 0) 
       {
            try { wait(); }
            catch (InterruptedException e) { } 
            finally { } 
       } 
     char c = buffer[out]; 
     out = (out + 1) % buffer.length;
     count--;
     System.out.println("Consuming " + c + " ...");
     notify(); 
     return c;
   }
}
     

class Producer2 extends Thread {
   private Buffer2 buffer;
     
   Producer2(Buffer2 b) { buffer = b; }
   public void run() {
     for(int i = 0; i < 10; i++) {
        buffer.Put((char)('A'+ i%26 )); }
   }
}    

class Consumer2 extends Thread {
   private Buffer2 buffer;
   
   Consumer2(Buffer2 b) { buffer = b; }
   public void run() {
     for(int i = 0; i < 10; i++) {
        buffer.Get(); }
   }
}   


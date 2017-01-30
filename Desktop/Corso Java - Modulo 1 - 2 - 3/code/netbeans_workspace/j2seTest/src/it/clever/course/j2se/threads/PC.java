package it.clever.course.j2se.threads;

public class PC
{
  public static void main(String [] args)
  {
     Buffer2 b = new Buffer2(4);
     Producer2 p = new Producer2(b);
     Consumer2 c = new Consumer2(b);

     p.start();
     c.start();
  }
}

class Buffer {
   private char [] buffer;
   private int count = 0, in = 0, out = 0;

   Buffer(int size)
   {
      buffer = new char[size];
   }
 
   public synchronized void Put(char c) {
     while(count == buffer.length) ;
     System.out.println("Producing " + c + " ...");
     buffer[in] = c; 
     in = (in + 1) % buffer.length; 
     count++;
   }
    
   public synchronized char Get() {
     while (count == 0) ;
     char c = buffer[out]; 
     out = (out + 1) % buffer.length;
     count--;
     System.out.println("Consuming " + c + " ...");
     return c;
   }
}
     

class Producer extends Thread {
   private Buffer2 buffer2;
     
   Producer(Buffer2 b) { buffer2 = b; }
   public void run() {
     for(int i = 0; i < 10; i++) {
        buffer2.Put((char)('A'+ i%26 )); }
   }
}    

class Consumer extends Thread {
   private Buffer2 buffer2;
   
   Consumer(Buffer2 b) { buffer2 = b; }
   public void run() {
     for(int i = 0; i < 10; i++) {
        buffer2.Get(); }
   }
}   


package it.clever.course.j2se.string;

public class StringComparison {
	  /**
	   * @param args
	   */
	  public static void main(String[] args) {
	    long start=System.currentTimeMillis();
	    testString();
	    long end=System.currentTimeMillis();
	    System.out.println("Tempo di esecuzione testString() "+(end-start)+ " millis.");
	    
	    start=System.currentTimeMillis();
	    testStringBuffer();
	    end=System.currentTimeMillis();
	    System.out.println("Tempo di esecuzione testStringBuffer() "+(end-start)+ " millis.");
	    
	    start=System.currentTimeMillis();
	    testStringBuilder();
	    end=System.currentTimeMillis();
	    System.out.println("Tempo di esecuzione testStringBuilder() "+(end-start)+" millis.");
	  }

	  private static void testString() {
	    String x = "";
	    for(int i=0;i<15000;i++){
	      //operazione di append
	      x+=i;
	    }
	  }
	  
	  /*
	   * In ambiente pre java 1.5 il modo più ovvio per gestire catene di testo mutabili era quello di usare 
	   * direttamente la classe StringBuffer ed i relativi metodi per la gestione del testo 
	   * (in particolare del metodo append e dei metodi replace).
	   *  La classe è una threadsafe, il che consente di poter effettuare le operazioni sull’oggetto StringBuffer 
	   *  condividendolo tra diversi thread.
	   */
	  private static void testStringBuffer() {
	    StringBuffer x = new StringBuffer("");
	    for(int i=0;i<15000;i++){
	      //operazione di append
	      x.append(i);
	    }
	  }

	  /*
	   * StringBuilder è identica a StringBuffer, stessi metodi stessa logica, unica differenza: 
	   * non è threadsafe. 
	   * Le performance migliorano in maniera netta, in particolare considerando che molti programmi 
	   * fanno un notevole uso delle stringhe e della loro modifica durante il ciclo di vita del software. 
	   * L’utilizzo, quindi, d’ora in poi dovrebbe essere scontato a favore della nuova classe introdotta, 
	   * nel momento in cui non si debba gestire aspetti legati all’accesso concorrente alla risorsa. 
	   */
	  private static void testStringBuilder() {
	    StringBuilder x = new StringBuilder("");
	    for(int i=0;i<15000;i++){
	      //operazione di append
	      x.append(i);
	    }
	  }
	} 
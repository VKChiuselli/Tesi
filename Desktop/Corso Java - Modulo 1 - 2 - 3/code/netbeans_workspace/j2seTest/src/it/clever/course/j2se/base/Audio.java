package it.clever.course.j2se.base;

public enum Audio {

	MP3("mp3",128){
		  @Override
		  public void reproduce(String archive){
		    System.out.println(archive+" Playing an MP3");
		    // Play the concrete player
		  }
		},
	PCM("PCM"){
	  @Override
	  public void reproduce(String archive){
	    System.out.println(archive+" Playing an PCM");
	    // Play the concrete player
	  }
	},
		
	DD("Dolby Digital",256){
	  @Override
	  public void reproduce(String archive){
	    System.out.println(archive+" Playing an Dolby Digital");
	    // Play the concrete player
	  }
	  
	  @Override
	  public String toString(){
	    //Override del metodo toString()
	    return "Dolby Digital";
	  }
	}; 
		
	  private final String channel;
	  private final int bitrate;
	  
	  Audio(String channel,int bitrate){
	    this.channel=channel;
	    this.bitrate=bitrate;
	  }
	  
	  Audio(String channel){
	    this.channel=channel;
	    bitrate = -1;
	  }
	  
	  public abstract void reproduce(String archive);
	  
	  //Getter and setter
	  public String getChannel() {
	    return channel;
	  }
	  public int getBitrate() {
	    return bitrate;
	  }
	  
	  public static void main(String[]args){
		    System.out.println("Riproduttori disponibili");
		    for (Audio tmp:Audio.values()){
		      System.out.println(tmp);
		    }
		    //Scegliamo il riproduttore mp3
		    Audio d = DD;
		    d.reproduce("New song to play.mp3");
		  }	  
} 
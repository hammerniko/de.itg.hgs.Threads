 package b03_ThreadSongplayerMitInterface;

public class StartKlasse {

	
	public static void main(String[] args) {
		//Beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		SongPlayer songplayer1 = new SongPlayer("A",4000);
		SongPlayer songplayer2 = new SongPlayer("B",0); 
		SongPlayer songplayer3 = new SongPlayer("C",8000);
		SongPlayer songplayer4 = new SongPlayer("D",12000);
		
		//Thread nebenlaeufig starten 
		songplayer1.start();
		songplayer2.start();
		songplayer3.start();
		songplayer4.start(); 
		
		//Ende main-Thread
		System.out.println("Main Thread zuende");

	}

}

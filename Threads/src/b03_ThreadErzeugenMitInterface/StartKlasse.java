package b03_ThreadErzeugenMitInterface;

public class StartKlasse {

	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		
		
		//Thread Objekt erzeugen
		SongPlayer t = new SongPlayer("A",0,'C');
		SongPlayer t2 = new SongPlayer("B",4000,'G');
		SongPlayer t3 = new SongPlayer("C",8000,'E');
		SongPlayer t4 = new SongPlayer("D",12000,'E');
		
		//Thread nebenlaeufig starten
		t.start();
		t2.start();
		t3.start();
		t4.start();
		
		//Ende main-Thread
		System.out.println("Main Thread zuende");

	}

}

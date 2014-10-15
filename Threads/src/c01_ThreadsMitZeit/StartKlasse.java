package c01_ThreadsMitZeit;

public class StartKlasse {

	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		MyThread t = new MyThread("A",100);
		MyThread t2 = new MyThread("B",300);
		MyThread t3 = new MyThread("C",500);
		
		
		//Thread nebenlaeufig starten
		t.start();
		t2.start();
		t3.start();
		
		//Ende main-Thread
		System.out.println("Main Thread zuende");

	}

}

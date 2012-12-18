package A_ThreadErzeugen;

public class StartKlasse {
	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		MyThread t = new MyThread("A",300);
		MyThread t2 = new MyThread("B",100);
		
		//Thread starten
		t.start();
		t2.start();
		
		System.out.println("Main Thread zuende");

	}
}

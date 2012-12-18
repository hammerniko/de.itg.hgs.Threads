package B_ThreadErzeugenMitInterface;

public class StartKlasse {

	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		MyThread t = new MyThread("A");
		MyThread t2 = new MyThread("B");
		MyThread t3 = new MyThread("C");
		
		
		//Thread nebenlŠufig starten
		t.start();
		t2.start();
		t3.start();
		
		//Ende main-Thread
		System.out.println("Main Thread zuende");

	}

}

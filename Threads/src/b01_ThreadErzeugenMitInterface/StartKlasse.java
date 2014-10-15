package b01_ThreadErzeugenMitInterface;

public class StartKlasse {

	
	public static void main(String[] args) {
		//beginn main Thread
		System.out.println("Main Thread gestartet");
		
		//Thread Objekt erzeugen
		MyThread t = new MyThread("A",0,'C');
		MyThread t2 = new MyThread("B",4000,'G');
		MyThread t3 = new MyThread("C",8000,'E');
		MyThread t4 = new MyThread("D",12000,'E');
		
		//Thread nebenlaeufig starten
		t.start();
		t2.start();
		t3.start();
		t4.start();
		
		//Ende main-Thread
		System.out.println("Main Thread zuende");

	}

}

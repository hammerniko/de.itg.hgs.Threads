package a03_Thread_unterbrechen;

public class Unterbrechung extends Thread {

	@Override
	public void run() {
		System.out.println("Thread start");

		while (true) {

			// Wenn unterbrochen wurde, breche die Schleife ab
			if (this.isInterrupted())
				break;

			// Wenn nicht unterbrochen wurde mach weiter
			System.out.println("Thread läuft...");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// Wenn während der Sleep-Phase unterbrochen
				// wurde und deshalb eine Exception ausgelöst wurde.
				// Unterbechung nochmal anfordern.
				interrupt();
			}

		}
		System.out.println("Thread beendet");
	}
	
	
	public static void main(String[] args) {
		System.out.println("Main Thread gestartet");
		
		Unterbrechung uThread = new Unterbrechung();
		uThread.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) { }
		
		uThread.interrupt();
		System.out.println("Main Thread zuende");
		
	}

}

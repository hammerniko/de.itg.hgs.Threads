package a03_Thread_unterbrechen;

/*
 * Die Methoden stop() und suspend() zum unterbechen von Threads von aussen sind
 * veraltet und sollten nicht mehr verwendet werden.
 * Statt dessen kann ein Flag mit der Methode interrupt() ausgelöst werden.
 * Dabei wird versucht den Thread zu unterbrechen. Ist dieser gerade nicht aktiv, wird eine
 * InterruptedException ausgelöst. Beim Auffangen dieser Exception kann man dann nochmals die interrupt()
 * Methode aufrufen. Wird nun mit isInterrupted() geprüft, liefert die Methode true 
 * und der Thread kann wie z.B. hier mit break; abgebrochen werden.
 * 
 */

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

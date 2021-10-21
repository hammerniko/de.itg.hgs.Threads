package a03_Thread_unterbrechen;

import java.util.Scanner;

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

public class UnterbrechungKonsole extends Thread {
	
	static int i=0;
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
				
				for (i = 0; i < 100; i++) {
					System.out.println("Thread:"+i);
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				// Wenn waehrend der Sleep-Phase unterbrochen
				// wurde und deshalb eine Exception ausgelöst wurde.
				// Unterbechung nochmal anfordern.
				interrupt();
			}

		}
		System.out.println("Thread beendet");
	}
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println(" Main Thread gestartet");
		
		UnterbrechungKonsole uThread = new UnterbrechungKonsole();
		uThread.start();
		
		
		System.out.println("Eingabe:");
		if(s.nextInt()==0) {
			
			uThread.interrupt();
		}
		
			
		System.out.println("Main Thread zuende");
		
	}

}

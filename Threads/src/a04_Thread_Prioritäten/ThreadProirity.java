package a04_Thread_Prioritäten;

import a03_Thread_unterbrechen.Unterbrechung;

/*
 * Mit setPriority(Thread.MIN_PRIORITY) setzt man die minimale Priorität eines Threads.
 * Mit setPriority(Thread.MAX_PRIORITY) setzt man die maximale Priorität eines Threads.
 * Mit setPriority(Thread.NORM_PRIORITY)setzt man die standard Priorität eines Threads. (5)
 * Mit getPriority() ermittelt man die Priorität eines Threads.
 * Die Prioritäten entsprechen Zahlen von 1 bis 10
 */

public class ThreadProirity extends Thread {

	private String name;
	
	public ThreadProirity(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		while (true) {

			// Wenn unterbrochen wurde, breche die Schleife ab
			if (this.isInterrupted())
				break;

			// Wenn nicht unterbrochen wurde mach weiter
			System.out.println(name+ "Thread läuft mit priorität"+getPriority()+"\n");
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
		
		ThreadProirity t1 = new ThreadProirity("A");
		ThreadProirity t2 = new ThreadProirity("B");
		
		t1.setPriority(MAX_PRIORITY);
		t2.setPriority(MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
	
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) { }
		
		t1.interrupt();
		System.out.println("Main Thread zuende");
		
		
		
	}


}

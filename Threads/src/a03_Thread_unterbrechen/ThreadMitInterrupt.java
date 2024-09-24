package a03_Thread_unterbrechen;
public class ThreadMitInterrupt extends Thread {
	@Override
	public void run() {
		while (true) {

			// Wenn unterbrochen wurde, breche die Schleife ab
			if (this.isInterrupted())
				break;

			// Wenn nicht unterbrochen wurde mach weiter
			System.out.println("Thread laeuft...");
			try {
				for (int i = 0; i < 100; i++) {
					System.out.print("\033[F");
					System.out.print("Thread:"+i);
					System.out.print("\033[F");
					
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
}

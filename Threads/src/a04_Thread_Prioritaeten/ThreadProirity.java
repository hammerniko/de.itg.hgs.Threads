package a04_Thread_Prioritaeten;

/*
 * Mit setPriority(Thread.MIN_PRIORITY) setzt man die minimale Priorität eines Threads.
 * Mit setPriority(Thread.MAX_PRIORITY) setzt man die maximale Priorität eines Threads.
 * Mit setPriority(Thread.NORM_PRIORITY)setzt man die standard Priorität eines Threads. (5)
 * Mit getPriority() ermittelt man die Priorität eines Threads.
 * Die Prioritäten entsprechen Zahlen von 1 bis 10
 * 
 * Eine höhere Priorität eines Threads in Java erzwingt nicht automatisch eine Ausführung vor einem 
 * Thread mit einer wichtigeren Priorität. Dies hängt vom Verhalten des
 * jeweiligen Schedulers ab.
 * 
 * So startet dieses PRogramm oft mit einem anderen Thread. Nicht immer mit dem mit der höchsten Priorirät.
 * 
 */

public class ThreadProirity extends Thread {

	private String name;
	private int dauer;
	private int workTime;

	public ThreadProirity(String name, int dauer) {
		this.name = name;
		this.dauer = dauer;
		workTime = 5;
	}

	@Override
	public void run() {
		System.out.println();
		while (true) {

			// Wenn unterbrochen wurde, breche die Schleife ab
			if (this.isInterrupted())
				break;

			// Wenn nicht unterbrochen wurde mach weiter
			System.out.print(name + dauer + "|");
			dauer = dauer - workTime;
			if (dauer <= 0)
				break;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// Wenn während der Sleep-Phase unterbrochen
				// wurde und deshalb eine Exception ausgelöst wurde.
				// Unterbechung nochmal anfordern.
				interrupt();
			}

		}
	}

	public static void main(String[] args) {

		ThreadProirity a = new ThreadProirity("A", 20);
		ThreadProirity b = new ThreadProirity("B", 30);
		ThreadProirity c = new ThreadProirity("C", 40);

		a.setPriority(MAX_PRIORITY);
		b.setPriority(MIN_PRIORITY);
		c.setPriority(NORM_PRIORITY);

		a.start();
		b.start();
		c.start();

	}

}

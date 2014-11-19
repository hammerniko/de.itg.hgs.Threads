package b04_ThreadSynchronizedZugriff;

import java.lang.*;
import java.io.*;

/**
 * Wird in der Methode erhoheID das Schlüsselwort synchronized weggelassen, kann es
 * vorkommen, das einige Threadobjekte die gleiche ID bekommen. Da evtl. mehrere
 * Threads gleichzeitig auf die Methode zugereifen. Synchronized verhindert
 * diesen gleichzeitigen Zugriff und "locked" die Methode für andere Threads, so
 * lange ein Thread sie bearbeitet.
 * 
 * Durch entfernen des Schlüsselwortes synchronized kann das Szenario getestet
 * werden. Synchronized kostet Performance, da Threads auf andere Threads warten müssen.
 * 
 * Es ist darauf zu achten, das der Mutex(Gültigkeitsbereich der Sperre) nicht
 * nur innerhalb des Objekts gilt. Synchronized Blöcke oder Methoden gelten nur innerhalb eines Objektes.
 * Static Methoden gelten dann für alle Threads, die auf diese Methode zugreifen.
 *
 * Bei synchronized beginnt die Sperre immer mit der geschweiften Klammer des betroffenen
 * Codeblocks und endet mit der schliessenden Klammer automatisch. (Nicht wie bei Lock, wo die Sperre von Hand
 * gesetzt werden muss.)
 * 
 * @author hr
 * 
 */
class ObjectID {

	private static int anzahlObjekteIDs = 0;
	private int id;

	private synchronized static int erhoeheID(){
		return anzahlObjekteIDs++;
	}
	
	private int getID() {
		return id;
	}

	public ObjectID() {
		id = erhoeheID();
	}

	public void print() {
		System.out.println("ID: " + getID());
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; ++i) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.currentThread().sleep(100);
					} catch (Exception e) {
						System.out.println("Fehler");
					}
					final ObjectID o = new ObjectID();
					o.print();
				}
			}).start();
		}

	}
}
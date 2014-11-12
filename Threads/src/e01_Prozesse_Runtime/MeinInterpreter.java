package e01_Prozesse_Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeinInterpreter {

	/**
	 * Ruft den Dateibrowser des Systems auf. Über die Systemeigenschaft os.name
	 * wird überprüft, welches OS gerade läuft. Wenn Windows läuft wird der
	 * Explorer gestartet, wenn Mac OS X läuft wird der Finder gestartet.
	 * 
	 */
	public void openFileBrowser() {

		// Neuen Thread erzeugen
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				String os = System.getProperty("os.name");
				String command = "";
				Process p = null;

				try {
					if (os.contains("Windows")) {
						System.out.println("Windows");
						command = "explorer.exe";
						p = Runtime.getRuntime().exec(command);

					} else if (os.contains("OS X")) {

						command = ".";
						p = Runtime.getRuntime().exec(
								new String[] { "open", command });
					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}//End run()
		});// End Thread

		// Thread starten
		if (!t.isAlive()) {
			t.start();
		}
	}// End Method
}// End class

package e01_Prozesse_Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class MeinInterpreter {

	/**
	 * Ruft den Dateibrowser des Systems auf. Über die Systemeigenschaft os.name
	 * wird überprüft, welches OS gerade läuft. Wenn Windows läuft wird der
	 * Explorer gestartet, wenn Mac OS X läuft wird der Finder gestartet.
	 * 
	 */
	public void openFileBrowser() {

		// Neuen Thread innerhalb der Methode erzeugen
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

						command = "."; // Startet den Mac Finder
						p = Runtime.getRuntime().exec(
								new String[] { "open", command });
					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}// End run()
		});// End Thread

		// Thread starten
		if (!t.isAlive()) {
			t.start();
		}
	}// End Method

	public int getVirtualMemory() {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Process p = null;
				try {
					p = Runtime.getRuntime().exec("cmd /c dir");
				
					BufferedReader in = new BufferedReader(
							new InputStreamReader(p.getInputStream()));

					for (String s; (s = in.readLine()) != null;) {
						System.out.println(s);

					}

					in.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		if (t.isAlive()) {
			t.start();
		}

		return 0;
	}
}// End class

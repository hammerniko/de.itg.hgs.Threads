package e01_Prozesse_Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeinInterpreter {

	/**
	 * Ruft den Dateibrowser des Systems auf. 
	 * 
	 */
	public void openFileBrowser() {
		System.out.println("Print Dir");

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
						
					} else if(os.contains("OS X")){
						
						command = ".";
						p = Runtime.getRuntime().exec(
								new String[] { "open", command });
					}
				}

				catch (Exception e) {
					
					e.printStackTrace();
				}

			}
		});
		if(!t.isAlive()){
			t.start();
		}
		
	}

}

package e01_Prozesse_Runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MeinInterpreter implements Runnable {
	//Threadobjekt für nebenläufigen Ablauf
	private Thread t;
	
	/**
	 * Konstruktor
	 */
	public MeinInterpreter() {
		t=new Thread(this);
	}
	
	@Override
	public void run() {
		//doCommand("mspaint C:\\Users\\hr\\1.jpg");
		
		doCommand("dir");
		
		

	}
	
	/**
	 * Ruft die Eingabeaufforderung in Windows mit "cmd" auf.
	 * "/c" kennzeichnet ein Kommando welches noch übergeben wird und "Dir" ist das eigentliche Kommando
	 * für die Ausgabe eines Verzeichnisses.
	 * 
	 */
	private void doCommand(String command){
		try {
						
			//shell starten und Kommando übergeben
			Process p = Runtime.getRuntime().exec(command);
			
			//Ergebnisstream des shellkommandos aus dem Process lesen
			BufferedReader in = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			
			for(String s; (s=in.readLine())!=null;){
				System.out.println(s);
			}
			
			//Stream schliessen
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	/**
	 * Methode um Threadobjekt von aussen zu starten.
	 * Ein dirketer Start im Konstruktor ist nicht zu empfehlen,
	 * da es zu Laufzeitfehlern kommen kann.
	 * 
	 */
	public void start(){
		t.start();
	}
}

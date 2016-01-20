package c03_ThreadUhrMitGui;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Uhr implements Runnable {

	// ZUSTÄNDE
	public static final int RUNNING = 0;
	public static final int STOPPED = 1;
	private int zustand;
	
	// Assoziation
	Gui dieGui;

	// Variable und Komponenten
	boolean isAlive = false;
	Thread t;
	Date date;
	DateFormat format;
	long time;

	public Uhr(Gui gui) {
		zustand = STOPPED;
		
		dieGui = gui;
		date = new Date();
		format = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		isAlive = true;
		t = new Thread(this);
	}

	@Override
	public void run() {
		while (isAlive) {
			switch (zustand) {
			case RUNNING:
				time = System.currentTimeMillis();
				date.setTime(time);
				warteEineSekunde();
				ausgabeZeit();
				break;

			case STOPPED:
				
				
				break;
			default:
				break;
			}
		

		}

		System.out.println("ende Thread");

	}

	private void warteEineSekunde() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			stop();
		}
	}

	private void ausgabeZeit() {
		dieGui.zeigeZeit(format.format(date));

	}

	public void start() {
		zustand = RUNNING;
		if (!t.isAlive()) {
			t.start();
		} 
		else{
			
			
		}
		
		
	}

	public void stop() {
		zustand = STOPPED;
	
	}

	public void reset() {

	}
}

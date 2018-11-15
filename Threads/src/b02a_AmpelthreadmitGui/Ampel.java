package b02a_AmpelthreadmitGui;

public class Ampel implements Runnable {

	// zugehoeriges Panel
	PanelAmpel panel;

	// Konstanten fuer Zustaende
	public static final int WARTEN = 0;
	public static final int ROT = 1;
	public static final int ROTGELB = 2;
	public static final int GRUEN = 3;
	public static final int GELB = 4;
	public static final int BLINKEN = 5;
	public static final int AUS = 6;
	public static final String[] ZUSTAND_STR = { "warten...", "Rot", "RotGelb",
			"Gruen", "Gelb", "Blinken", "Aus" };

	// Variablen
	private boolean istOrangeAn = false;
	private String name = null;
	private int aktZustand = ROT;
	private int dauerRot = 0;
	private int dauerRotGelb = 0;
	private int dauerGruen = 0;
	private int dauerGelb = 0;
	private int dauerBlinken = 1000;
	private Thread t;

	public Ampel(String name, int aktZustand, int dauerRot, int dauerRotGelb,
			int dauerGruen, int dauerGelb, PanelAmpel p) {
		panel = p;

		this.name = name;

		this.aktZustand = aktZustand;
		this.dauerRot = dauerRot;
		this.dauerRotGelb = dauerRotGelb;
		this.dauerGruen = dauerGruen;
		this.dauerGelb = dauerGelb;
		setAktZustand(WARTEN);

	}

	public int getAktZustand() {
		return aktZustand;
	}

	public synchronized void setAktZustand(int aktZustand) {
		System.out.println("Threadzustand:" + aktZustand);
		this.aktZustand = aktZustand;
		
	}

	public int getDauerRot() {
		return dauerRot;
	}

	public void setDauerRot(int dauerRot) {
		this.dauerRot = dauerRot;
	}

	public int getDauerRotGelb() {
		return dauerRotGelb;
	}

	public void setDauerRotGelb(int dauerRotGelb) {
		this.dauerRotGelb = dauerRotGelb;
	}

	public int getDauerGruen() {
		return dauerGruen;
	}

	public void setDauerGruen(int dauerGruen) {
		this.dauerGruen = dauerGruen;
	}

	public int getDauerGelb() {
		return dauerGelb;
	}

	public void setDauerGelb(int dauerGelb) {
		this.dauerGelb = dauerGelb;
	}

	@Override
	public void run() {
		System.out.println("Ampel gestartet");

		while (true) {

			// Wenn eine Unterbrechung angefordert wurde
			if (t.isInterrupted())
				break;

			panel.setzeAmpel(aktZustand);
			
			// Falls keine Unterbrechung angefordert wurde
			switch (aktZustand) {
			case WARTEN:
				warte(1000);
				break;
			case ROT:
				warte(dauerRot);
				setAktZustand(ROTGELB);
				break;
			case ROTGELB:
				warte(dauerRotGelb);
				setAktZustand(GRUEN);
				break;
			case GRUEN:
				warte(dauerGruen);
				setAktZustand(GELB);
				break;
			case GELB:
				warte(dauerGelb);
				if(aktZustand!=BLINKEN){
					setAktZustand(ROT);
				}
				break;

			case BLINKEN:
				
				blinken();
				break;

			case AUS:

				break;

			}

		}// ende switch case

		t = null;

	}

	private void blinken() {
		setAktZustand(BLINKEN);		
		panel.setzeAmpel(BLINKEN);
		
		if (istOrangeAn) {
			panel.setBlinkLampe(false);
			istOrangeAn = false;
		} else {
			panel.setBlinkLampe(true);
			istOrangeAn = true;
		}
		warte(dauerBlinken);

	}

	private void warte(int dauer) {
		try {
			ausgabe();
			Thread.sleep(dauer);
		} catch (InterruptedException e) {
			// Falls versucht wurde während der Sleep Phase ein Interrupt
			// Flag zu setzen, wird die Exception ausgelöst.
			// Dannach muss das Flag erneut gesetzt werden.
			setAktZustand(AUS);
			t.interrupt();

		}
	}

	/**
	 * Ausgabe Methode
	 */
	private void ausgabe() {
		System.out.println(name + ":\t" + ZUSTAND_STR[aktZustand]);
	}

	public synchronized void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
		setAktZustand(ROT);

	}

	public void stop() {
		// Setze Flag um Ampel zu unterbrechen
		// Falls mehrfach versucht wird zu stoppen, muss
		// geprüft werden ob t noch existiert.
		if (t != null) {

			setAktZustand(AUS);
			t.interrupt();
		}
	}

}

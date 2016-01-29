package b02a_AmpelthreadmitGui;

public class Ampel implements Runnable{
	
	//zugeh�riges Panel
	PanelAmpel panel;
	
	//Konstanten fuer Zustaende
	public static final int AUS = 0;
	public static final int ROT = 1;
	public static final int ROTGELB = 2;
	public static final int GRUEN = 3;
	public static final int GELB = 4;
	public static final int BLINKEN = 5;
	public static final String[] ZUSTAND_STR = {"Aus","Rot","RotGelb","Gruen","Gelb","Blinken"};
	
	//Variablen
	private String name=null;
	private int aktZustand = ROT;
	private int dauerRot = 0;
	private int dauerRotGelb = 0;
	private int dauerGruen = 0;
	private int dauerGelb = 0;
	private int dauerBlinken = 1000;
	private Thread t;
	
	public Ampel(String name,int aktZustand, int dauerRot, int dauerRotGelb,
			int dauerGruen, int dauerGelb, PanelAmpel p) {
		panel = p;
		t=new Thread(this);
		this.name = name;
		this.aktZustand = aktZustand;
		this.dauerRot = dauerRot;
		this.dauerRotGelb = dauerRotGelb;
		this.dauerGruen = dauerGruen;
		this.dauerGelb = dauerGelb;
		
	}
	
	

	public int getAktZustand() {
		return aktZustand;
	}

	public synchronized void setAktZustand(int aktZustand) {
		System.out.println("Threadzustand ge�ndert");
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
		while(aktZustand!=AUS){
			switch (aktZustand) {
			
			case AUS:
					System.out.println("Thread wartet ");
					t.interrupt();
					break;	
				
			case ROT:			warte(dauerRot); 		aktZustand=ROTGELB;		break;
			case ROTGELB:		warte(dauerRotGelb); 	aktZustand=GRUEN;		break;
			case GRUEN:			warte(dauerGruen);		aktZustand=GELB;	    break;
			case GELB:			warte(dauerGelb);		aktZustand=ROT;			break;		

			case BLINKEN:
				while(aktZustand==BLINKEN){
					blinken();
					warte(dauerBlinken);
				}
			}//ende switch case
			
		}
		
	}
	
	private void blinken() {
		
		System.out.println(name+":\tblinken");		
	}

	private void warte(int dauer){
		try {
			ausgabe();
			panel.setzeAmpel(aktZustand);
			Thread.sleep(dauer);
		} catch (InterruptedException e) {
		
				e.printStackTrace();
			
		}
	}
	
	/**
	 * Ausgabe Methode
	 */
	private void ausgabe(){
		System.out.println(name+":\t"+ZUSTAND_STR[aktZustand]);
	}
	
	public synchronized void start(){
		if(t==null){
			t=new Thread(this);
			t.start();
		}
		else{
			t.start();
		}
		
		
	}
	
	public void stop(){
		t.stop();
		t=null;
	}

}
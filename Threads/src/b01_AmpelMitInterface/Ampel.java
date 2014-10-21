package b01_AmpelMitInterface;

public class Ampel extends Thread implements Runnable{
	
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
			int dauerGruen, int dauerGelb) {
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

	public void setAktZustand(int aktZustand) {
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
		
		while(aktZustand!=AUS){
			switch (aktZustand) {
			case AUS:break;			
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

	public void warte(int dauer){
		try {
			ausgabe();
			Thread.sleep(dauer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ausgabe Methode
	 */
	public void ausgabe(){
		System.out.println(name+":\t"+ZUSTAND_STR[aktZustand]);
	}
	
	public void start(){
		if(!t.isAlive()){
			t.start();
		}
	}

}

package Z7_HP2011A3_Pacman;

public class Pacman extends SpielFigur {

	public static final int ANZAHL_SPALTEN = 15;
	public static final int ANZAHL_ZEILEN = 9;
	public static final int ANZAHL_FRESSPUNKTE = (ANZAHL_SPALTEN*ANZAHL_ZEILEN)-1;
	
	
	FressPunkt derFresspunkt[];
	private int diePunkte;
	
	public Pacman() {
		initFresspunkte();
		
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		// TODO Auto-generated method stub

	}
	
	private void initFresspunkte(){
		derFresspunkt = new FressPunkt[ANZAHL_FRESSPUNKTE];
		
		int x,y = 0;
		
		for (int i = 0; i < derFresspunkt.length; i++) {
			x = i%ANZAHL_SPALTEN;
			y = i/ANZAHL_SPALTEN;
			System.out.println("i:"+i+" x:"+x+" y:"+y);
			derFresspunkt[i] = new FressPunkt(x, y);
		}
		
		
	}
	
	public void setzeRichtung(int pRichtung) {
		this.dieRichtung = pRichtung;
	}
	
	public void loeschePunkte() {
		diePunkte = 0;
	}
	
	public void aktualisierePunkte() {
		
		
	}
	
	

}

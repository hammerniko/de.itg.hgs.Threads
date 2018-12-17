package Z7_HP2011A3_Pacman;

public class Pacman extends SpielFigur {

	private int anzSpalten = ZeichenFlaeche.ANZAHL_SPALTEN;
	private int anzZeilen = ZeichenFlaeche.ANZAHL_ZEILEN;
	final int ANZAHL_FRESSPUNKTE = (anzSpalten*anzZeilen)-1;
	
	
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
		
		//lokale Variablen für berechnete Position im Grid
		int x,y = 0;
		
		for (int i = 0; i < derFresspunkt.length; i++) {
			
			//Berechne Position im Grid
			x = i%anzSpalten;
			y = i/anzZeilen;
			
			//Umgehe/überspringe Start-Position des Pacman in der Mitte
			if(x==anzSpalten/2 && y==anzZeilen/2) {i++;}
			
			//Erzeuge Fresspunkt mit Position für Grid
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

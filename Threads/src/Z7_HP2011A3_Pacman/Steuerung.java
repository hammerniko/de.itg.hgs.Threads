package Z7_HP2011A3_Pacman;

public class Steuerung {
	ZeichenFlaeche zf;
	Pacman pacMan;
	FressPunkt derFressPunkt[];
	
	MyTimer timer;
	
	private int anzSpalten = ZeichenFlaeche.ANZAHL_SPALTEN;
	private int anzZeilen = ZeichenFlaeche.ANZAHL_ZEILEN;
	final int ANZAHL_FRESSPUNKTE = (anzSpalten*anzZeilen)-1;
	
	
	//Deklaration der Gui, damit die Steuerung
	//eine bidirektionale Assoziation zur Gui aufbauen kann
	OberFlaeche dieOberflaeche;
	
	public Steuerung() {
		
		//Die Steuerung kennt dieOberflaeche
		//und uebergeibt sich selbst als Objekt
		//an den Konstruktor der
		//Gui, damit eine bidirektionale Assoziation
		//erstellt werden kann
		dieOberflaeche = new OberFlaeche(this); 
		initSpielObjekte();
		
	}
	
	
	private void initSpielObjekte() {
		timer = new MyTimer(this, 500);
		pacMan = new Pacman();
		derFressPunkt = new FressPunkt[ANZAHL_FRESSPUNKTE];
		
	}
	
	private void zeichneSpielObjekte() {
		zf = dieOberflaeche.gibZeichenFlaeche();
		
		
	}
	
	public void starteSpiel() {
		
	}
	
	public void verarbeiteTastenDruck(int pRichtung) {
		
	}
	
	public void tickTimer() {
		pacMan.bewege();	
		pacMan.aktualisierePunkte();
		
		
		
	}
	
	private void initFresspunkte(){
		
		
		//lokale Variablen für berechnete Position im Grid
		int x,y = 0;
		
		for (int i = 0; i < derFressPunkt.length; i++) {
			
			//Berechne Position im Grid
			x = i%anzSpalten;
			y = i/anzZeilen;
			
			//Umgehe/überspringe Start-Position des Pacman in der Mitte
			if(x==anzSpalten/2 && y==anzZeilen/2) {i++;}
			
			//Erzeuge Fresspunkt mit Position für Grid
			derFressPunkt[i] = new FressPunkt(x, y);
		}
		
		
	}
	

}

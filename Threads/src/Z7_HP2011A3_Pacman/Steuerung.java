package Z7_HP2011A3_Pacman;

public class Steuerung {
	
	ZeichenFlaeche zf;
	Pacman pacMan;
	FressPunkt derFressPunkt[];
	Geist derGeist[];
	

	MyTimer timer;
	
	private static final int ANZAHL_GEISTER = 4;
	private int anzSpalten = ZeichenFlaeche.ANZAHL_SPALTEN;
	private int anzZeilen = ZeichenFlaeche.ANZAHL_ZEILEN;
	final int ANZAHL_FRESSPUNKTE = (anzSpalten*anzZeilen)-1;
	
	
	//Deklaration der Gui, damit die Steuerung
	//eine bidirektionale Assoziation zur Gui aufbauen kann
	OberFlaeche dieOberflaeche;
	
	//Konstruktor der Steuerung
	public Steuerung() {
		erzeugeObjekte();
		
		initSpielObjekte();
	}
	
	
	private void erzeugeObjekte() {
				//Die Steuerung kennt dieOberflaeche
				//und uebergeibt sich selbst als Objekt
				//an den Konstruktor der
				//Gui, damit eine bidirektionale Assoziation
				//erstellt werden kann
				dieOberflaeche = new OberFlaeche(this); 
				
				//Erzeuge Timer mit wiederholrate der die Steuerung kennt und umgekehrt (bidirektional)
				timer = new MyTimer(this, 500);
				
				//Erzeuge Fresspunkte
				initFresspunkte();	
				
				//Erzeuge Pacman der die Fresspunkte kennt
				pacMan = new Pacman(derFressPunkt);
				
				//Erzeuge Geister die den Pacman kennen
				derGeist = new Geist[ANZAHL_GEISTER];
				for (int i = 0; i < derGeist.length; i++) {
					derGeist[i]=new Geist(pacMan);
				}
		
	}


	private void initSpielObjekte() {
		
		//Keine Bewegung
		pacMan.setzeRichtung(0);
		
		//Pacman in der Mitte positionieren
		pacMan.setzePos(7, 4);
		
		//loeschen aller Wertungspunkte
		pacMan.loeschePunkte();
		
		//Geister in die Ecken setzen
		derGeist[0].setzePos(0, 0);
		derGeist[1].setzePos(14, 0);
		derGeist[2].setzePos(0, 8);
		derGeist[3].setzePos(14, 8);
		
		//Fresspunkte auf nicht gefressen setzen
		for (int i = 0; i < derFressPunkt.length; i++) {
			derFressPunkt[i].setzeGefressen(false);
		}
		
		
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
		derFressPunkt = new FressPunkt[ANZAHL_FRESSPUNKTE];
		
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

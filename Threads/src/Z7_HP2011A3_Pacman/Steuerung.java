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
	final int ANZAHL_FRESSPUNKTE = (anzSpalten * anzZeilen) - 1;

	// Deklaration der Gui, damit die Steuerung
	// eine bidirektionale Assoziation zur Gui aufbauen kann
	OberFlaeche dieOberflaeche;

	// Konstruktor der Steuerung
	public Steuerung() {
		//Objekt für Zeichenflaeche
	    zf = new ZeichenFlaeche();
		erzeugeObjekte();
		
	}

	private synchronized void erzeugeObjekte() {
		// Die Steuerung kennt dieOberflaeche
		// und uebergeibt sich selbst als Objekt
		// an den Konstruktor der
		// Gui, damit eine bidirektionale Assoziation
		// erstellt werden kann
		dieOberflaeche = new OberFlaeche(this);
		dieOberflaeche.setZeichenflaeche(zf);
		
		

		// Erzeuge Timer mit wiederholrate der die Steuerung kennt und umgekehrt
		// (bidirektional)
		timer = new MyTimer(this, 200);

		// Erzeuge Fresspunkte
		initFresspunkte();

		// Erzeuge Pacman der die Fresspunkte kennt
		pacMan = new Pacman(derFressPunkt);

		// Erzeuge Geister die den Pacman kennen
		derGeist = new Geist[ANZAHL_GEISTER];
		for (int i = 0; i < derGeist.length; i++) {
			derGeist[i] = new Geist(pacMan);
		}
		
		

	}

	private void initSpielObjekte() {

		// Keine Bewegung
		pacMan.setzeRichtung(0);

		// Pacman in der Mitte positionieren
		pacMan.setzePos(7, 4);

		// loeschen aller Wertungspunkte
		pacMan.loeschePunkte();

		// Geister in die Ecken setzen
		derGeist[0].setzePos(0, 0);
		derGeist[1].setzePos(14, 0);
		derGeist[2].setzePos(0, 8);
		derGeist[3].setzePos(14, 8);

		// Fresspunkte auf nicht gefressen setzen
		for (int i = 0; i < derFressPunkt.length; i++) {
			derFressPunkt[i].setzeGefressen(false);
		}

		timer.starte();
	}

	private void zeichneSpielObjekte() {
		zf = dieOberflaeche.gibZeichenFlaeche();

		// Zeichne Fresspunkte
		for (int i = 0; i < derFressPunkt.length; i++) {
			derFressPunkt[i].zeichne(zf);
		}

		// Zeichne Pacman
		pacMan.zeichne(zf);

		// Zeichne Geister
		for (int i = 0; i < derGeist.length; i++) {
			derGeist[i].zeichne(zf);

		}
	}

	public void starteSpiel() {
		initSpielObjekte();
	}

	public void verarbeiteTastenDruck(int pRichtung) {

	}

	public void tickTimer() {

		System.out.println("tick");
		pacMan.bewege();
		pacMan.aktualisierePunkte();

		// Für alle Geister
		for (int i = 0; i < derGeist.length; i++) {
			derGeist[i].berechneRichtung();
			derGeist[i].bewege();

		}

		zeichneSpielObjekte();

		pruefeSpielZustand();

	}

	private void pruefeSpielZustand() {
		boolean gefressen;
		int punkte = pacMan.gibPunkte();
		dieOberflaeche.schreibePunkte(punkte);
		
		for (int i = 0; i < derGeist.length; i++) {
		gefressen = derGeist[i].pruefePacManGefressen();
			if(gefressen || punkte >=133){
			timer.stoppe();
			
			if(gefressen==false){
				dieOberflaeche.zeigeMeldung("Gratuliere, Du Hast gewonnen");
			}
			else{
				dieOberflaeche.zeigeMeldung("Du Hast verloren und "+punkte+" erreicht");
			}
				
			}
		}
		
		
	}

	private void initFresspunkte() {
		derFressPunkt = new FressPunkt[ANZAHL_FRESSPUNKTE];

		// lokale Variablen f�r berechnete Position im Grid
		int x, y = 0;

		for (int i = 0; i < derFressPunkt.length; i++) {

			// Berechne Position im Grid
			x = i % anzSpalten;
			y = i / anzZeilen;

			// Umgehe/überspringe Start-Position des Pacman in der Mitte
			// if(x==anzSpalten/2 && y==anzZeilen/2) {i++;}

			// Erzeuge Fresspunkt mit Position für Grid
			derFressPunkt[i] = new FressPunkt(x, y);
		}

	}

}

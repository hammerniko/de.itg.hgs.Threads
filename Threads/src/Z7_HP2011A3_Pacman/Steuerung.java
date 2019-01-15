package Z7_HP2011A3_Pacman;

public class Steuerung {

	//Assoziationen
	ZeichenFlaeche zf;
	Pacman pacMan;
	FressPunkt derFressPunkt[];
	Geist derGeist[];
	MyTimer timer;

	private static final int ANZAHL_GEISTER = 4;
	private int anzSpalten = ZeichenFlaeche.ANZAHL_SPALTEN;
	private int anzZeilen = ZeichenFlaeche.ANZAHL_ZEILEN;
	final int ANZAHL_FRESSPUNKTE = (anzSpalten * anzZeilen) ;

	// Deklaration der Gui, damit die Steuerung
	// eine bidirektionale Assoziation zur Gui aufbauen kann
	OberFlaeche dieOberflaeche;

	// Konstruktor der Steuerung
	public Steuerung() {
		// Objekt fuer Zeichenflaeche
		zf = new ZeichenFlaeche();
		dieOberflaeche = new OberFlaeche(this);
		dieOberflaeche.setZeichenflaeche(zf);

		erzeugeObjekte();

	}

	private void erzeugeObjekte() {
		// Die Steuerung kennt dieOberflaeche
		// und uebergeibt sich selbst als Objekt
		// an den Konstruktor der
		// Gui, damit eine bidirektionale Assoziation
		// erstellt werden kann

		// Erzeuge Fresspunkte
		initFresspunkte();

		// Erzeuge Timer mit wiederholrate der die Steuerung kennt und umgekehrt
		// (bidirektional)
		timer = new MyTimer(this, 100);

		// Erzeuge Pacman der die Fresspunkte kennt
		pacMan = new Pacman(derFressPunkt, 20);
        pacMan.setZeichenFlaeche(zf);
		
		
		// Erzeuge Geister die den Pacman kennen
		derGeist = new Geist[ANZAHL_GEISTER];
		for (int i = 0; i < derGeist.length; i++) {
			derGeist[i] = new Geist(pacMan,20);
			derGeist[i].setZeichenFlaeche(zf);
		}

	}

	private void initSpielObjekte() {

		// Keine Bewegung
		pacMan.setzeRichtung(SpielFigur.STOPP);

		// Pacman in der Mitte positionieren
		pacMan.setzePosImGrid(7, 4);

		// loeschen aller Wertungspunkte
		pacMan.loeschePunkte();

		// Geister in die Ecken setzen
		derGeist[0].setzePosImGrid(1, 0);
		derGeist[1].setzePosImGrid(14, 0);
		derGeist[2].setzePosImGrid(0, 8);
		derGeist[3].setzePosImGrid(14, 8);

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
		pacMan.setzeRichtung(pRichtung);
	}

	public void tickTimer() {

		//Keylistener abfragen
		dieOberflaeche.setFocus();
		
		//System.out.println("tick");
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
			if (gefressen || punkte >= ANZAHL_FRESSPUNKTE) {
				timer.stoppe();

				if (gefressen == false) {
					dieOberflaeche.zeigeMeldung("Gratuliere, Du Hast gewonnen");
					


				} else {
					dieOberflaeche.zeigeMeldung("Du Hast verloren und "
							+ punkte + " erreicht");
				}
				dieOberflaeche.enableStartButton();
				zf.loescheFlaeche();

			}
		}

	}

	private synchronized void initFresspunkte() {
		derFressPunkt = new FressPunkt[ANZAHL_FRESSPUNKTE];

		// lokale Variablen fuer berechnete PositionsNr im Grid
		int x = 0, y = 0;
		int xPos = 0, yPos = 0;

		for (int i = 0; i < derFressPunkt.length; i++) {

			// Berechne Positionsnr im Grid
			x = i % anzSpalten;
			y = i / anzSpalten;

			// Kontrolle der Positionen auf der Konsole
			// System.out.print("\nx: "+x+ " y:"+y);

			// Berechne echte Position auf der Zeichenflaeche
			// abhaengig von der Positionsnr
			int breite = zf.getB();
			int hoehe = zf.getH();
			int abstandX = breite / (anzSpalten + 1);
			int abstandY = hoehe / (anzZeilen + 1);

			// System.out.println("breite"+breite);
			// System.out.println("hoehe"+hoehe);
			xPos = (x + 1) * abstandX;
			yPos = (y + 1) * abstandY;

			//Groesse der Fresspunkte 
			xPos = xPos - FressPunkt.GROESSE_IN_PX/2;
			yPos = yPos - FressPunkt.GROESSE_IN_PX/2;
		

			// Erzeuge Fresspunkt mit Position fuer Grid
			derFressPunkt[i] = new FressPunkt(xPos, yPos);
		}

	}

}

package Z7_HP2011A3_Pacman;

import java.util.Random;

public class Geist extends SpielFigur {

	Pacman pacMan;

	int xPM, yPM, dX, dY, abstandZuPacman;
	int richtung;
	int timerTicks;
	int geistnr;
	static int anzahlGeister = 0;

	public Geist(Pacman pPacman, int groesse) {
		anzahlGeister++;
		geistnr = anzahlGeister;
		timerTicks = 0;
		pacMan = pPacman;
		breite = groesse;
		hoehe = groesse;

		// Anfangsbewegunsrichtung ist zufällig
		richtung = (int) (Math.random() * 4 + 1);
		
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		pZF.zeichneGeist(getPosX(), getPosY());

	}

	/**
	 * Aendert die Richtung des Geistes wenn sie geaendert werden 
	 * kann auf Hoehe eines Fresspunktes.
	 * 
	 * Gesetzt wird diese Aenderung erst, wenn die Richtung nicht mehr 
	 * geändert werden kann. D.h. ein Geist bewegt sich immer
	 * von Fresspunkt zu Fresspunkt
	 * 
	 */
	public void berechneRichtung() {
		
		//Geist ist auf Hoehe eines Fresspunktes
		if(istBeiFressPunktInXRichtung() || istBeiFressPunktInYRichtung()) {
			timerTicks++;
			
			//Ermittle evtl. neue Richtung solange der 
			//Geist auf Hoehe des Fresspunktes ist
			richtung = (int) (Math.random()*4+1);
			
			//Warte eine bestimmte Zeit, bis der Geist
			//vom Fresspunkt weg ist
			if(timerTicks>20) {
				setzeRichtung(richtung);
				timerTicks = 0;
			}
		}
		
		
		
		
		

	}

	

	public void setzeRichtung(int pRichtung) {
		this.dieRichtung = pRichtung;
	}

	public boolean pruefePacManGefressen() {
		int x, y;
		x = pacMan.getPosX();
		y = pacMan.getPosY();

		if (hatGleichePos(x, y)) {
			System.out.println("Pacman gefressen");
			return true;
		}

		return false;

	}

	public int getAbstandZuPacman() {
		// Wo ist der Pacman
		xPM = pacMan.getMiddlePosX();
		yPM = pacMan.getMiddlePosY();

		dX = xPM - getMiddlePosX();
		dY = xPM - getMiddlePosY();

		abstandZuPacman = (int) Math.sqrt(dX * dX + dY * dY);
		System.out.println(this.getClass().getSimpleName() + " Abstand:" + abstandZuPacman);

		return abstandZuPacman;
	}

}

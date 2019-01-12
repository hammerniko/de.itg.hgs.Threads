package Z7_HP2011A3_Pacman;

public class Geist extends SpielFigur {

	Pacman pacMan;
	int xPM, yPM;
	int richtung;
	int zufallsTick;

	public Geist(Pacman pPacman, int groesse) {
		pacMan = pPacman;
		breite = groesse;
		hoehe = groesse;
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		pZF.zeichneGeist(getPosX(), getPosY());

	}

	public void berechneRichtung() {

		// Wo ist der Pacman
		xPM = pacMan.getPosX();
		yPM = pacMan.getPosY();

		// Einfach zufall Richtung 1-4

		richtung = (int) (Math.random() * 4 + 1);
		zufallsTick = (int) (Math.random() * 100 + 1);

		if (zufallsTick >= 50 && zufallsTick <= 70) {
			setzeRichtung(richtung);
		}
	}

	public void setzeRichtung(int pRichtung) {
		this.dieRichtung = pRichtung;
	}

	public boolean pruefePacManGefressen() {
		int x,y;
		x = pacMan.getPosX();
		y = pacMan.getPosY();
		
		if(hatGleichePos(x, y)){
			System.out.println("Pacman gefressen");
			return true;
		}
		
		return false;
		
		
	}

}

package Z7_HP2011A3_Pacman;

import java.util.Random;

public class Geist extends SpielFigur {

	Pacman pacMan;
	
	int xPM, yPM;
	int richtung;
	int ticksToWait;

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

		//TODO Bewegung der Geister implementieren
		if(istBeiFressPunktInXRichtung()) {
			richtung = RECHTS;
			
		}
	
		if(istBeiFressPunktInYRichtung()) {
			richtung = UNTEN;
		}
		
		else {
			
			
		}
		
		setzeRichtung(richtung);
			
			
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

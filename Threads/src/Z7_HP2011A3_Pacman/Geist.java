package Z7_HP2011A3_Pacman;

import java.util.Random;

public class Geist extends SpielFigur {

	Pacman pacMan;

	int xPM, yPM,dX, dY,abstandZuPacman,alterAbstand;
	int richtung;
	

	public Geist(Pacman pPacman, int groesse) {
		pacMan = pPacman;
		breite = groesse;
		hoehe = groesse;
		richtung = (int) (Math.random() * 4 + 1);
		richtungGesetzt = false;
	}

	public void setRichtungGesetzt(boolean richtungGesetzt) {
		this.richtungGesetzt = richtungGesetzt;
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		pZF.zeichneGeist(getPosX(), getPosY());

	}

	public void berechneRichtung() {
	
		if ((istBeiFressPunktInXRichtung() || istBeiFressPunktInYRichtung()) && !richtungGesetzt ) {
			
			System.out.println("Richtung gesetzt");
			
			//Waehle zufällige RIchtung
			richtung = (int) (Math.random()*4+1);
			richtungGesetzt = true;
			setzeRichtung(richtung);
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
		
		dX = xPM-getMiddlePosX();
		dY = xPM-getMiddlePosY();
		
		abstandZuPacman = (int) Math.sqrt(dX*dX+dY*dY);
		System.out.println(this.getClass().getSimpleName()+" Abstand:"+abstandZuPacman);
		
		return abstandZuPacman;
	}

}

package Z7_HP2011A3_Pacman;

public class Geist extends SpielFigur {

	Pacman pacMan;
	int xPM,yPM;
	
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
		
		//Wo ist der Pacman
		xPM = pacMan.getPosX();
		yPM = pacMan.getPosY();
		
		
	}
	
	public boolean pruefePacManGefressen() {
		return false;
	}
	
	

}

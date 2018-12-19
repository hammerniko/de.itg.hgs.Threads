package Z7_HP2011A3_Pacman;

public class Geist extends SpielFigur {

	Pacman pacMan;
	int xPM,yPM;
	
	public Geist(Pacman pPacman) {
		pacMan = pPacman;
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		// TODO Auto-generated method stub

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

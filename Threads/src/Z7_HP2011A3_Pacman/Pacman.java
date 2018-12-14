package Z7_HP2011A3_Pacman;

public class Pacman extends SpielFigur {

	private int diePunkte;
	
	public Pacman() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		// TODO Auto-generated method stub

	}
	
	public void setzeRichtung(int pRichtung) {
		this.dieRichtung = pRichtung;
	}
	
	public void loeschePunkte() {
		diePunkte = 0;
	}
	
	public void aktualisierePunkte() {
		
	}
	
	

}

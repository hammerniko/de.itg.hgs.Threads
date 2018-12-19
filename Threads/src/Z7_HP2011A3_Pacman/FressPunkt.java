package Z7_HP2011A3_Pacman;

public class FressPunkt extends Spielelement{

	private boolean gefressen;
	
	
	//Konstruktor mit Paramtern für Oberklasse
	public FressPunkt(int pPosX, int pPosY) {
		super.setzePos(pPosX, pPosY);
	}


	public boolean gibGefressen() {
		return gefressen;
	}


	public void setzeGefressen(boolean pGefressen) {
		this.gefressen = pGefressen;
	}


	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		pZF.zeichneFresspunkte(getPosX(), getPosY());
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

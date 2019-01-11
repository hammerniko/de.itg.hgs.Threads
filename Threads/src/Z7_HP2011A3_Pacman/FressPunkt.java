package Z7_HP2011A3_Pacman;

public class FressPunkt extends Spielelement{

	private boolean gefressen;
	public static final int GROESSE_IN_PX = 5;
	
	
	
	//Konstruktor mit Paramtern für Oberklasse
	public FressPunkt(int pX, int pY) {
		super.setzePos(pX, pY);
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

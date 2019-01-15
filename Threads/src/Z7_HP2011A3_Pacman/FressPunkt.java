package Z7_HP2011A3_Pacman;

public class FressPunkt extends Spielelement{

	private boolean gefressen;
	public static final int GROESSE_IN_PX = 5;
	
	
	
	//Konstruktor mit Paramtern für Oberklasse
	public FressPunkt(int pX, int pY) {
		super.setzePos(pX, pY);
		gefressen =false;
	}


	public boolean gibGefressen() {
		return gefressen;
	}


	public void setzeGefressen(boolean pGefressen) {
		this.gefressen = pGefressen;
		
		
	}


	@Override
	public void zeichne(ZeichenFlaeche pZF) {
		if(!gefressen){
			pZF.zeichneFresspunkte(getPosX(), getPosY());
		}
		else{
			//Fresspunkt auf dem Spielfeld nehmen,
			//damit keine doppelte Kollision
			//mit einem gefressenen Fresspunkt entsteht.
			setzePos(0, 0);
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

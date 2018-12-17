package Z7_HP2011A3_Pacman;

public class FressPunkt extends SpielFigur{

	private boolean gefressen;
	
	
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

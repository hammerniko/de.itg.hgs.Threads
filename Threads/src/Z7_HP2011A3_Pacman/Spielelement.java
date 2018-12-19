package Z7_HP2011A3_Pacman;

public abstract class Spielelement {
	
	protected int posX;
	protected int posY;
	
	public void setzePos(int pPosX, int pPosY) {
		posX = pPosX;
		posY = pPosY;
	}
	
	public abstract void zeichne(ZeichenFlaeche pZF);

}

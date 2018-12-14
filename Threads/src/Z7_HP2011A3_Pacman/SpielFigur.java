package Z7_HP2011A3_Pacman;

public abstract class SpielFigur extends Spielelement {

	protected int dieRichtung; //1=rechts, 2=oben, 3=links, 4=unten

	public void setzePos(int pPosX, int pPosY) {
		super.posX = pPosX;
		super.posY = pPosY;
	}

	public void bewege() {

	}

	public boolean hatGleichePos(int pPosX, int pPosY) {
		if (this.posX == pPosX && this.posY == pPosY) {
			return true;
		} else {
			return false;
		}
	}
	
	

}

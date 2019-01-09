package Z7_HP2011A3_Pacman;

public abstract class SpielFigur extends Spielelement {

	protected int dieRichtung; 
	public static final int RECHTS = 1;
	public static final int OBEN = 2;
	public static final int LINKS = 3;
	public static final int UNTEN = 4;
	

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

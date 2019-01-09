package Z7_HP2011A3_Pacman;

public abstract class SpielFigur extends Spielelement {

	protected int dieRichtung; 
	public static final int STOPP = 0;
	public static final int RECHTS = 1;
	public static final int OBEN = 2;
	public static final int LINKS = 3;
	public static final int UNTEN = 4;
	
	private int x,y;
	public void bewege() {
		x= getPosX();
		y=getPosY();
		
		switch (dieRichtung) {
		case RECHTS:
			if(x<X_RANDRECHTS) {setzePos(x+1, y);}
			break;
		
		case LINKS:
			if(x>0) {
				setzePos(x-1, y);
			}
			break;
			
		case UNTEN:
			if(y<Y_RANDUNTEN) {
				setzePos(x, y+1);
			}
			break;
		
		case OBEN:
			if(y>0) {
				setzePos(x, y-1);
			}
			break;

		default:
			break;
		}

	}

	public boolean hatGleichePos(int pPosX, int pPosY) {
		if (this.posX == pPosX && this.posY == pPosY) {
			return true;
		} else {
			return false;
		}
	}
	
	

}

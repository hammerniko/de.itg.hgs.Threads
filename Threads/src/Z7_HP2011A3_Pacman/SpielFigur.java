package Z7_HP2011A3_Pacman;

public abstract class SpielFigur extends Spielelement {

	protected int dieRichtung; 
	public static final int STOPP = 0;
	public static final int RECHTS = 1;
	public static final int OBEN = 2;
	public static final int LINKS = 3;
	public static final int UNTEN = 4;
	
	public static final int SPEED_SLOW = 1; //px per Tick
	public static final int SPEED_MID = 3;
	public static final int SPEED_FAST = 5;
	
	
	private int x,y,xFressPunktAbstand, yFressPunkAbstand;
	/**
	 * Eine Bewegungsaenderung sollt erst erfolgen,
	 * wenn die Bahn auf dem die Fresspunkte liegen
	 * erreicht ist.
	 * Im Moment führt jede Richtungs aenderung sofort
	 * zur Änderung der Richtung
	 */
	public void bewege() {
		
		
		
		x=getPosX();
		y=getPosY();
		
		xFressPunktAbstand = zf.getB()/(ANZAHL_SPALTEN+1)+ FressPunkt.GROESSE_IN_PX/2;
		yFressPunkAbstand = zf.getH()/(ANZAHL_ZEILEN+1)- FressPunkt.GROESSE_IN_PX/2;
		
		switch (dieRichtung) {
		case RECHTS:
			if(x<X_RANDRECHTS && y%yFressPunkAbstand <= 10) {setzePos(x+SPEED_MID, y);}
			break;
		
		case LINKS:
			if(x>0  && y%yFressPunkAbstand <= 10) {
				setzePos(x-SPEED_MID, y);
			}
			break;
			
		case UNTEN:
			if(y<Y_RANDUNTEN && x%xFressPunktAbstand <=10) {
				setzePos(x, y+SPEED_MID);
			}
			break;
		
		case OBEN:
			if(y>0 && x%xFressPunktAbstand <=10) {
				setzePos(x, y-SPEED_MID);
			}
			break;

		default:
			break;
		}

	}

	public boolean hatGleichePos(int pPosX, int pPosY) {
		
		
		//Wenn x,y innerhalb des Rechtecks um die Spielfigur
		//ist, soll die Position gleich sein.
		if(this.posX >= pPosX-getBreite()/2 && this.posX <= pPosX+getBreite()/2){
			if(this.posY >= pPosY-getHoehe()/2 && this.posY <= pPosY+getHoehe()/2){
				System.out.println("Kollision");
				return true;
				
			}
		}
		
		
		return false;
	}
}

package Z7_HP2011A3_Pacman;

public abstract class SpielFigur extends Spielelement {

	protected int dieRichtung;
	public static final int STOPP = 0;
	public static final int RECHTS = 1;
	public static final int OBEN = 2;
	public static final int LINKS = 3;
	public static final int UNTEN = 4;

	public static final int SPEED_SLOW = 1; // px per Tick
	public static final int SPEED_MID = 3;
	public static final int SPEED_FAST = 5;
	public static final int MAX_ABSTAND_ZU_FRESSPUNKT = 10;
	

	private int abstandX, abstandY;

	/**
	 * Eine Bewegungsaenderung sollt erst erfolgen, wenn die Bahn auf dem die
	 * Fresspunkte liegen erreicht ist. 
	 */
	public void bewege() {

		switch (dieRichtung) {
		case RECHTS:
			if (getMiddlePosX() <= zf.getB() - getBreite() && istBeiFressPunktInYRichtung()) {
				setzePos(getPosX() + SPEED_MID, getPosY());
			}

			break;

		case LINKS:
			if (getMiddlePosX() >= 0 && istBeiFressPunktInYRichtung()) {
				setzePos(getPosX() - SPEED_MID, getPosY());
			}
			break;

		case UNTEN:
			if (getMiddlePosY() <= zf.getH() - getHoehe() && istBeiFressPunktInXRichtung()) {
				setzePos(getPosX(), getPosY() + SPEED_MID);
			}
			break;

		case OBEN:
			if (getMiddlePosY() >= 0 && istBeiFressPunktInXRichtung()) {
				setzePos(getPosX(), getPosY() - SPEED_MID);
			}
			break;

		default:
			System.out.println(this.getClass().getSimpleName() + "keine Richtung erkannt");
			dieRichtung = dieRichtung * -1;
			break;
		}

	}

	private int getAbstandY() {
		abstandY = zf.getH() / (ANZAHL_ZEILEN + 1);
		return abstandY;
	}

	private int getAbstandX() {
		abstandX = zf.getB() / (ANZAHL_SPALTEN + 1);
		return abstandX;
	}

	public boolean hatGleichePos(int pPosX, int pPosY) {

		// Wenn die Position x,y innerhalb des Rechtecks um die
		// Spielfigur ist, soll die Position gleich sein.
		if (this.getPosX() >= pPosX - getBreite() / 2 && this.posX <= pPosX + getBreite() / 2) {
			if (this.getPosY() >= pPosY - getHoehe() / 2 && this.posY <= pPosY + getHoehe() / 2) {
				System.out.println("Kollision");
				return true;

			}
		}

		return false;
	}

	public boolean istBeiFressPunktInXRichtung() {
		if (getMiddlePosX() % getAbstandX() <= MAX_ABSTAND_ZU_FRESSPUNKT) {
			
			return true;
		}

		return false;
	}

	public boolean istBeiFressPunktInYRichtung() {
		if (getMiddlePosY() % getAbstandY() <= MAX_ABSTAND_ZU_FRESSPUNKT) {
			return true;
		}

		return false;
	}
}

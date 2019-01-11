package Z7_HP2011A3_Pacman;

public abstract class Spielelement implements Grid {
	
	protected ZeichenFlaeche zf;
	
	//Position des Spielelements
	protected int posX;
	protected int posY;
	
	//Groesse des Spielelements
	protected int breite;
	protected int hoehe;
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	/**
	 * Setzt die Position absolut in px.
	 */
	public void setzePos(int pPosX, int pPosY) {
		
		posX = pPosX;
		posY = pPosY;
	}
	
	public void setzePosImGrid(int gridPosx, int gridPosY) {
					// Berechne echte Position auf der Zeichenflaeche
					// abhaengig von der Positionsnr
					int breite = zf.getB();
					int hoehe = zf.getH();
					int abstandX = breite / (Grid.ANZAHL_SPALTEN + 1);
					int abstandY = hoehe / (Grid.ANZAHL_ZEILEN + 1);
					
					// System.out.println("breite"+breite);
					// System.out.println("hoehe"+hoehe);
					posX =(gridPosx + 1) * abstandX;
					posY = (gridPosY + 1) * abstandY;
					
					posX = posX - getBreite()/2;
					posY = posY - getHoehe()/2;
					
	}
	
	public abstract void zeichne(ZeichenFlaeche pZF);

	public void setZeichenFlaeche(ZeichenFlaeche pZF) {
		zf = pZF;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}
	
}

package Z7_HP2011A3_Pacman;

public abstract class Spielelement implements Grid {
	
	protected ZeichenFlaeche zf;
	
	//Position des Spielelements zum zeichenen (linke obere Ecke)
	protected int posX;
	protected int posY;
	
	//Mittlere position des Spielelements;
	protected int xMiddle;
	protected int yMiddle;
	
	//Position im Grid
	protected int gridPosX;
	protected int gridPosY;
	
	
	//Groesse des Spielelements
	protected int breite;
	protected int hoehe;
	
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public int getMiddlePosX(){
		return posX+getBreite()/2;
	}
	
	public int getMiddlePosY(){
		return posY + getHoehe()/2;
	}

	/**
	 * Setzt die Position absolut in px.
	 * Ecke links oben
	 */
	public void setzePos(int pPosX, int pPosY) {
		
		posX = pPosX;
		posY = pPosY;
	}
	
	public void setzePosImGrid(int gridPosx, int gridPosY) {
		
					// Ermittle die Groesse der Zeichenflaeche
					int breite = zf.getB();
					int hoehe = zf.getH();
					
					//Ermittle den Abstand der Mittelpunkte der zu zeichnenden Elemente
					int abstandX = breite / (Grid.ANZAHL_SPALTEN + 1);
					int abstandY = hoehe / (Grid.ANZAHL_ZEILEN + 1);
					
					//Ermittle die Position der MittelPunkte des SpielElements
					xMiddle =(gridPosx + 1) * abstandX;
					yMiddle = (gridPosY + 1) * abstandY;
					
					//Ermittle die linke obere Ecke des Spielelements
					//damit dieses gezeichnet werden kann
					posX = xMiddle - getBreite()/2;
					posY = yMiddle - getHoehe()/2;
					
					
					
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

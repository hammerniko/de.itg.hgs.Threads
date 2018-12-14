package Z7_HP2011A3_Pacman;

public class Steuerung {
	
	//Deklaration der Gui, damit die Steuerung
	//eine bidirektionale Assoziation zur Gui aufbauen kann
	OberFlaeche dieOberflaeche;
	
	public Steuerung() {
		
		//Die Steuerung kennt dieOberflaeche
		//und übergeibt sich selbst als Objekt
		//an den Konstruktor der
		//Gui, damit eine bidirektionale Assoziation
		//erstellt werden kann
		dieOberflaeche = new OberFlaeche(this); 
	}
	
	
	private void initSpielObjekte() {
		
	}
	
	private void zeichneSpielObjekte() {
		
	}
	
	public void starteSpiel() {
		
	}
	
	public void verarbeiteTastenDruck(int pRichtung) {
		
	}
	
	public void tickTimer() {
		
	}
	

}

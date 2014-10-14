package a02_Ampel;

public class StartAmpel {
	
	public static void main(String[] args) {
		Ampel a = new Ampel("A", Ampel.ROT, 1000, 500, 2000, 700);
		Ampel b = new Ampel("B", Ampel.BLINKEN, 1000, 500, 2000, 700);
		Ampel c = new Ampel("C", Ampel.GRUEN, 3000, 1500, 2500, 1700);
		
		a.start();
		b.start();
		c.start();
	}

}

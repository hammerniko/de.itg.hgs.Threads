package b03_Autothread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class LabelAuto extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Graphics gr;
	int breite;
	int laenge;
	BufferedImage imgAuto;
	
	int x,y; //Linke untere Ecke des Autos
	int aktuellerZustand;
		
	public static final int STEHEN = 0;
	public static final int FAHREN_GERADE = 1;
	public static final int LINKS_ABBIEGEN = 2;
	public static final int RECHTS_ABBIEGEN = 3;
	
	public LabelAuto(int x, int y) {
		this.x=x;
		this.y=y;
		laenge = 100;
		breite =40;
		aktuellerZustand = STEHEN;
		
		setPreferredSize(new Dimension(laenge, breite));
		setOpaque(true);
		setDoubleBuffered(true);
		ladeImage();
	}
	
	private void ladeImage() {
		try
		{
			imgAuto= ImageIO.read(new File("Bilder\\auto.jpg")); //Schreibe in image das Bild. try ist nötig, da ImageIO eine Exception wirft. Von nun an ist image nicht mehr 'null' und es kann darauf zugegriffen werden. Backslash muss Espaped werden!
						
		}
		catch(Exception e)
		{
			e.printStackTrace(); //Schlägt das laden fehl (z. B. Datei wurde nicht gefunden) gebe den StackTrace aus. Das ist eine Liste mit den vor geraumer Zeit aufgerufenen Methoden. Denke daran dass image noch immer 'null' ist.
		}
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		this.gr = g;
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		int w = getWidth();
		int h = getHeight();
		
		g.drawLine(0, 0, 200, 200);
		g.drawImage(imgAuto,0, 0,laenge,breite,null,this);
	}
	
	

}

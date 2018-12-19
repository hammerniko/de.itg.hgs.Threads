package Z7_HP2011A3_Pacman;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ZeichenFlaeche extends JPanel{
	
	public static final int ANZAHL_SPALTEN = 15;
	public static final int ANZAHL_ZEILEN = 9;
	
	private int b;
	private int h;
	Graphics2D g2;
	
	public ZeichenFlaeche() {
		super();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// G2D Objekt erlaubt mehr Grafikoptionen als das normale Graphics Objekt
				g2 = (Graphics2D) g;

				// Liniendicke Aendern
				//g2.setStroke(new BasicStroke(LINIENDICKE));

				// Methode der Oberklasse (JComponent) ausfuehren
				super.paintComponent(g2);

				// aktuelle Breite und Hoehe merken
				b = getWidth();
				h = getHeight();

				g2.fillOval(10, 10, 5, 50);
	}
	
	public void zeichneFresspunkte(int x, int y){
		
		//g2.fillOval(x, y, 5, 50);
	}

}

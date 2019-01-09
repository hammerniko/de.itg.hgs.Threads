package Z7_HP2011A3_Pacman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class ZeichenFlaeche extends JLabel {

	public static final int ANZAHL_SPALTEN = 15;
	public static final int ANZAHL_ZEILEN = 9;

	private int spriteNr;
	private int b;
	private int h;
	Graphics2D g2;

	public ZeichenFlaeche() {
		super();
		setOpaque(true);
		setDoubleBuffered(true);
		setBackground(Color.BLUE);
		spriteNr = 0;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// G2D Objekt erlaubt mehr Grafikoptionen als das normale Graphics
		// Objekt
		g2 = (Graphics2D) g;

		// Liniendicke Aendern
		// g2.setStroke(new BasicStroke(LINIENDICKE));

		// Methode der Oberklasse (JComponent) ausfuehren
		super.paintComponent(g2);

		// aktuelle Breite und Hoehe merken
		b = this.getWidth();
		h = this.getHeight();

		// g.drawLine(0, 0, 150, 150);
	}

	public void zeichneFresspunkte(int x, int y) {
		
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, FressPunkt.GROESSE_IN_PX, FressPunkt.GROESSE_IN_PX);
	}
	
	public void zeichnePacMan(int x, int y) {
		Graphics2D g = (Graphics2D) getGraphics();
		g.setColor(Color.red);
		
		g.fillOval(x, y, 20, 20);
		g.setColor(Color.BLUE);
		
		
		spriteNr = (spriteNr + 1) % 4;
		
		
		//Pacman geht nach rechts
		switch (spriteNr) {
		case 1: g.fillArc(x, y, 20, 20, 45, -90); break;
		case 2: g.fillArc(x, y, 20, 20, 40, -85); break;
		case 3: g.fillArc(x, y, 20, 20, 30, -70); break;
		case 4: g.fillArc(x, y, 20, 20, 10, -20); break;

		default:
			break;
		}
		
		
	}

	public int getB() {
		return b;
	}

	public int getH() {
		return h;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setH(int h) {
		this.h = h;
	}
}
